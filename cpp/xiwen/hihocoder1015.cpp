// hihocoder1015.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

#include<vector>
#include<iostream>
#include<string>
#pragma warning(disable:4996) 
using namespace std;
int f_next(string str, vector<int> next, int j)
{
	if (j == 0) return -1;
	int i = next[j - 1];
	if (str[i + 1] == str[j]) return i + 1;
	while (i >= 0 && str[i + 1] != str[j]) i = next[i];
	if (str[i + 1] == str[j]) return i+1;
	else
		return 0;

}
int main()
{
	freopen("data.in", "r", stdin);
	int n;
	cin >> n;
	while (n--){
		string pattern;
		string orignal;
		cin>> pattern >> orignal;
		int p_len = pattern.length(),o_len=orignal.length();
		if (p_len > o_len) { cout << "0"; continue; }
		vector<int> next(p_len, -1);
		for (int i = 0; i < p_len; i++)
		{
			next[i] = f_next(pattern, next, i);
		}
		int cur = 0;
		int count = 0,run=0;
		while (cur < o_len)
		{
			while (run<p_len&&pattern[run] == orignal[cur]){ cur++; run++; }
			if (run == p_len) { count++; run =next[run]+1; }
			else
			{
				if (run>0)
				run = next[run - 1] + 1;
				else
				{
					cur++;
					run = 0;
					continue;
				}
			}
		}
		cout << count<<endl;
	}
	return 0;
}