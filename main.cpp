#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <cctype>
#include <iterator>
#include <queue>
#include <functional>
#include <map>
#include <sstream>
#include <set>
#include <utility>

using namespace std;

struct Node {
	int id;
	int virus;
	Node(int id) {this->id = id; this->virus = 0;}
	Node(int id, int virus) {this->id = id; this->virus = virus;}
};

struct Edge {
	int from;
	int to;
	Edge(int from, int to) {this->from = from; this->to = to;}
};

void topoSort(vector<Node>& nodes, vector<Edge>& edges) {
	vector<int> indegrees(nodes.size());
	generate(nodes.begin(), nodes.end(), []() {return 0;});
	for (Edge& edge : edges) indegrees[edge.to - 1]++;
	
	queue<int> noIndegrees;
	for (size_t i = 0; i < indegrees.size(); ++i)
		if (indegrees[i] == 0) noIndegrees.push(i);
	
	vector<Node> sorteds;
	while (!noIndegrees.empty()) {
		int front = noIndegrees.front();
		noIndegrees.pop();
		sorteds.push_back(nodes[front]);
		for (Edge& edge : edges) 
			if (edge.from == front+1)
				if (--indegrees[edge.to-1] == 0)
					noIndegrees.push(edge.to-1);
	}
	nodes = sorteds;
}

int main(int argc, char **argv) {
	istream_iterator<int> iter(cin);
	int n, m, k;
	n = *(iter++);
	m = *(iter++);
	k = *(iter++);
	
	vector<int> init;
	while (k-- > 0) init.push_back(*(iter++));
	vector<Node> nodes;
	for (int i = 0; i < n; ++i) 
		if (find(init.begin(), init.end(), i+1) != init.end())
			nodes.push_back(Node(i+1, 1));
		else
			nodes.push_back(Node(i+1));
		
	vector<Edge> edges;
	for (int i = 0; i < m; ++i) {
		int from = *(iter++);
		int to = *(iter++);
		edges.push_back(Edge(from, to));
	}
	topoSort(nodes, edges);
	for (Node& node : nodes) {}
    return 0;
}