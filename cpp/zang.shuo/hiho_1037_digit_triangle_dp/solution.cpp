/*
 * 最基本的动态规划，数字三角形，高中的时候做过的那个
 */

#include <cstdio>
#include <cstdlib>
#include <cstdio>
#include <cstring>
#include <algorithm>

using std::max;

//#define ONLINE_JUDGE

const int MAX_N = 105;

struct Maze{
	int n;
	int w[MAX_N][MAX_N]; // weight of each room
};

int findMaxW(Maze *maze){
	int d[MAX_N][MAX_N];
	int n=maze->n;
	for(int j=0;j<n;++j){
		d[n-1][j]=maze->w[n-1][j];
	}
	for(int i=n-2;i>=0;--i){
		for(int j=0;j<=i;++j){
			d[i][j]=max(d[i+1][j], d[i+1][j+1]) + maze->w[i][j];
		}
	}
	return d[0][0];
}

int solve() {
	int n;
	if (scanf("%d\n", &n) == EOF){
		return 1;
	}
	Maze *maze = new Maze();
	maze->n = n;
	for (int i=0;i<n;++i){
		for (int j=0;j<=i;++j){
			scanf("%d", &maze->w[i][j]);
		}
	}
	int result = findMaxW(maze);
	printf("%d\n", result);
	return 0;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
	solve();
}
