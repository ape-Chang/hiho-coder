/*
 * 感觉做OJ题，涉及各种数据结构的时候，用面向对象的风格不利于速度完成任务，于是改用C风格
 */

#include <cstdio>
#include <cstring>

//#define ONLINE_JUDGE

const int MAX_LENGTH = 26 + 1;

typedef struct Node {
	Node *l, *r;
	char data;
} Node;
/*
 * pb, pe为当前递归处理部分的前序部分的子串起止点，pe为最后一个字符的下标+1
 * mb, me同理
 */
Node *doRecover(char *pre, char *mid, int pb, int pe, int mb, int me) {
	if (pe > pb) { // 注意这里别漏了递归终止条件判断
		Node *subtreeRoot = new Node;
		subtreeRoot->data = pre[pb];
		int mr;
		for (mr = mb; mr < me; ++mr) {
			if (mid[mr] == pre[pb]) {
				break;
			}
		}
		subtreeRoot->l = doRecover(pre, mid, pb + 1, pb + 1 + (mr - mb), mb, // 算准边界是这道题唯一的难点
				mr);
		subtreeRoot->r = doRecover(pre, mid, pb + 1 + (mr - mb), pe, mr + 1,
				me);
		return subtreeRoot;
	} else {
		return NULL;
	}
}

Node *BinaryTree_recover(char *pre, char *mid) {
	int length = strlen(pre);
	return doRecover(pre, mid, 0, length, 0, length);
}

void BinaryTree_postorder(Node *root, char *outBuffer, int *bufferPos) {
	if (root == NULL) {
		return;
	}
	BinaryTree_postorder(root->l, outBuffer, bufferPos);
	BinaryTree_postorder(root->r, outBuffer, bufferPos);
	outBuffer[*bufferPos] = root->data;
	outBuffer[*bufferPos + 1] = '\0';
	(*bufferPos) += 1;
}

void BinaryTree_destroy(Node *root){
	if (root==NULL){
		return;
	}
	else {
		delete root->l;
		delete root->r;
		delete root;
	}
}

int solve() {
	char preorder[MAX_LENGTH];
	char midorder[MAX_LENGTH];
	scanf("%s", preorder);
	scanf("%s", midorder);
	Node *root = BinaryTree_recover(preorder, midorder);

	char postorder[MAX_LENGTH];
	int curPos = 0;
	BinaryTree_postorder(root, postorder, &curPos);
	printf("%s", postorder);

	BinaryTree_destroy(root);
	return 0;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
	solve();
}
