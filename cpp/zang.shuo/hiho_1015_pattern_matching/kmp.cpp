#include <cstdio>
#include <cstdlib>
#include <cstdio>
#include <cstring>

//#define ONLINE_JUDGE

const int MAX_PAT = 10010;
const int MAX_S = 1000010;

int kmpCount(char *pat, char *s) {
	if (pat == NULL || s == NULL)
		return 0;
	const size_t n = strlen(pat);
	const size_t m = strlen(s);
	if (n == 0 || m == 0 || m < n)
		return 0;

	// calculate next array
	size_t next[MAX_PAT];
	next[0] = 0;
	size_t i = 1, j = 0;
	while (i < n) {
		if (pat[i] == pat[j]) {
			next[i] = j + 1;
			i += 1;
			j += 1;
		} else {
			if (j != 0) {
				j = next[j - 1];
			} else {
				next[i] = 0;
				i += 1;
			}
		}
	}

//	for (j = 0; j < n; ++j) {
//		printf("%d ", next[j]);
//	}
//	printf("\n");

// match and count
	int count = 0;
	i = 0;
	j = 0;
	while (i < m) {
		if (s[i] == pat[j] && j == n - 1) { // full match
			count += 1;
			i = i + 1;
			j = next[n - 1];
		} else if (s[i] == pat[j]) { // partial match, advance
			i += 1;
			j += 1;
		} else if (j != 0) { // failure upon partial match, recover
			j = next[j - 1];
		} else {
			i += 1;
			j = 0;
		}
	}
	return count;
}

int solve() {
	int N;
	char *pat = (char*) malloc(sizeof(char) * MAX_PAT);
	char *s = (char*) malloc(sizeof(char) * MAX_S);
	scanf("%d\n", &N);
	for (int i = 0; i < N; ++i) {
		scanf("%s\n%s\n", pat, s);
		int result = kmpCount(pat, s);
		printf("%d\n", result);
	}
	return 0;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test2.in", "r", stdin);
#endif
	solve();
}
