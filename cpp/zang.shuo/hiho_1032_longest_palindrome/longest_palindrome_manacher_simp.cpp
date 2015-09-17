#include <cstdio>
#include <cstdlib>
#include <cstdio>
#include <cstring>
#include <algorithm>

//#define ONLINE_JUDGE

const int BUF_SIZE = 1000010;
char buf[BUF_SIZE];
int p[BUF_SIZE * 2];
char s[BUF_SIZE * 2];

int longest_palindrome(char *buf) {
	int id, mx;

	// 初始化s，s为原始字符串中每两个字符之间插入一个#，开头插入一个$
	// 例如abc 对应的s为 $a#b#c
	int origLen = strlen(buf);
	if (origLen == 0)
		return 0;

	// 插入特殊字符
	s[0] = '$';
	int curP = 1;
	int sLen;
	for (int i = 0; i < origLen - 1; ++i) {
		s[curP] = buf[i];
		s[curP + 1] = '#';
		curP += 2;
	}
	s[curP] = buf[origLen - 1];
	s[curP + 1] = '\0';
	sLen = curP + 1;

	for (int i = 0; i < sLen; ++i) {
		p[i] = 0;
	}
	id = 0;
	mx = 0;

	for (int i = 1; i < sLen; ++i) {
		if (id + mx > i) {
			p[i] = std::min(p[2 * id - i], id + mx - i);
		} else {
			p[i] = 0;
		}
		while (s[i - p[i] - 1] == s[i + p[i] + 1])
			p[i] += 1;
		if (i + p[i] > id + mx) {
			id = i;
			mx = p[i];
		}
	}

	int maxres = 0;
	for (int i = 1; i < sLen; ++i) {
		int result;
		if (s[i] == '#') {
			result = 2 * (p[i] / 2 + p[i] % 2);
		} else {
			result = 2 * (p[i] / 2) + 1;
		}
		if (maxres < result)
			maxres = result;
	}

	return maxres;
}

int solve() {
	// solve the problem!
	int N;
	char *buf = (char*) malloc(sizeof(char) * BUF_SIZE);
	scanf("%d\n", &N);
	for (int i = 0; i < N; ++i) {
		scanf("%s\n", buf);
		int result = longest_palindrome(buf);
		printf("%d\n", result);
	}
	delete buf;
	return 0;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
	solve();
	return 0;
}
