/*
 * 这道题目的核心思想是要取得最长连续提交日，则补的断点一定是连续的，否则补不连续的两段一定不如补一段效果好，因此只需要扫描一遍即可。
 * 如果想成背包问题那样从小到大扩展解用动归解决，就想复杂了无法解决。
 */

#include <cstdio>
#include <cstdlib>
#include <cstdio>

#define ONLINE_JUDGE

const int TOTAL_DAYS = 100;
const int MAX_BUFFER = 110;

int getBreakDay(int* a, int n, int index) {
	if (index >= 0 && index < n)
		return a[index];
	else if (index < 0)
		return 0;
	else
		return TOTAL_DAYS+1; // 第100天如果没有显式未提交则它是提交日
}

int calcMaxSeq(int* a, int n, int m) {
	int max=0;
	if (m >= n)
		return 100;
	for (int i = 0; i <= n - m; ++i) {
		int previousBreakDay=getBreakDay(a, n, i-1);
		int nextBreakDay=getBreakDay(a, n, i+m);
		int seq=nextBreakDay-previousBreakDay-1;
		if (seq>max)
			max=seq;
	}
	return max;
}

bool solve() {
	int numCases;
	int n, m; // N天缺勤，M张卡，一共100天
	int a[MAX_BUFFER];
	if (scanf("%d\n", &numCases) == EOF)
		return false;
	for (int i = 0; i < numCases; ++i) {
		if (scanf("%d %d\n", &n, &m) != 2)
			return false;
		for (int j = 0; j < n; ++j) {
			scanf("%d", &a[j]);
		}
		int result = calcMaxSeq(a, n, m);
		printf("%d\n", result);
	}
	return true;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
	solve();
}
