/*
 * �Ż����˿ռ临�Ӷȣ�����Ϊ�˷���Ƚϴ����˺ܶ���ʱ���ַ������������ٶȷ������ˡ�
 * ʱ�临�Ӷ��Ż���N2��ɨ���Ӵ���ʱ��һ��ɨһ��ά����ǰɨ���Ӵ��Ĳ��ظ���ĸ��������������ѭ����
 *
 * Ȼ����֪��Ϊʲô����汾�ȱ����㷨Ҫ�����ɴ˿ɼ�premature optimization���к��ģ��ر�����OJ�������ֱ��ʱ���Ҫ���ı����¡�
 * �Ż�ʧ�ܵ�ԭ��֮������ϸ������
 * ���£��Ż��ȽϺ������ٴ������ַ����Ժ�OJ�ϵ�ʱ����ʼ�ı����㷨�����ˣ�����Լ���1200���ַ������ɱȱ������ܶࡣ��ͷ
 * �ٷ���ԭ��ɡ�
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
