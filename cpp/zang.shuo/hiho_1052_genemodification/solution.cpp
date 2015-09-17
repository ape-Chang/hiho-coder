// ˼·��
// ����K/N�ϴ�ʱǰK�ͺ�K�����Լ����غϲ���֮����ж���غϣ��������ֶ��ֱ��غϵķ�ʽ�������ѣ����ø�Ԫ�ط���ķ�ʽ����ģ�ⷨ�û�������غ������
// ���ȷ����θ�N�е�����Ԫ�ش����tag����һ�δ�ǰK�����������У��ڶ��δ��ʱ�������Ѿ�tag����Ԫ����Ҫӳ�䵽��ţ��������ʹ�ø�������С��tag��Ϊ����
// ά��һ�����ϴ��tag��ӳ�䵽��С����ŵ�map���ڶ��ָ������֮ǰ�����غ���ά����map���Խ������ӳ�����⡣
// Ȼ���ÿ���飬�ֱ�ͳ�Ƹ�������ĳ��ִ���������Ҫ�޸ĳ���ͬ�����޸Ĵ�����Ϊ��������Ԫ�ظ�����ȥ�ظ��������Ļ�����ظ����������������л���ĳɸû��򣩡�
// ���ڻ���ֻ��4�����ֶ�ӳ��������ꣻ���������ĸ����󣬿�����������ʽת�����꣬��ch-'a'�������ռ任����ʱ�䣬��һ��������ֻ��������ɢ��4��λ�á�

#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <vector>

#define ONLINE_JUDGE

const int BUF_SIZE = 1010;

int geneMod(char *in, int k, int n) {
	// Ӧ��������������Ϸ��ԣ�in�Ƿ�Ϊnull���ַ����Ƿ�ֻ��ATCG�ȣ�

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
			groupTag[cur] = realGroup;  // ���к���һ�б�д����
		} else {
			groupTag[cur] = groupMap[i];
		}
	}

	// �ҳ�������Ч��
	bool groupActive[BUF_SIZE];
	for (int i = 0; i < k; ++i)
		groupActive[i] = false;
	for (int i = 0; i < k; ++i) {
		groupActive[groupMap[i]] = true;
	}

	int editNeeded = 0;

	for (int i = 0; i < k; ++i) {	// Ϊ��i��������༭����
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
