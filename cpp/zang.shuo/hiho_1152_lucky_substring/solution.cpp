/*
 * 优化掉了空间复杂度，但是为了方便比较创建了很多临时的字符串对象，所以速度反倒慢了。
 * 时间复杂度优化到N2，扫描子串的时候一边扫一边维护当前扫过子串的不重复字母个数，避免三层循环。
 *
 * 然而不知道为什么这个版本比暴力算法要慢。由此可见premature optimization是有害的，特别是在OJ比赛这种编程时间很要命的背景下。
 * 优化失败的原因之后再详细分析。
 * 更新：优化比较函数不再创建子字符串以后，OJ上的时间跟最开始的暴力算法差不多快了，大测试集（1200个字符）依旧比暴力慢很多。回头
 * 再分析原因吧。
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

typedef struct Seq {
	size_t begin;
	size_t end;
	Seq(int b, int e) :
			begin(b), end(e) {
	}
	;
} Seq; // 0-based index of substring [begin, end)

typedef struct SeqComp {
	char *buf;
	SeqComp(char *buf) :
			buf(buf) {
	}
	;
	bool operator()(Seq l, Seq r) {
		int offset = 0;
		while (l.begin + offset < l.end && r.begin + offset < r.end) {
			if (buf[l.begin + offset] != buf[r.begin + offset])
				return buf[l.begin + offset] < buf[r.begin + offset];
			offset += 1;
		}
		return l.end - l.begin < r.end - r.begin;
	}
} SeqComp;

bool isFeb[ALPHABET_SIZE + 1];

void initFeb() {
	for (int i = 0; i <= 26; ++i) {
		isFeb[i] = false;
	}
	isFeb[1] = isFeb[2] = isFeb[3] = isFeb[5] = isFeb[8] = isFeb[13] =
			isFeb[21] = true;
}

void printAllLuckySubstring(char* buf) {
	int len = strlen(buf);
	SeqComp comp(buf);
	set<Seq, SeqComp> lucky(comp);
	bool letterFound[ALPHABET_SIZE];
	int numLetter;

	for (int i = 0; i < len; ++i) {
		for (int k = 0; k < ALPHABET_SIZE; ++k)
			letterFound[k] = false;
		numLetter = 0;
		for (int j = i; j < len; ++j) {
			char curLetter = buf[j];
			if (!letterFound[curLetter - 'a']) {
				numLetter += 1;
				letterFound[curLetter - 'a'] = true;
			}
			if (isFeb[numLetter]) {
				lucky.insert(Seq(i, j + 1));
			}
		}
	}

	std::set<Seq>::iterator iter = lucky.begin();
	char outBuf[BUF_SIZE];
	for (; iter != lucky.end(); ++iter) {
		int curBegin = (*iter).begin;
		int curEnd = (*iter).end;
		strncpy(outBuf, buf + curBegin, curEnd - curBegin);
		outBuf[curEnd - curBegin] = '\0';
		printf("%s\n", outBuf);
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
