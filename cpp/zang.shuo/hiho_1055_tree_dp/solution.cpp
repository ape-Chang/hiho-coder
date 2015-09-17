#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <vector>

// #define ONLINE_JUDGE
const int MAX_N = 102;

using std::vector;

struct Node {
	vector<Node*> children;
	int index;
	int value;
	int subtreeSize;
	int subtreePaintValue[MAX_N]; // 以当前节点为根的子树，包括当前节点在内的不超过[k]个节点上色，所能获得的最大价值
	Node() :
			index(0), value(0), subtreeSize(0) {
		memset(subtreePaintValue, 0, sizeof(subtreePaintValue));
	}
};

/*
 * 嵌套式dp，函数dp()本身为基于树结构的动态规划，而计算每个树节点计算状态时，内嵌一个0-1背包动态规划
 */
void dp(Node *node, int M) {
	node->subtreeSize = 1;
	for (size_t i = 0; i < node->children.size(); ++i) {
		node->subtreeSize += node->children[i]->subtreeSize;
	}

	// 用背包的方式计算当前子树的染色价值，直接使用子树节点中的subtreePaintValue[]数组作为保存状态变量的空间
	// 为方便背包运算，在背包计算过程中subtreePaintValue[k]暂时保存所有子树加起来不超过k个节点染色的最大价值，背包算法计算
	// 完成以后，再将当前节点“强行加入背包”，以保证染色的连通性。

	// 背包部分
	for (size_t i = 0; i < node->children.size(); ++i) {
		Node *curChild = node->children[i];
		for (int j = node->subtreeSize - 1; j >= 0; --j) { // 先计算只考虑子节点的价值，背包做完了再加上当前节点的价值，因此最大计算到子树大小-1就够了
			int max = 0;
			for (int k = j; k >= 1; --k) { // 第i个子树染k个节点，这里相当于将每个子树根据染色最大数量展成一组互斥的j个“物品”
				if (node->subtreePaintValue[j - k]
						+ curChild->subtreePaintValue[k] > max) {
					max = node->subtreePaintValue[j - k]
							+ curChild->subtreePaintValue[k];
				}
			}
			if (max > node->subtreePaintValue[j]) {
				node->subtreePaintValue[j] = max;
			}
		}
	}

	// 将当前节点的价值强行插入背包结果
	for (int j = node->subtreeSize; j >= 1; --j) {
		node->subtreePaintValue[j] = node->subtreePaintValue[j - 1]
				+ node->value;
	}
}

void postorderDp(Node *node, int M) {
	if (node == NULL)
		return;
	for (size_t i = 0; i < node->children.size(); ++i) {
		postorderDp(node->children[i], M);
	}
	dp(node, M);
}

int solve() {
	int N, M;
	Node *nodes;
	scanf("%d %d", &N, &M);
	nodes = new Node[N + 1];
	Node * const root = nodes + 1;
	for (int i = 1; i <= N; ++i) {
		int value;
		scanf("%d", &value);
		nodes[i].index = i;
		nodes[i].value = value;
	}
	for (int i = 0; i < N - 1; ++i) {
		int parent, child;
		scanf("%d %d", &parent, &child);
		nodes[parent].children.push_back(nodes + child);
	}

	postorderDp(nodes + 1, M);

	int result = root->subtreePaintValue[M];
	printf("%d\n", result);

	delete[] nodes;
	return 0;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
	solve();
}
