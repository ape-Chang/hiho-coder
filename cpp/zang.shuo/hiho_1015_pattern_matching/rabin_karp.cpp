#include <cstdio>
#include <cstdlib>
#include <cstdio>
#include <cstring>

//#define ONLINE_JUDGE

const int MAX_PAT = 10010;
const int MAX_S = 1000010;

const int P = 6999997;
const int ALPHA = 256;
int ALPHA_POWER[MAX_PAT];

void initPowerP() {
	ALPHA_POWER[0] = 1;
	for (int i = 1; i < MAX_PAT; ++i) {
		ALPHA_POWER[i] = (ALPHA_POWER[i - 1] * ALPHA) % P;
	}
}

bool validate(char *pat, char *s, int start) {
	const int lenPat = strlen(pat);
	for (int i = 0; i < lenPat; ++i) {
		if (pat[i] != s[start + i])
			return false;
	}
	return true;
}

int rabin_karp_count(char *pat, char *s) {
	if (pat == NULL || s == NULL)
		return 0;
	const int lenPat = strlen(pat);
	const int lenS = strlen(s);
	int count = 0;
	if (lenS == 0 || lenPat == 0 || lenS < lenPat)
		return 0;

	int hashPat = 0;
	for (int i = 0; i < lenPat; ++i) {
		hashPat = (hashPat + ALPHA_POWER[lenPat - 1 - i] * pat[i]) % P;
	}

	int hash = 0;
	for (int i = 0; i < lenPat; ++i) {
		hash = (hash + ALPHA_POWER[lenPat - 1 - i] * s[i]) % P;
	}
	if (hash == hashPat)
		count += validate(pat, s, 0);

	for (int i = 1; i <= lenS - lenPat; ++i) {
		hash = (hash * ALPHA) % P;
		hash = (hash - (ALPHA_POWER[lenPat] * s[i - 1]) % P + P) % P;
		hash = (hash + s[i + lenPat - 1]) % P;

		if (hash == hashPat)
			count += validate(pat, s, i);
	}
	return count;
}

int solve() {
	int N;
	char *pat = (char*) malloc(sizeof(char) * MAX_PAT);
	char *s = (char*) malloc(sizeof(char) * MAX_S);
	scanf("%d\n", &N);
	if (N != 0)
		initPowerP();
	for (int i = 0; i < N; ++i) {
		scanf("%s\n%s\n", pat, s);
		int result = rabin_karp_count(pat, s);
		printf("%d\n", result);
	}
	return 0;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
	solve();
}
