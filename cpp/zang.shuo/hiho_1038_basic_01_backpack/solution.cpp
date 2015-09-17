#include <cstdio>
#include <cstdlib>
#include <cstdio>
#include <cstring>
#include <algorithm>

using std::max;

//#define ONLINE_JUDGE

const int MAX_N = 505;
const int MAX_M = 100005;

int c[MAX_N];
int v[MAX_N];
int d[MAX_M];

int backpack(int N, int M) {
	d[0] = 0;
	for (int j = 1; j <= M; ++j) {
		d[j] = 0; // 不需要装满，如果需要装满则d[k]=-INF，k>0
	}
	for (int i = 0; i < N; ++i) {
		//for (int j = c[i]; j <= M; ++j)  // 用于完全背包
		for (int j = M; j >= c[i]; --j) {
			d[j] = max(d[j], d[j - c[i]] + v[i]);
		}
	}
	return d[M];
}

int solve() {
	int N, M;
	if (scanf("%d %d\n", &N, &M) != 2) {
		return 1;
	}
	for (int i = 0; i < N; ++i) {
		scanf("%d %d", &c[i], &v[i]);
	}
	int result = backpack(N, M);
	printf("%d\n", result);
	return 0;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
	int status = solve();
	return status;
}
