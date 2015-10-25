// hihocoder1014.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"


// hihocodertrie.cpp : Defines the entry point for the console application.
//

#include<string>
#include<iostream>
#pragma warning (disable:4996)
using namespace std;
struct trie_node {
	bool isstr;
	trie_node* next[26];
	int count;
	trie_node()
	{
		count = 0;
		isstr = false;
		for (int i = 0; i < 26; i++)
			next[i] = NULL;
	}

};
void insert(trie_node *root, string str)
{
	int len = str.length();
	trie_node *cur = root;
	for (int i = 0; i < len; i++)
	{
		if (cur->next[str[i] - 'a'] != NULL)
		{
			cur->count++;
			cur = cur->next[str[i] - 'a'];
		}
		else
		{
			cur->count++;
			cur->next[str[i] - 'a'] = new trie_node();
			cur = cur->next[str[i] - 'a'];
		}
		if (i == len - 1) { cur->isstr = true; cur->count++; }


	}

}
int find(trie_node *root, string str)
{
	int len = str.length();
	trie_node *cur = root;
	for (int i = 0; i < len; i++)
	{
		if (cur->next[str[i] - 'a'] != NULL)
		{
			cur = cur->next[str[i] - 'a'];
		}
		else
		{
			return 0;
		}
		if (i == len - 1) return cur->count;
	}

}

int main()
{
	freopen("data.in", "r", stdin);
	int n, m;
	while (cin >> n)
	{
		trie_node* root = new trie_node();
		for (int i = 0; i < n; i++)
		{
			string trs;
			cin >> trs;
			insert(root, trs);
		}
		cin >> m;
		for (int i = 0; i < n; i++)
		{
			string trs;
			cin >> trs;
			cout << find(root, trs) << endl;
		}
	}

	return 0;
}


