/*
 * ����һ���Ƚϱ�׼�����������Ŀ�����Կ�����ʹ����������ķ�ʽ����ȫ���еı��֣����б����������֣�
 * 1) ������ʱ�������г��ȴ���4��ע��߽��ж���pos>=5����4�������Ҳ������Ź������붨��ķǷ��ߵĽ⴮
 * 2) Ȼ�����Ƿ����СHi��������Щֱ�����ӵıߣ�ֻ���ܴ�����Щ�ߵĽ⡣
 *
 * ���������2)���������˻�Ϊ��ȫ���Ϸ��Ź�������ĸ�����
 *
 * ������Ҫ������ѡ�����ڼ���ͱ�ʾ����ڲ����ݽṹ��
 * ���Ҫ������ʽ��Ϊ��ά���꣬��է����ȥ��ʾһ������������ʵ����ʵ�����������ǳ����ӡ�Ҫ�����ڽ�������չƽ��һά��
 * 1 4 7
 * 2 5 8
 * 3 6 9
 * Ȼ�����������ַ���ȫ���е�dfs�㷨ȥ����ȫ���У�ͬʱ���ù��˷������Ϸ���ĸ�����
 * ���Ӵ��У��������ڵĵ�֮����бߣ�����жϺϷ��ߵ�ʱ��ֻ��Ҫ���ǰһ����͵�ǰ���м��Ƿ���δ���ʵ������㣬����ٷ����
 * ���зǷ������μ��ɣ�ֻ�к�6��6б4��16�����Ρ�
 * ���СHi�����ı��Ƿ���ڵ�ʱ��ֱ�ӱ����⴮������бߣ�����ʹ�ÿռ任ʱ���Ƚ�СHi�����ı�չ����Ϊ����Ȼ��ֻ��Ҫ����1�顣
 */

/*
 * ����������ѵ�ǣ�
 * �߽磡�߽磡�߽磡��
 *
 * һ��ʼ����ͼʡ�£�visited[]��������1Ϊ�±�����Ժ�˳�����ڱ��沿�ֽ��buf����Ҳ����1Ϊ��㣬���Ǿ�ը�˹��ˡ�
 * ��ʵ֤������visited[]���ֱ������Ǹ�map��������1��Ϊ�±���㲢�������⣬��buf������ͨ�ģ���Ҫ�õ������õ����ֱ߽��жϵ�����
 * �����1��Ϊ�±꣬��ôҪô�Լ�����������ȫ�̱�����ȷͳһ��Ҫô����ʵʵ�������ù��˵�0��ͷ����ҪͻȻ��������������
 *
 * ���⣬��������߽����⣬һ��������˼ά���裬һ������õ��������������ϵһ��������ֽ�ϻ�������������ͷWA�˻���segfault��
 * ��DEBUG���ܾ��Ǳȸ����������ϵ��10����ʱ����ʧ��
 */

#include <cstdio>
#include <cstdlib>
#include <cstdio>
#include <vector>
#include <algorithm>

//#define ONLINE_JUDGE

using namespace std;

typedef pair<int, int> Line;

/*
 * ni: �����뵽����λ�ü�buf[pos]�ϵ�����
 */
bool checkValid(int *buf, bool *visited, int pos, int ni) {
	if (buf[pos - 1] == 1 && ni == 3 && !visited[2])
		return false;
	if (buf[pos - 1] == 3 && ni == 1 && !visited[2])
		return false;
	if (buf[pos - 1] == 4 && ni == 6 && !visited[5])
		return false;
	if (buf[pos - 1] == 6 && ni == 4 && !visited[5])
		return false;
	if (buf[pos - 1] == 7 && ni == 9 && !visited[8])
		return false;
	if (buf[pos - 1] == 9 && ni == 7 && !visited[8])
		return false;
	if (buf[pos - 1] == 1 && ni == 7 && !visited[4])
		return false;
	if (buf[pos - 1] == 7 && ni == 1 && !visited[4])
		return false;
	if (buf[pos - 1] == 2 && ni == 8 && !visited[5])
		return false;
	if (buf[pos - 1] == 8 && ni == 2 && !visited[5])
		return false;
	if (buf[pos - 1] == 3 && ni == 9 && !visited[6])
		return false;
	if (buf[pos - 1] == 9 && ni == 3 && !visited[6])
		return false;
	if (buf[pos - 1] == 1 && ni == 9 && !visited[5])
		return false;
	if (buf[pos - 1] == 9 && ni == 1 && !visited[5])
		return false;
	if (buf[pos - 1] == 3 && ni == 7 && !visited[5])
		return false;
	if (buf[pos - 1] == 7 && ni == 3 && !visited[5])
		return false;
	return true;
}

bool checkLines(int *buf, int length, vector<Line> lines){
	int numLines=lines.size();
	for(int i=0;i<numLines;++i){
		int p1=lines[i].first;
		int p2=lines[i].second;
		bool found=false;
		for(int i=0;i<length-1;++i){
			if ((buf[i]==p1 && buf[i+1]==p2) ||
					(buf[i]==p2 && buf[i+1]==p1))
				found=true;
		}
		if (!found) return false;
	}
	return true;
}
/*
 * pos: ��ǰ����չλ�ã���ЧֵΪ1��9������0��ʼ
 */
int dfs(int *buf, bool *visited, int posToFill, vector<Line> lines) {
	int cnt = 0;
	if (posToFill >= 4) { // pos=4ʱ�Ѿ����ɳ���Ϊ4���Ӵ�
		if(checkLines(buf, posToFill, lines))
			cnt += 1;
	}
	if (posToFill == 9) // posΪ9ʱ����Ϊ9���Ӵ��Ѿ�����
		return cnt;
	for (int i = 1; i <= 9; ++i) {
		if (!visited[i] && checkValid(buf, visited, posToFill, i)) {
			visited[i] = true;
			buf[posToFill] = i;
			cnt += dfs(buf, visited, posToFill + 1, lines);
			visited[i] = false;
			buf[posToFill] = 0;
		}
	}
	return cnt;
}

int calcPossiblePerms(vector<Line> lines) {
	// �ȼ���ȫ����
	int buf[10];
	bool visited[10];
	for (int i = 1; i <= 9; ++i) {
		buf[i] = 0;
		visited[i] = false;
	}
	int cnt = dfs(buf, visited, 0, lines);
	return cnt;
}

int solve() {
	int numCases;
	if (scanf("%d\n", &numCases) == EOF)
		return 1;
	for (int i = 0; i < numCases; ++i) {
		int numLineSeen;
		if (scanf("%d\n", &numLineSeen) == EOF)
			return 2;
		vector<Line> lines;
		lines.resize(numLineSeen);
		for (int i = 0; i < numLineSeen; ++i) {
			int x, y;
			if (scanf("%d %d\n", &x, &y) == EOF)
				return 3;
			lines[i].first = x;
			lines[i].second = y;
		}
		int result = calcPossiblePerms(lines);
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
