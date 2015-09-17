// 想简单了，不仅有可能三段重合还有可能重合的更厉害

#include <cstdio>
#include <cstdlib>
#include <cstring>

//#define ONLINE_JUDGE

const int BUF_SIZE=1010;

int overlayEditNeeded(char l, char m, char r){
	if (l==m && m==r) return 0;
	else if (l==m || l==r || m==r) return 1;
	else return 2;
}

int normalEditNeeded(char l, char r){
	if (l==r) return 1;
	else return 0;
}

int geneMod(char *in, int k, int n){
	int overlayLength=k*2-n;
	int editNeeded=0;
	for (int i=0;i<k;++i){ // 以开头长度K的子串中的坐标为主循环变量
		if(i>=0 && i<overlayLength){ // 左侧重合段，比较三点相等，若不存在重合段则k*2-n为负，自动跳过
			editNeeded+=overlayEditNeeded(in[i], in[n-k+i], in[n-(k*2-n)+i]);
		}else if (i>=overlayLength && i<k-overlayLength){ // 中间不重合段，正常比较两点
			editNeeded+=normalEditNeeded(in[i], in[n-k+i]);
		}else if (i>=k-overlayLength && i<k){ // 右侧重合段，已经比较过了不再处理
			// do nothing
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
	for(int i=0;i<numCases;++i){
		if (scanf("%s\n%d\n", buffer, &k)!=2) return 2;
		int n=strlen(buffer);
		int result=geneMod(buffer, k, n);
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
