/*
 * ˼·������һ�����͵Ķ��ֱƽ���Ŀ��ԭ��Ƚ�ֱ�ӵ���ʽ����ʽ��ת��Ϊͼ������Ҫ����ʹ�˿����ĳ����˿�����С�����ŵ��Ƚ�Ϊ���ӡ�
 * ���ǵ����һ����������˿������裬������ü����Ƿ������һ�����Ϊ�򵥣���ʹ��̰�ķ��������Ȼ�ܲ����뵽��̰�ķ�Ҳ����Ҫ����
 * �ʿ��Է���ֱ�Ӽ������ŵ��ȣ���ʹ�ö��ֱƽ������ڴ𰸵Ŀ��ܿռ䣨��Ǩ��뾶��������µ����Ž⼴ƽ���˿ڣ���Ǩ��ǰ������˿�֮�䣩
 * �Ͻ��ж��ֱƽ�����ͨ�����������ƽ������õ����Ž⡣
 *
 * �ڼ������ʱ��ʹ��̰�ķ���������ɨ�������ֳ��أ���ʹ�þ�����ߵ�ֳ��ؾ���������ǰ����ֱ���ﵽ��ǰ���������˿�����ֱ��
 * ������������һ�����У���ֳ��ذ�ջ���һ��ֳ��أ����Ҳ�ֳ��ؾ��뵱ǰ���й�Զ�޷�Ǩ����л���һ�����С�
 * ������г��ж��������Ժ���ֳ���ʣ�£������������������ֳ������˿�ʣ�����޷����ﵱǰ���У�Ҳ����˵���Ǳ���Զ�����ں�
 * ���ˣ���˵���ü����޷���Ч�����˿�Ǩ�㣬���֮��������ܡ�
 * �ڶ��ֱƽ�ʱ��ά����Ч��ռ�Ϊ[low, high]��Ŀ��ΪԽ��Խ�ã����mid��Ч������Ͻ�high=mid�����mid��Ч������½�low=mid+1
 * ����Ϊmid��֤����Ч���ʲ�Ӧ�����ڱ������ڣ���ֱ��������ֻʣ��һ���⼴low==highʱ������֮��
 */

/*
 * ע��1������searchValidLimit()�д���ֳ����������ݺ�test()��ɨ��ֳ����õ��ڲ�whileѭ����һ��bug����
 * �������������������ÿһ��ֳ��أ�������ֳ��ش������󣬶���test()��ɨ��ֳ���ʱ��ǰ����ʣ��ռ䲻����0��ֹͣ����ɨ��ֳ��أ�
 * ������������Ҳ��п�ֳ��أ��������Ա��ﵽ��ʱ���п��ܳ��ִ���������������ԭ���ǣ������ǰ�˿��Ѿ������һ����������������
 * �����һ������ǡ��û�пռ��ͬʱ���Ҳ໹�п�ֳ��ص�ʱ������ʣ��ռ���0��������ֹͣɨ��ֳ��أ���ֳ��ز��ᱻ�����Ӷ�
 * �������ֳ����Ƿ�ɨ�����ʱ������Ϊ��ֳ����˿�δ���Ӷ�ʧ�ܡ�
 * һ��������BUG�Ĳ���������
 * 1
 * 2 100
 * 10 10
 * 20 0
 * ��ȷ������˿�Ӧƽ����2������֮�У����Ϊ5������BUG����ʱ�˿�����5���ڵڶ�����ֳ���δ�õ���������У���������6��
 *
 * ����BUG�ķ�������������һ�����ԭ����һ���Կ�ֳ��ز���������������������������пռ�Ϊ0ʱ��������ɨ���������Ҳ����
 * ���ڵĿ�ֳ��ء����ָ�������������ֻ������֪����һ�ַ�������֪��BUGԭ����ܽ����������Ƶ�������������������ҵ���һ
 * �����������Ľⷨ������Ϊ�䡣
 *
 * ���⣬�������ĸ���ԭ���ǳ��к�ֳ���ɨ�����������ս���ж����ֹ��ڼ򵥵��£�����ڴ˴���������ɨ���ֳ��ص�ȷ���߼���
 * ���Ը��õر�������ѭ���߽��һ�������������Է��ֵĴ�������BUG��
 */

#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>

//#define ONLINE_JUDGE

using namespace std;
typedef long long int ll;
struct seg {
	int l, r, n; // l, rΪ�ó��о����Ǩ�㵽�ķ�Χ��nΪ����
	seg(int x, int y, int z) :
			l(x), r(y), n(z) {
	}
};

/*
 * ������ÿ���������maxN��Ϊ��׼����
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
		if (colonies[curColony].r < curLocation && curPopulationLeft > 0) // ��������˿���������޷�Ǩ�㣬˵��֮ǰɨ���������maxPopulation�޶����޷������˿ڣ���ʣ���˿��޷���ס���У����˿��޶����
			return false;
		while (curColony < numColonies && curSpace >= 0) { // ���ڴ˴���һ��BUG����������ע��1
			if (colonies[curColony].l > curLocation)
				break; // ֳ���̫�����޷����ﵱǰλ�ã���ǰ����ɨ�����
			else if (curSpace >= curPopulationLeft) { // ֳ��ذ�գ�����һ��ֳ��ؼ���������ǰ����
				curSpace -= curPopulationLeft;
				curColony += 1;
				curPopulationLeft = colonies[curColony].n;
				continue;
			} else {
				curPopulationLeft -= curSpace; // ����ס��������һ������
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
 * data: ���������е����ݵ㣨λ�ã���������vector
 * RΪȫ�ֿ�Ǩ��뾶
 */
int searchValidLimit(vector<Pair> &data, int R) {
	sort(data.begin(), data.end());
	int numCities = data.size();
	if (numCities == 0)
		return 0;

	vector<int> citiLocations; // �������г���λ��
	vector<seg> colonies; // �������С�ֳ��ء����󣬼�ԭ����һ�����е���������ɵĶ���
	int maxPopulation = 0;    // �������������� 
	ll totalPopulation = 0; // ������
	for (int i = 0; i < numCities; i++) {
		Pair &t = data[i];
		citiLocations.push_back(t.first);
//		if(t.second>0) // ���ڴ˴���һ��bug����������ע��1
		colonies.push_back(seg(t.first - R, t.first + R, t.second));
		maxPopulation = max(maxPopulation, t.second);
		totalPopulation += t.second;
	}

	// ���ֱƽ�trial and errorʽ�������
	int low = (totalPopulation + numCities - 1) / numCities; // ����ȡ��
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
