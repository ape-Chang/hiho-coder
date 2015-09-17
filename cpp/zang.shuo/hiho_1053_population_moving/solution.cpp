/*
 * 思路：这是一道典型的二分逼近题目，原题比较直接的形式化方式是转化为图，但是要计算使人口最多的城市人口数最小的最优调度较为复杂。
 * 考虑到提出一个城市最大人口数假设，并检验该假设是否成立这一任务较为简单，可使用贪心法解决（当然能不能想到该贪心法也很重要），
 * 故可以放弃直接计算最优调度，而使用二分逼近法，在答案的可能空间（无迁徙半径限制情况下的最优解即平均人口，与迁徙前的最大人口之间）
 * 上进行二分逼近，并通过检查假设来逼近搜索得到最优解。
 *
 * 在检验假设时，使用贪心法，从左到右扫描城市与殖民地，并使用尽量左边的殖民地尽量填满当前城市直到达到当前假设的最大人口数，直到
 * 城市填满换下一座城市，或殖民地搬空换下一个殖民地，或右侧殖民地距离当前城市过远无法迁入而切换下一座城市。
 * 如果所有城市都填充结束以后还有殖民地剩下，或者填充过程中左侧有殖民地有人口剩余且无法到达当前城市（也就是说他们被永远的留在后
 * 面了），说明该假设无法有效调度人口迁徙，否决之，否则接受。
 * 在二分逼近时，维护有效解空间为[low, high]，目标为越低越好，如果mid有效则更新上界high=mid，如果mid无效则更新下界low=mid+1
 * （因为mid被证明无效，故不应包含在闭区间内），直到闭区间只剩下一个解即low==high时，返回之。
 */

/*
 * 注释1：关于searchValidLimit()中创建殖民地数据数据和test()中扫描殖民地用的内层while循环的一个bug隐患
 * 这里如果像现在这样给每一个殖民地，包括空殖民地创建对象，而在test()中扫描殖民地时当前城市剩余空间不大于0就停止向右扫描殖民地，
 * 则如果存在最右侧有空殖民地，且它可以被达到的时候，有可能出现错误结果。错误结果的原因是，如果当前人口已经被最后一座城市正好消化，
 * 且最后一座城市恰好没有空间的同时，右侧还有空殖民地的时候，由于剩余空间是0，最后城市停止扫描殖民地，空殖民地不会被处理，从而
 * 在最后检查殖民地是否都扫描完成时被误判为有殖民地人口未定居而失败。
 * 一个引发该BUG的测试用例如
 * 1
 * 2 100
 * 10 10
 * 20 0
 * 正确情况下人口应平分在2个城市之中，结果为5，但该BUG发生时人口限制5由于第二个空殖民地未得到处理而误判，输出错误答案6。
 *
 * 修正BUG的方法有两个，其一如代码原作者一样对空殖民地不创建对象，其二如现在这样，城市空间为0时依旧向右扫描以消化右侧可能
 * 存在的空殖民地。两种各有其道理，但如果只满足于知道第一种方法而不知道BUG原因可能将来遭遇类似的隐患，故深入分析并找到另一
 * 种消灭隐患的解法，引以为戒。
 *
 * 此外，该隐患的根本原因是城市和殖民地扫描结束后对最终结果判定部分过于简单导致，如果在此处增加向右扫描空殖民地等确认逻辑，
 * 可以更好地避免由于循环边界的一点错误而引发难以发现的错误结果的BUG。
 */

#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>

//#define ONLINE_JUDGE

using namespace std;
typedef long long int ll;
struct seg {
	int l, r, n; // l, r为该城市居民可迁徙到的范围，n为人数
	seg(int x, int y, int z) :
			l(x), r(y), n(z) {
	}
};

/*
 * 尝试以每座城市最多maxN人为标准调度
 */
bool test(const vector<int> &cityLocations, const vector<seg> &colonies,
		int maxPopulation) { //q is sorted
	int numCities = cityLocations.size(), numColonies = colonies.size();
	if (colonies.size() == 0)
		return true;
	int curColony = 0, curPopulationLeft = colonies[curColony].n;
	for (int i = 0; i < numCities; i++) {
		int curLocation = cityLocations[i];
		int curSpace = maxPopulation;
		if (colonies[curColony].r < curLocation && curPopulationLeft > 0) // 如果出现人口落在左边无法迁徙，说明之前扫描过城市在maxPopulation限额下无法容纳人口，有剩余人口无法入住城市，此人口限额不可行
			return false;
		while (curColony < numColonies && curSpace >= 0) { // 关于此处的一个BUG隐患见顶部注释1
			if (colonies[curColony].l > curLocation)
				break; // 殖民地太靠右无法到达当前位置，当前城市扫描结束
			else if (curSpace >= curPopulationLeft) { // 殖民地搬空，换下一个殖民地继续搬往当前城市
				curSpace -= curPopulationLeft;
				curColony += 1;
				curPopulationLeft = colonies[curColony].n;
				continue;
			} else {
				curPopulationLeft -= curSpace; // 城市住满，换下一个城市
				curSpace = 0;
				break;
			}
		}
		if (curColony == numColonies)
			return true;
	}
	return false;
}
typedef pair<int, int> Pair;

/*
 * data: 保存代表城市的数据点（位置，人数）的vector
 * R为全局可迁徙半径
 */
int searchValidLimit(vector<Pair> &data, int R) {
	sort(data.begin(), data.end());
	int numCities = data.size();
	if (numCities == 0)
		return 0;

	vector<int> citiLocations; // 保存所有城市位置
	vector<seg> colonies; // 保存所有“殖民地”对象，即原居于一个城市的所有人组成的对象
	int maxPopulation = 0;    // 人数最多城市人数 
	ll totalPopulation = 0; // 总人数
	for (int i = 0; i < numCities; i++) {
		Pair &t = data[i];
		citiLocations.push_back(t.first);
//		if(t.second>0) // 关于此处的一个bug隐患见顶部注释1
		colonies.push_back(seg(t.first - R, t.first + R, t.second));
		maxPopulation = max(maxPopulation, t.second);
		totalPopulation += t.second;
	}

	// 二分逼近trial and error式搜索结果
	int low = (totalPopulation + numCities - 1) / numCities; // 向上取整
	int high = maxPopulation;
	while (low != high) {
		int mid = (low + high) / 2; // l+r can overflow? no. l<=10^9,r<=10^9. 2*10^9<2^31
		if (test(citiLocations, colonies, mid)) {
			high = mid;
		} else {
			low = mid + 1;
		}
	}
	return low;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test2.in", "r", stdin);
#endif
	int numCases;
	scanf("%d\n", &numCases);
	for (int i = 0; i < numCases; i++) {
		int n, r;
		scanf("%d %d\n", &n, &r);
		vector<Pair> data;
		data.resize(n);
		for (int j = 0; j < n; j++) {
			int x, y;
			scanf("%d %d\n", &x, &y);
			data[j] = Pair(x, y);
		}
		int result = searchValidLimit(data, r);
		printf("%d\n", result);
	}
	return 0;
}
