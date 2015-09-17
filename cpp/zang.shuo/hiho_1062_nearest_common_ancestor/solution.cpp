#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <map>
#include <string>
#include <iostream>

// #define ONLINE_JUDGE

using namespace std;

const int MAX_N = 1050, MAX_M = 1050;
const int MAX_NAME_LENGTH = 10050;

map<string, int> nameMap;
map<int, string> reverseNameMap;
int N, M;
string parents[MAX_N], children[MAX_N];
int p[MAX_N * 2];
int nameCtr = 1;

string findCommonAncestor(string name1, string name2) {
	if (name1 == name2){ // 注意这道题不保证问题里的两个名字是不同的，并且这是一个坑，卡了我俩小时
		return name1;
	}
	if (nameMap.count(name1) == 0 || nameMap.count(name2) == 0) {
		return string("-1");
	}
	int index1 = nameMap[name1];
	int index2 = nameMap[name2];
	bool visited[MAX_N * 2];
	memset(visited, 0, sizeof(visited));
	while (index1 != -1) {
		visited[index1] = true;
		index1 = p[index1];
	}
	while (index2 != -1) {
		if (visited[index2]) {
			return reverseNameMap[index2];
		}
		index2 = p[index2];
	}
	return string("-1");
}

int solve() {
	for (int i = 0; i < MAX_N * 2; ++i) {
		p[i] = -1;
	}
	cin >> N;
	// 读入所有父子关系对
	for (int i = 0; i < N; ++i) {
		cin >> parents[i] >> children[i];
		if (nameMap.count(parents[i]) == 0) {
			nameMap[parents[i]] = nameCtr;
			reverseNameMap[nameCtr] = parents[i];
			nameCtr += 1;
		}
		if (nameMap.count(children[i]) == 0) {
			nameMap[children[i]] = nameCtr;
			reverseNameMap[nameCtr] = children[i];
			nameCtr += 1;
		}
	}
	// 构建向上指向的树结构
	for (int i = 0; i < N; ++i) {
		int parentIndex = nameMap[parents[i]];
		int childIndex = nameMap[children[i]];
		p[childIndex] = parentIndex;
	}

	cin >> M;
	for (int i = 0; i < M; ++i) {
		string name1, name2;
		cin >> name1 >> name2;

		cout << findCommonAncestor(name1, name2) << "\n";
	}

	return 0;
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
	solve();
}
