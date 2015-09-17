/* 要点：假设连续M个座位不能有Q个以上被吵醒，那么最直观的状态是保存当前位置以及往前一共M个座位的打扫情况。然而实际上，要判断当前
 * 座位是否可以打扫，只需要左边一个座位以及从它开始的M-1个连续座位的打扫情况即可，当前座位的打扫情况可以通过循环生成。
 * 由此可以压缩掉一个状态位，减少一半的状态数量。
 *
 * 此外给出当前座位的状态，向左查找d[i-1][相应的打扫情况]的时候，“相应的打扫状况”的最左边一位是不确定的，同样需要用一个循环（k）来生成。
 * 这里注意生成了状态就需要判断合法性。
 *
 * 最后别忘了状态位数M是可变的，第一次实现的时候按照M=10固定实现了，各种WA。
 *
 * 状态转移方程通过代码比较容易看出，就不写了
 */

#include <cstdio>
#include <cstdlib>
#include <cstdio>
#include <cstring>

// #define ONLINE_JUDGE

const int MAX_N = 1005;
const int MAX_M = 10;
const int MAX_NUM_STATES = 512; // 2^(M-1) + 1

const int MINUS_INF = -9999999;

int w[MAX_N];
int d[MAX_N][MAX_NUM_STATES]; // d[i][j] : 处理完1..i，从第i位起向左连续M-1位的打扫状况为比特串j（最低位代表i号座）的最大垃圾回收数量
int mask;

void initMask(int M){
	mask = 0;
	for(int i=0;i<M;++i){
		mask = mask | 1<<i;
	}
}

int numPositive(unsigned int bits) {
	bits = bits & mask;
	int ctr = 0;
	while (bits) {
		ctr += bits & 1;
		bits = bits >> 1;
	}
	return ctr;
}

int compress_dp(int N, int M, int Q) {
	for (int j = 0; j < MAX_NUM_STATES; j++) {
		if (numPositive(j) <= Q)
			d[0][j] = 0;
		else
			d[0][j] = MINUS_INF;
	}
	for (int i = 1; i <= N; ++i) {
		for (int j = 0; j < MAX_NUM_STATES; ++j) {
			int curBest = MINUS_INF;
			for (int k = 0; k <= 1; ++k) {
				if (numPositive(j) + k > Q) {
					continue;
				} else {
					int lastS = d[i - 1][k << M-2 | j >> 1]; // 第一遍忘了M可变，默认M=10，k<<8，修正以后忘了改k的位移，结果手工构造的几个测试集没能发现这个错误
					int curW = (j & 1) ? w[i] : 0; // 注意?运算符优先级低于+ ！！！！！
					int curSum = lastS + curW;
					if (curSum > curBest) {
						curBest = curSum;
					}
				}
			}
			d[i][j] = curBest;
		}
	}
	int curBest = MINUS_INF;
	for (int j = 0; j < MAX_NUM_STATES; ++j) {
		if (d[N][j] > curBest)
			curBest = d[N][j];
	}
	return curBest;
}

int solve() {
	int N, M, Q;
	if (scanf("%d %d %d\n", &N, &M, &Q) != 3)
		return 1;
	for (int i = 1; i <= N; ++i) {
		scanf("%d", &w[i]);
	}

	initMask(M);
	int result = compress_dp(N, M, Q);
	printf("%d\n", result);

	return 0;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
	solve();
}
