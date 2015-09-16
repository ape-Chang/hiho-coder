int str2int(const string& str) {
	stringstream ss;
	ss << str;
	int n;
	ss >> n;
	return n;
}

string int2str(const int n) {
	stringstream ss;
	string str;
	ss << n;
	ss >> str;
	return str;
}

vector<int> makeRange(int n) {
	vector<int> v(n);
	int i = 1;
	generate(v.begin(), v.end() [&i]() {return i++;});
	return v;
}

set<int> exclude(set<int>& all, set<int>& part) {
	set<int> s;
	for (int element : all) 
		if (part.find(element) == part.end())
			s.insert(element);
	return s;
}

void print(vector<int>& vec) {
	cout << "[";
	copy(vec.begin(), vec.end(), ostream_iterator<int>(cout, " "));
	cout << "]";
	cout << endl;
}

void iAmHere() {cout << "i am here" << endl;}

template<typename Element>
void print(const vector<Element>& container) {
	cout << "[";
	copy(container.begin(), container.end(), ostream_iterator<Element>(cout, " "));
	cout << "]";
	cout << endl;
}

template<typename Element>
void print(const set<Element>& container) {
	cout << "[";
	copy(container.begin(), container.end(), ostream_iterator<Element>(cout, " "));
	cout << "]";
	cout << endl;
}

template<typename Element>
void print(queue<Element> container) {
	cout << "[";
	while (!container.empty()) {
		Element& element = container.front();
		cout << element << " ";
		container.pop();
	}
	cout << "]";
	cout << endl;
}