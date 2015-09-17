/*
 * 结论：老子再也不用左儿子右兄弟表示法来刷题了，实在不直观，想递归一下都得转转脑子
 * 另外用数组和数组下标代替指针，代码看起来反倒更麻烦了。以后用数组就只负责index访问，节点之间还是用指针吧
 * 这道水题如果用邻接表加上普通的指针方式，应该不至于写一个多小时
 */

#include <cstdio>
#include <cstdlib>
#include <cstdio>
#include <cstring>

//#define ONLINE_JUDGE

struct Node {
	int l, r;
	int height; // 真实树高
	int rheight; // 保存所有右兄弟节点中最高的树高
	Node() :
			l(0), r(0), height(0), rheight(0) {
	}
};
// 左儿子右兄弟树的节点

inline int max(int l, int r) {
	return (l >= r) ? l : r;
}

void calculateHeight(Node *tree, int root) {
	if (root == 0) {
		return;
	}
	calculateHeight(tree, tree[root].l);
	calculateHeight(tree, tree[root].r);
	int height;
	if (tree[root].l == 0) {
		height = 1;
	} else {
		height = tree[tree[root].l].height + 1;
		if (tree[tree[root].l].rheight + 1 > height) {
			height = tree[tree[root].l].rheight + 1;
		}
	}
	tree[root].height = height;
	tree[root].rheight =
			(tree[tree[root].r].height > tree[tree[root].r].rheight) ?
					tree[tree[root].r].height : tree[tree[root].r].rheight;
}

void treeLongestPath(Node *tree, int root, int *curMax) {
	int heightMax1 = 0;
	int heightMax2 = 0;
	int curChild = tree[root].l;
	if (curChild == 0)
		return;
	if (tree[curChild].r == 0)
		return;

	do {
		int curHeight = tree[curChild].height;
		if (curHeight > heightMax1) {
			heightMax2 = heightMax1;
			heightMax1 = curHeight;
		} else if (curHeight > heightMax2) {
			heightMax2 = curHeight;
		}
		curChild = tree[curChild].r;
	} while (curChild != 0);

	if (heightMax1 + heightMax2 > *curMax) {
		*curMax = heightMax1 + heightMax2;
	}

	treeLongestPath(tree, tree[root].l, curMax);
	treeLongestPath(tree, tree[root].r, curMax);
}

int treeLongestPath(Node *tree) {
	int result = 0;
	treeLongestPath(tree, 1, &result);
	return result;
}

int solve() {
	unsigned int N;
	Node *nodes;
	scanf("%u", &N);

	nodes = new Node[N + 1]; // use 1-based index
	int parent, child;
	for (unsigned i = 0; i < N - 1; ++i) {
		scanf("%d %d", &parent, &child);
		if (nodes[parent].l == 0) {
			nodes[parent].l = child;
		} else {
			int curBrother = nodes[parent].l;
			while (nodes[curBrother].r != 0) {
				curBrother = nodes[curBrother].r;
			}
			nodes[curBrother].r = child;
		}
	}

	calculateHeight(nodes, 1);

	int result = treeLongestPath(nodes);
	printf("%d\n", result);
	return 0;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
	solve();
}
