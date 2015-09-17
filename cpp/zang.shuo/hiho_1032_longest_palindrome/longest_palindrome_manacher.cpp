#include <cstdio>
#include <cstdlib>
#include <cstdio>
#include <cstring>

//#define ONLINE_JUDGE

const int BUF_SIZE = 1000010;

int longest_palindrome(char *buf) {
	int id, mx;
	int *p = (int*) malloc(sizeof(int) * BUF_SIZE * 2);
	char *s = (char*) malloc(sizeof(char) * BUF_SIZE * 2);

	// 初始化s，s为原始字符串中每两个字符之间插入一个#
	// 例如abc 对应的s为 a#b#c
	int origLen = strlen(buf);
	int sLen = 2 * (origLen - 1) + 1;
	for (int i = 0; i < origLen - 1; ++i) {
		s[2 * i] = buf[i];
		s[2 * i + 1] = '#';
	}
	s[2 * (origLen - 1)] = buf[origLen - 1];
	s[2 * (origLen - 1) + 1] = '\0';

	for (int i = 0; i < sLen; ++i)
		p[i] = 0;

	// id为当前最先发现的右边界最靠右的回文串的中心，mx为该回文串的半径，该回文串为[id-mx, id+mx]，闭区间
	id = -1;
	mx = 0;

	// 下面计算p[i]
	for (int i = 0; i < sLen; ++i) {
		int mir = 2 * id - i;
		if (id + mx < i) { // i没有落在id为中心的回文串里，直接以i为中心扩展
			p[i] = 0;
			id = i;
			mx = 0;
			int j = 1;
			while (i + j < sLen && i - j >= 0 && s[i - j] == s[i + j]) {
				mx = j;
				p[i] = j;
				j++;
			}
		} else if (i + p[mir] < id + mx) { // 镜像的回文串被万全包含在大回文串内
			p[i] = p[mir];
		} else if (i + p[mir] > id + mx) {
			p[i] = id + mx - i;
		} else if (i + p[mir] == id + mx) {
			p[i] = p[mir];
			int j = p[mir] + 1;
			while (i + j < sLen && i - j >= 0 && s[i - j] == s[i + j]) {
				id = i;
				mx = j;
				p[i] = j;
				j++;
			}
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

	delete p;
	delete s;
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
