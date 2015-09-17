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

	// ��ʼ��s��sΪԭʼ�ַ�����ÿ�����ַ�֮�����һ��#
	// ����abc ��Ӧ��sΪ a#b#c
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

	// idΪ��ǰ���ȷ��ֵ��ұ߽���ҵĻ��Ĵ������ģ�mxΪ�û��Ĵ��İ뾶���û��Ĵ�Ϊ[id-mx, id+mx]��������
	id = -1;
	mx = 0;

	// �������p[i]
	for (int i = 0; i < sLen; ++i) {
		int mir = 2 * id - i;
		if (id + mx < i) { // iû������idΪ���ĵĻ��Ĵ��ֱ����iΪ������չ
			p[i] = 0;
			id = i;
			mx = 0;
			int j = 1;
			while (i + j < sLen && i - j >= 0 && s[i - j] == s[i + j]) {
				mx = j;
				p[i] = j;
				j++;
			}
		} else if (i + p[mir] < id + mx) { // ����Ļ��Ĵ�����ȫ�����ڴ���Ĵ���
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
