/*
 * 这是一道比较标准的深度搜索题目，可以看作是使用深度搜索的方式生成全排列的变种，其中变在两个部分：
 * 1) 首先暂时接受所有长度大于4（注意边界判定，pos>=5不是4），并且不包含九宫格密码定义的非法边的解串
 * 2) 然后检查是否存在小Hi看到的那些直接连接的边，只接受存在这些边的解。
 *
 * 如果不考虑2)，则问题退化为求全部合法九宫格密码的个数。
 *
 * 这道题的要点在于选择用于计算和表示解的内部数据结构：
 * 如果要将点形式化为二维坐标，则乍看上去表示一个点很清楚，但实际上实现起来代码会非常繁杂。要诀在于将点坐标展平成一维：
 * 1 4 7
 * 2 5 8
 * 3 6 9
 * 然后利用生成字符串全排列的dfs算法去生成全排列，同时利用过滤法计数合法解的个数。
 * 在子串中，两个相邻的点之间才有边，因此判断合法边的时候只需要检查前一个点和当前点中间是否有未访问的其他点，用穷举法穷举
 * 所有非法边情形即可，只有横6竖6斜4共16种情形。
 * 检查小Hi看到的边是否存在的时候，直接遍历解串检查所有边，或者使用空间换时间先将小Hi看到的边展开成为矩阵，然后只需要遍历1遍。
 */

/*
 * 这道题的最大教训是：
 * 边界！边界！边界！！
 *
 * 一开始咱试图省事，visited[]数组用了1为下标起点以后顺便用于保存部分解的buf数组也用了1为起点，于是就炸了锅了。
 * 事实证明对于visited[]这种本质上是个map的数组用1作为下标起点并不是问题，但buf这种普通的，需要用到长度用到各种边界判断的数组
 * 如果用1作为下标，那么要么自己记清楚搞清楚全程保持正确统一，要么老老实实给我用用惯了的0开头，不要突然间跳起来作死。
 *
 * 另外，对于坐标边界问题，一定不可以思维懒惰，一个多次用到的数组的坐标体系一定给我在纸上画清楚搞清楚，回头WA了或者segfault了
 * 再DEBUG可能就是比搞清楚坐标体系多10倍的时间损失。
 */

#include <cstdio>
#include <cstdlib>
#include <cstdio>
#include <vector>
#include <algorithm>

//#define ONLINE_JUDGE

using namespace std;

typedef pair<int, int> Line;

/*
 * ni: 待插入到最新位置即buf[pos]上的整数
 */
bool checkValid(int *buf, bool *visited, int pos, int ni) {
	if (buf[pos - 1] == 1 && ni == 3 && !visited[2])
		return false;
	if (buf[pos - 1] == 3 && ni == 1 && !visited[2])
		return false;
	if (buf[pos - 1] == 4 && ni == 6 && !visited[5])
		return false;
	if (buf[pos - 1] == 6 && ni == 4 && !visited[5])
		return false;
	if (buf[pos - 1] == 7 && ni == 9 && !visited[8])
		return false;
	if (buf[pos - 1] == 9 && ni == 7 && !visited[8])
		return false;
	if (buf[pos - 1] == 1 && ni == 7 && !visited[4])
		return false;
	if (buf[pos - 1] == 7 && ni == 1 && !visited[4])
		return false;
	if (buf[pos - 1] == 2 && ni == 8 && !visited[5])
		return false;
	if (buf[pos - 1] == 8 && ni == 2 && !visited[5])
		return false;
	if (buf[pos - 1] == 3 && ni == 9 && !visited[6])
		return false;
	if (buf[pos - 1] == 9 && ni == 3 && !visited[6])
		return false;
	if (buf[pos - 1] == 1 && ni == 9 && !visited[5])
		return false;
	if (buf[pos - 1] == 9 && ni == 1 && !visited[5])
		return false;
	if (buf[pos - 1] == 3 && ni == 7 && !visited[5])
		return false;
	if (buf[pos - 1] == 7 && ni == 3 && !visited[5])
		return false;
	return true;
}

bool checkLines(int *buf, int length, vector<Line> lines){
	int numLines=lines.size();
	for(int i=0;i<numLines;++i){
		int p1=lines[i].first;
		int p2=lines[i].second;
		bool found=false;
		for(int i=0;i<length-1;++i){
			if ((buf[i]==p1 && buf[i+1]==p2) ||
					(buf[i]==p2 && buf[i+1]==p1))
				found=true;
		}
		if (!found) return false;
	}
	return true;
}
/*
 * pos: 当前待扩展位置，有效值为1至9，不是0开始
 */
int dfs(int *buf, bool *visited, int posToFill, vector<Line> lines) {
	int cnt = 0;
	if (posToFill >= 4) { // pos=4时已经生成长度为4的子串
		if(checkLines(buf, posToFill, lines))
			cnt += 1;
	}
	if (posToFill == 9) // pos为9时长度为9的子串已经生成
		return cnt;
	for (int i = 1; i <= 9; ++i) {
		if (!visited[i] && checkValid(buf, visited, posToFill, i)) {
			visited[i] = true;
			buf[posToFill] = i;
			cnt += dfs(buf, visited, posToFill + 1, lines);
			visited[i] = false;
			buf[posToFill] = 0;
		}
	}
	return cnt;
}

int calcPossiblePerms(vector<Line> lines) {
	// 先计算全排列
	int buf[10];
	bool visited[10];
	for (int i = 1; i <= 9; ++i) {
		buf[i] = 0;
		visited[i] = false;
	}
	int cnt = dfs(buf, visited, 0, lines);
	return cnt;
}

int solve() {
	int numCases;
	if (scanf("%d\n", &numCases) == EOF)
		return 1;
	for (int i = 0; i < numCases; ++i) {
		int numLineSeen;
		if (scanf("%d\n", &numLineSeen) == EOF)
			return 2;
		vector<Line> lines;
		lines.resize(numLineSeen);
		for (int i = 0; i < numLineSeen; ++i) {
			int x, y;
			if (scanf("%d %d\n", &x, &y) == EOF)
				return 3;
			lines[i].first = x;
			lines[i].second = y;
		}
		int result = calcPossiblePerms(lines);
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
