#include <cstdio>
#include <cstdlib>
#include <cstdio>
#include <cstring>
#include <string>
#include <map>

//#define ONLINE_JUDGE

using namespace std;
const int MAX_NAME_LENGTH = 1005;
const int MAX_NODE = 100005;

class Ufset {
private:
	int nameCtr; // start from 1
	map<string, int> nameMap;
	int p[MAX_NODE];
	int height[MAX_NODE];
	string name[MAX_NODE];
public:
	Ufset() :
			nameCtr(1) {
	}
	void uni(const string &l, const string &r);
	int find(const string &x);
	bool isSameSet(const string &l, const string &r);
};

void Ufset::uni(const string &l, const string &r) {
	if (nameMap.count(l) == 0) {
		nameMap[l] = nameCtr;
		nameCtr++;
	}
	if (nameMap.count(r) == 0) {
		nameMap[r] = nameCtr;
		nameCtr++;
	}
	int setL = find(l), setR = find(r);
	if (setL != setR) {
		if (height[setL] < height[setR]) {
			p[setL] = setR;
		} else if (height[setL] > height[setR]) {
			p[setR] = setL;
		} else {
			p[setL] = setR;
			height[setR] += 1;
		}
	}
}

int Ufset::find(const string &x) {
	if (nameMap.count(x) == 0) {
		return -1;
	}
	int _depth = 1;
	int xIndex = nameMap[x];
	int curIndex = xIndex;
	while (p[curIndex] != 0) {
		curIndex = p[curIndex];
		_depth += 1;
	}
	int setX = curIndex;
	int origP;
	while(xIndex != setX){
		origP = p[xIndex];
		p[xIndex] = setX;
		xIndex = origP;
	}

	return curIndex;
}

bool Ufset::isSameSet(const string &l, const string &r) {
	if (l == r)
		return true;
	int setL = find(l), setR = find(r);
	if (setL != -1 && setR != -1 && setL == setR) {
		return true;
	} else {
		return false;
	}
}

int solve() {
	int N;
	int op;
	char buf1[MAX_NAME_LENGTH], buf2[MAX_NAME_LENGTH];
	Ufset *ufset = new Ufset();
	scanf("%d\n", &N);
	for (int i = 0; i < N; ++i) {
		scanf("%d %s %s\n", &op, buf1, buf2);
		string name1(buf1), name2(buf2);
		if (op == 0) {
			ufset->uni(name1, name2);
		} else if (op == 1) {
			bool result = ufset->isSameSet(name1, name2);
			if (result == true) {
				printf("yes\n");
			} else {
				printf("no\n");
			}
		}
	}
	return 0;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
	solve();
}
