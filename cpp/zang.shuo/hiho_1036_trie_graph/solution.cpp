//============================================================================
// Name        : hiho_1014_trie.cpp
// Author      : 
// Version     :
// Copyright   : 
// Description : Hello World in C, Ansi-style
//============================================================================

//#define ONLINE_JUDGE

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <queue>
#include <vector>

using std::queue;
using std::vector;

const int ALPHABET_SIZE = 26;
const int BUFFER_SIZE = 1000010;

struct TrieNode {
	bool isMarked;
	TrieNode *children[ALPHABET_SIZE];
	TrieNode *parent;
	TrieNode *suffix;
	char ch;
	TrieNode(char ch, TrieNode *parent) :
			isMarked(false), parent(parent), suffix(NULL), ch(ch) {
		for (int i = 0; i < ALPHABET_SIZE; ++i) {
			children[i] = NULL;
		}
	}
};

class Trie {
private:
	TrieNode *root;
	vector<TrieNode*> allNodes;
	TrieNode* getNewNode(char ch, TrieNode *parent);

public:
	Trie() {
		root = getNewNode('#', NULL);
	}
	~Trie() {
		for(size_t i=0;i<allNodes.size();++i){
			delete allNodes[i];
		}
	}
	bool insert(char *word); // 插入Tried树
	void prepare(); // 准备Trie图的后缀节点数据
	bool scan(char *text); // 扫描文本寻找词典匹配
};

bool Trie::insert(char *word) {
	TrieNode* curNode = root;
	int wordLen = strlen(word);

	// check if the word is valid
	for (int i = 0; i < wordLen; ++i)
		if (word[i] < 'a' || word[i] > 'z')
			return false;

	for (int i = 0; i < wordLen; ++i) {
		int trieChildIndex = word[i] - 'a';
		if (curNode->children[trieChildIndex] == NULL) {
			curNode->children[trieChildIndex] = getNewNode(word[i], curNode);
			curNode = curNode->children[trieChildIndex];
		} else {
			curNode = curNode->children[trieChildIndex];
		}
	}
	curNode->isMarked = true;
	return true;
}

void Trie::prepare() {
	TrieNode *curNode;
	char curChar;
	queue<TrieNode*> b;

	root->suffix = NULL; // 只有root的suffix为NULL
	for (int i = 0; i < ALPHABET_SIZE; ++i) {
		if (root->children[i] != NULL) {
			b.push(root->children[i]);
		} else {
			root->children[i] = root;
		}
	}
	while (!b.empty()) {
		curNode = b.front();
		curChar = curNode->ch;
		b.pop();
		for (int i = 0; i < ALPHABET_SIZE; ++i) {
			if (curNode->children[i] != NULL) {
				b.push(curNode->children[i]);
			}
		}

		// 寻找curNode的后缀节点
		if (curNode->parent->suffix == NULL) { // 现在只有第一层节点会触发这一条判断，而不是递归穿过第一层的所有节点
			curNode->suffix = root;
		} else {
			curNode->suffix = curNode->parent->suffix->children[curChar - 'a'];
		}
		if (curNode->suffix->isMarked) {
			curNode->isMarked = true;
		}

		// 计算所有伪边
		for (int i = 0; i < ALPHABET_SIZE; ++i) {
			if (curNode->children[i] == NULL) {
				curNode->children[i] = curNode->suffix->children[i];
			}
		}
	}
}

bool Trie::scan(char *text) {
	size_t i = 0;
	size_t n = strlen(text);
	TrieNode *curNode = root;
	while (i < n) {
		char curChar = text[i];
		if (curNode->children[curChar - 'a'] != NULL) {
			curNode = curNode->children[curChar - 'a'];
			i += 1;
			if (curNode->isMarked) {
				return true;
			}
		} else {
			if (curNode != root) {
				curNode = curNode->suffix;
			} else {
				i += 1;
			}
		}
	}
	return false;
}

TrieNode* Trie::getNewNode(char ch, TrieNode *parent){
	TrieNode *newNode = new TrieNode(ch, parent);
	allNodes.push_back(newNode);
	return newNode;
}

bool solve() {
	int numWords;
	char buffer[BUFFER_SIZE];
	bool hasHexieWord = false;
	Trie* trie = new Trie();

	if (scanf("%d\n", &numWords) != 1) {
		delete trie;
		return false;
	}
	for (int i = 0; i < numWords; ++i) {
		if (scanf("%s\n", buffer) == EOF)
			return false;
		trie->insert(buffer);
	}

	if (scanf("%s\n", buffer) == EOF) {
		delete trie;
		return false;
	} else {
		trie->prepare();
		hasHexieWord = trie->scan(buffer);
		if (hasHexieWord)
			printf("%s\n", "YES");
		else
			printf("%s\n", "NO");
	}

	delete trie;
	return true;
}

int main(int argc, char** argv) {
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
	bool isSuccessful = solve();
	if (isSuccessful)
		return EXIT_SUCCESS;
	else
		return EXIT_FAILURE;
}
