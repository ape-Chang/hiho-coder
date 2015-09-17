// 思路：
// 由于K/N较大时前K和后K个、以及各重合部分之间会有多层重合，所以用手动分辨重合的方式编码困难，改用给元素分组的方式，用模拟法让机器算出重合情况。
// 首先分两次给N中的所有元素打组号tag，第一次打前K个，正常进行，第二次打的时候遇到已经tag过的元素则要映射到组号，其中组号使用该组中最小的tag作为代表。
// 维护一个将较大的tag号映射到最小的组号的map，第二轮更新组号之前遇到重合先维护该map，以解决串联映射问题。
// 然后对每个组，分别统计各个基因的出现次数，该组要修改成相同基因，修改次数就为组中所有元素个数减去重复次数最多的基因的重复次数（将其他所有基因改成该基因）。
// 由于基因只有4个，手动映射基因到坐标；如果基因字母表更大，考虑用其他方式转换坐标，如ch-'a'，甚至空间换编码时间，开一个大数组只用其中离散的4个位置。

#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <vector>

#define ONLINE_JUDGE

const int BUF_SIZE = 1010;

int geneMod(char *in, int k, int n) {
	// 应该在这里检查输入合法性（in是否为null、字符串是否只有ATCG等）

	int groupMap[BUF_SIZE]; // map index in [0,k) to its group
	for (int i = 0; i < k; ++i)
		groupMap[i] = i;

	int groupTag[BUF_SIZE]; // group tag of elements in N
	for (int i = 0; i < n; ++i)
		groupTag[i] = -1;

	for (int i = 0; i < k; ++i) {
		groupTag[i] = i;
	}

	for (int i = 0; i < k; ++i) {
		int cur = n - k + i;
		if (groupTag[cur] != -1) { // only happens when overlay
			int realGroup = groupMap[i];
			groupMap[groupTag[cur]] = realGroup;
			groupTag[cur] = realGroup;  // 这行和上一行别写反了
		} else {
			groupTag[cur] = groupMap[i];
		}
	}

	// 找出所有有效组
	bool groupActive[BUF_SIZE];
	for (int i = 0; i < k; ++i)
		groupActive[i] = false;
	for (int i = 0; i < k; ++i) {
		groupActive[groupMap[i]] = true;
	}

	int editNeeded = 0;

	for (int i = 0; i < k; ++i) {	// 为组i计算所需编辑次数
		if (groupActive[i]) {
			int groupSize = 0;
			int numGene[4]={0,0,0,0}; // ATCG
			for (int pos = 0; pos < n; ++pos) {
				if (groupTag[pos] != i)
					continue;
				groupSize += 1;
				switch (in[pos]) {
				case 'A':
					numGene[0] += 1;
					break;
				case 'T':
					numGene[1] += 1;
					break;
				case 'C':
					numGene[2] += 1;
					break;
				case 'G':
					numGene[3] += 1;
					break;
				}
			}
			int maxGene = 0;
			for (int i = 0; i < 4; ++i) {
				if (numGene[i] > maxGene)
					maxGene = numGene[i];
			}
			int groupEditNeeded=groupSize-maxGene;
			editNeeded+=groupEditNeeded;
		}
	}

	return editNeeded;
}

int solve() {
	int numCases;
	char buffer[BUF_SIZE];
	int k;
	if (scanf("%d\n", &numCases) == EOF)
		return 2;
	for (int i = 0; i < numCases; ++i) {
		if (scanf("%s\n%d\n", buffer, &k) != 2)
			return 2;
		int n = strlen(buffer);
		int result = geneMod(buffer, k, n);
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
