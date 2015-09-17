#include <iostream>
#include <map>
#include <string>
#include <string.h>
#include <cstdio>
#include <cstdlib>
using namespace std;

int M,N;
map<string,string> mp;
string lst[2][1000];
int len[2];

int find_root(int j){
    int i=0;
    while(mp.count(lst[j][i])>0){
        lst[j][i+1]=mp[lst[j][i]];
        i++;
    }
    return i;
}


void sourcing(){
    int a[2];
    for(int j=0;j<2;j++)
        len[j]=find_root(j);

    bool b=false;
    int la=len[0],lb=len[1];
    while(la>=0&&lb>=0){
        if(lst[0][len[0]]==lst[1][lb]){
            la=len[0];
            b=true;
            break;
        }
        if(lst[1][len[1]]==lst[0][la]){
            lb=len[1];
            b=true;
            break;
        }
        la--;lb--;
    }
    if(b){
        while(la>=0&&lb>=0)
            if(lst[0][la]==lst[1][lb]){
                la--;lb--;
            }else{
                break;
            }
        la++;lb++;
        cout<<lst[0][la]<<"\n";
    }else{
        cout<<-1<<"\n";
    }
}


int main(){
	freopen("test.in", "r", stdin);

    cin>>N;
    string a,b;
    for(int i=0;i<N;i++){
        cin>>a>>b;
        mp[b]=a;
    }
    cin>>M;
    for(int i=0;i<M;i++){
        cin>>lst[0][0]>>lst[1][0];
        sourcing();
    }

    return 0;
}

