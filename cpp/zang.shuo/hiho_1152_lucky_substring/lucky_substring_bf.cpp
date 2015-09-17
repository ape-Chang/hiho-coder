/*
 * ��Brute Force�ⷨ��Ұ�����������棺
 * 1��N3��ʱ�临�Ӷȣ����������Ӵ�Ȼ��ÿ���Ӵ�˳��ɨ��һ�顣
 * 2��N3�Ŀռ临�Ӷȣ�ÿ���Ӵ����Ž�һ��set���棬�������Դ��������ȥ�ع��ܽ������������ȥ�ء�
 *
 * Ҫ�Ż�ʱ�临�Ӷȣ�ɨ���Ӵ���ʱ����ѭ��ά����ǰɨ�����Ӵ��Ĳ��ظ���ĸ������
 * Ҫ�Ż��ռ临�Ӷȣ�ֻ����lucky���ַ��Ӵ���ʼ�ͽ��������꣬�����Լ�ʵ��һ���ȽϺ�������
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
