//============================================================================
// Name        : hiho_1014_trie.cpp
// Author      : 
// Version     :
// Copyright   : 
// Description : Hello World in C, Ansi-style
//============================================================================

#define DEBUG_FREOPEN

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

const int ALPHABET_SIZE = 26;
const int BUFFER_SIZE = 11;

typedef struct TrieNode {
	bool isTerminal;
	char ch;
	int prefixCount; // number of word under the prefix represented by this node
	TrieNode* children[ALPHABET_SIZE];
	TrieNode(char ch) :
			isTerminal(false), ch(ch), prefixCount(0) {
		//memset(children, 0, sizeof(children));
		for(int i=0;i<ALPHABET_SIZE;++i)
			children[i]=NULL;
	}

} TrieNode;

class Trie {
private:
	TrieNode* root;
	void destroySubTrie(TrieNode* root);

public:
	Trie() {
		root = new TrieNode('\0');
	}
	~Trie() {
		destroySubTrie(root);
	}
	bool insert(char* word);
	bool check(char* word);
	int getPrefixCount(char* prefix);
};

void Trie::destroySubTrie(TrieNode* root) {
	if (root == NULL)
		return;
	else {
		for (int i = 0; i < ALPHABET_SIZE; ++i)
			destroySubTrie(root->children[i]);
		delete (root);
	}
}

bool Trie::insert(char* word) {
	//printf("Trie::insert %s\n", word);
	TrieNode* curNode = root;
	int wordLen = strlen(word);

	// check if the word is valid
	for (int i = 0; i < wordLen; ++i)
		if (word[i] < 'a' || word[i] > 'z')
			return false;

	root->prefixCount += 1;
	for (int i = 0; i < wordLen; ++i) {
		int trieChildIndex = word[i] - 'a';
		if (curNode->children[trieChildIndex] == NULL) {
			curNode->children[trieChildIndex] = new TrieNode(word[i]);
			curNode = curNode->children[trieChildIndex];
		} else {
			curNode = curNode->children[trieChildIndex];
		}
		curNode->prefixCount += 1;
	}
	curNode->isTerminal = true;
	return true;
}

bool Trie::check(char* word) {
	TrieNode* curNode = root;
	int wordLen = strlen(word);

	// check if the word is valid
	for (int i = 0; i < wordLen; ++i)
		if (word[i] < 'a' || word[i] > 'z')
			return false;

	for (int i = 0; i < wordLen; ++i) {
		int trieChildIndex = word[i] - 'a';
		if (curNode->children[trieChildIndex] == NULL)
			return false;
		else
			curNode = curNode->children[trieChildIndex];
	}
	if (curNode->isTerminal)
		return true;
	else
		return false;
}

int Trie::getPrefixCount(char* prefix) {
	TrieNode* curNode = root;
	int wordLen = strlen(prefix);

	// check if the word is valid
	for (int i = 0; i < wordLen; ++i)
		if (prefix[i] < 'a' || prefix[i] > 'z')
			return -1;

	for (int i = 0; i < wordLen; ++i) {
		int trieChildIndex = prefix[i] - 'a';
		if (curNode->children[trieChildIndex] == NULL)
			return 0;
		else
			curNode = curNode->children[trieChildIndex];
	}
	return curNode->prefixCount;
}

bool solve() {
	int numWords;
	int numQueries;
	char buffer[BUFFER_SIZE];
	Trie* trie = new Trie();

	if (scanf("%d\n", &numWords) != 1)
		return false;
	for (int i = 0; i < numWords; ++i) {
		if (scanf("%s\n", buffer) == EOF)
			return false;
		trie->insert(buffer);
	}

	if (scanf("%d\n", &numQueries) != 1)
		return false;
	for (int i = 0; i < numQueries; ++i) {
		if (scanf("%s\n", buffer) == EOF)
			return false;
		int prefixCount = trie->getPrefixCount(buffer);
		//printf("Prefix %s exist in %d words\n", buffer, prefixCount);
		printf("%d\n", prefixCount);
	}

	return true;
}

int main(int argc, char** argv) {
#ifdef DEBUG_FREOPEN
	freopen("test.in", "r", stdin);
#endif
	bool isSuccessful = solve();
	if (isSuccessful)
		return EXIT_SUCCESS;
	else
		return EXIT_FAILURE;
}
