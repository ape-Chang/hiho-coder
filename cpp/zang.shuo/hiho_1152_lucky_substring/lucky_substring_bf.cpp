/*
 * 纯Brute Force解法，野蛮在两个方面：
 * 1、N3的时间复杂度，遍历所有子串然后每个子串顺序扫描一遍。
 * 2、N3的空间复杂度，每个子串都放进一个set里面，利用它自带的排序和去重功能解决输出的排序和去重。
 *
 * 要优化时间复杂度，扫描子串的时候内循环维护当前扫过的子串的不重复字母个数。
 * 要优化空间复杂度，只保存lucky的字符子串开始和结束点坐标，并且自己实现一个比较函数对象。
 */
#include <cstdio>
#include <cstdlib>
#include <cstdio>
#include <cstring>
#include <set>
#include <string>

//#define ONLINE_JUDGE

using std::set;
using std::string;
const int BUF_SIZE = 10500;
const int ALPHABET_SIZE = 26;

//typedef struct Seq {
//	size_t begin;
//	size_t end;
//	Seq(int b, int e) :
//			begin(b), end(e) {
//	}
//	;
//} Seq; // 0-based index of substring [begin, end)
//
//vector<Seq> lucky;

set<string> lucky;
bool isFeb[ALPHABET_SIZE + 1];

void initFeb() {
	for (int i = 0; i <= 26; ++i) {
		isFeb[i] = false;
	}
	isFeb[1] = isFeb[2] = isFeb[3] = isFeb[5] = isFeb[8] = isFeb[13] =
			isFeb[21] = true;
}

bool isLucky(char* buf, int begin, int end) {
	bool letterFound[ALPHABET_SIZE];
	int numLetter = 0;
	for (int i = 0; i < ALPHABET_SIZE; ++i)
		letterFound[i] = false;
	for (int i = begin; i < end; ++i) {
		char curLetter = buf[i];
		if (!letterFound[curLetter - 'a']) {
			numLetter += 1;
			letterFound[curLetter - 'a'] = true;
		}
	}
	if (isFeb[numLetter])
		return true;
	else return false;
}

void printAllLuckySubstring(char* buf) {
	int len = strlen(buf);
	for (int i = 0; i < len; ++i) {
		for (int j = i+1; j <= len; ++j) {
			if (isLucky(buf, i, j)) {
				lucky.insert(string(buf+i, j-i));
			}
		}
	}

	std::set<string>::iterator iter=lucky.begin();
	for(;iter!=lucky.end();++iter){
		printf("%s\n", (*iter).c_str());
	}
}

int solve() {
	char buf[BUF_SIZE];
	scanf("%s", buf);
	initFeb();
	printAllLuckySubstring(buf);
	return 0;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
	solve();
}
