#include <cstdio>
#include <cstdlib>
#include <cstdio>
#include <cstring>
#include <vector>
#include <algorithm>

// #define ONLINE_JUDGE
using namespace std;

#define lc(x) ((x<<1)+1)
#define rc(x) ((x<<1)+2)

const int MAX_SIZE = 200010;
const int INF = 2000000000;

struct DataNode {
	int value;
	int queryNumber;
	int l;
	int h;
//	DataNode(int value, int queryNumber, int l, int h) :
//			value(value), queryNumber(queryNumber), l(l), h(h) {
//	}
	inline void assign(int value, int queryNumber, int l, int h) {
		this->value = value;
		this->queryNumber = queryNumber;
		this->l = l;
		this->h = h;
	}
	inline bool operator<(const DataNode &rhs) const {
		if (value < rhs.value) {
			return true;
		} else {
			return false;
		}
	}
};

struct Node {
	int l, h;
	int last;
};

inline int abs(int r) {
	if (r >= 0)
		return r;
	else
		return (-1) * r;
}

void buildSegmentTree(Node *nodes, int index, int l, int h) {
	nodes[index].l = l;
	nodes[index].h = h;
	nodes[index].last = -1;
	if (l > h) {
		// This shouldn't happen
		printf("ERROR! l>h! l = %d h = %d\n", l, h);
		return;
	} else if (l == h) {
		return;
	} else {
		int mid = (l + h) / 2; // l / 2 + h / 2 + (l % 2 & h % 2)可以防止溢出不过拉倒吧
		buildSegmentTree(nodes, lc(index), l, mid);
		buildSegmentTree(nodes, rc(index), mid + 1, h);
	}
}

/**
 * 单点更新，更新所有包含该点的节点
 * 调用需保证[l, h]为node对应区间的子区间
 */
void insertNumber(Node *nodes, int index, int p, int value) {
	// 通过递归结构保证p包含在node范围内

	nodes[index].last = value;
	if (nodes[index].l == nodes[index].h) {
		return;
	} else {
		int mid = (nodes[index].l + nodes[index].h) / 2;
		if (p <= mid) {
			insertNumber(nodes, lc(index), p, value);
		} else {
			insertNumber(nodes, rc(index), p, value);
		}
	}
}

/**
 * 段查找操作，不访问途中节点，只访问组成最终访问请求的子节点
 * 调用需保证[l, h]为node对应区间的子区间
 */
void query(Node *nodes, int index, int l, int h, int queryValue, int *result) {
	// 通过递归结构保证l,h一定包含在当前node对应的线段里，否则算法已经出错无法恢复
//	if (l > h) {
//		printf("ERROR! l > h!");
//		return;
//	}
	int newAbs;
	if (nodes[index].l == l && nodes[index].h == h) { // 一致，直接访问并返回
		if (nodes[index].last != -1) {
			newAbs = abs(nodes[index].last - queryValue);
			if (newAbs < *result) {
				*result = newAbs;
			}
		} // 刚才插入的那个元素一定就是距离这个query最接近的
	} else {
		int mid = (nodes[index].l + nodes[index].h) / 2;
		if (h <= mid) { // 完全包含在左半
			query(nodes, lc(index), l, h, queryValue, result);
		} else if (l >= mid + 1) { // 完全包含在右半
			query(nodes, rc(index), l, h, queryValue, result);
		} else { // 跨越左右两半，断成两半处理
			query(nodes, lc(index), l, mid, queryValue, result);
			query(nodes, rc(index), mid + 1, h, queryValue, result);
		}
	}
}

int solve() {
	int T, N, Q;
	scanf("%d", &T);
	Node *nodes = new Node[MAX_SIZE * 4];
	DataNode *data = new DataNode[MAX_SIZE * 2];
	int* result = new int[MAX_SIZE];
	for (int i = 0; i < T; ++i) {
		scanf("%d %d", &N, &Q);
		int dataCtr = 0;
		for (int j = 0; j < Q; ++j) {
			result[j] = INF;
		}
		// 读入数字数据
		int v;
		for (int j = 1; j <= N; ++j) {
			scanf("%d", &v);
			data[dataCtr++].assign(v, -1, j, j);
		}

		// 读入所有Query
		int l, h, k;
		for (int j = 0; j < Q; ++j) {
			scanf("%d %d %d", &l, &h, &k);
			data[dataCtr++].assign(k, j, l, h);
		}

		buildSegmentTree(nodes, 0, 1, N);
		sort(data, data + dataCtr);
		for (DataNode *iter = data; iter != data + dataCtr; ++iter) {
			if (iter->queryNumber != -1) {
				query(nodes, 0, iter->l, iter->h, iter->value,
						result + iter->queryNumber);
			} else {
				insertNumber(nodes, 0, iter->l, iter->value);
			}
		}

		buildSegmentTree(nodes, 0, 1, N);
		reverse(data, data + dataCtr);
		for (DataNode *iter = data; iter != data + dataCtr; ++iter) {
			if (iter->queryNumber != -1) {
				query(nodes, 0, iter->l, iter->h, iter->value,
						result + iter->queryNumber);
			} else {
				insertNumber(nodes, 0, iter->l, iter->value);
			}
		}

		printf("Case #%d:\n", i + 1);

		for (int j = 0; j < Q; ++j) {
			printf("%d\n", result[j]);
		}
	}
	delete[] nodes;
	delete[] result;
	delete[] data;
	return 0;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test4.in", "r", stdin);
#endif
	solve();
}
