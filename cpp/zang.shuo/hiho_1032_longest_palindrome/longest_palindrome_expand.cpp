#include <cstdio>
#include <cstdlib>
#include <cstring>

//#define ONLINE_JUDGE

const size_t BUF_SIZE = 1000000 + 1000;

/*
 * Expand around the pivot to find the longest palindrome around it.
 * pivotL and pivotR are both included as the pivot
 */
int expandPalin(char* in, int pivotL, int pivotR) {
	int curPalinLength;
	int inputLength = strlen(in);
	if (pivotL < 0 || pivotL >= inputLength || pivotR < 0
			|| pivotR >= inputLength)
		return 0;
	if (pivotL == pivotR)
		curPalinLength = 1;
	else if (in[pivotL] == in[pivotR])
		curPalinLength = 2;
	else
		return 0;

	int d = 1;
	while (pivotL - d >= 0 && pivotR + d < inputLength
			&& in[pivotL - d] == in[pivotR + d]) {
		curPalinLength += 2;
		d += 1;
	}
	return curPalinLength;
}

int min(int x, int y) {
	return (x <= y) ? x : y;
}

int upperBound(int inputLength, int pivotL, int pivotR) {
	if (pivotR != pivotL && pivotR != pivotL + 1)
		return 0;
	else if (pivotL == pivotR) {
		return 1 + 2 * min(pivotL, inputLength - 1 - pivotL);
	} else {
		return 2 + 2 * min(pivotL, inputLength - 1 - pivotR);
	}
}

/*
 * 尝试更新curMax。首先检查upperBound，如果上限低于curMax则立即返回，否则尝试展开回文串并比较长度是否大于curMax，如果是则更新其指向的值
 */
void tryUpdate(int* curMax, char* in, int pivotL, int pivotR){
	if (upperBound(strlen(in), pivotL, pivotR)<=*curMax) return;
	else{
		int longestPal=expandPalin(in, pivotL, pivotR);
		if (longestPal>*curMax) *curMax=longestPal;
	}
}

size_t calcLongestPalindromeLength(char* in) {
	int inputLength = strlen(in);
	int curMax = 1;
	int middle = inputLength / 2;

	for (int i = 0; i <= middle; ++i) {
		tryUpdate(&curMax, in, middle-i, middle-i);
		tryUpdate(&curMax, in, middle+i, middle+i);
	}

	for (int i = 0; i <= middle; ++i) {
		tryUpdate(&curMax, in, middle-i, middle-i+1);
		tryUpdate(&curMax, in, middle+i, middle+i+1);
	}

//	for (int i = 0; i < inputLength; ++i) {
//		int longestPal = expandPalin(in, i, i);
//		if (longestPal > curMax)
//			curMax = longestPal;
//	}
//	for (int i = 0; i < inputLength - 1; ++i) {
//		int longestPal = expandPalin(in, i, i + 1);
//		if (longestPal > curMax)
//			curMax = longestPal;
//	}
	return curMax;
}

bool solve() {
	int numProb;
	char* buffer = (char*) malloc(sizeof(char) * BUF_SIZE);
	int curResult;
	if (scanf("%d\n", &numProb) == EOF)
		return false;
	for (int i = 0; i < numProb; ++i) {
		scanf("%s\n", buffer);
		curResult = calcLongestPalindromeLength(buffer);
		printf("%d\n", curResult);
	}
	free(buffer);
	return true;
}

int main(void) {
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
	solve();
	return EXIT_SUCCESS;
}
