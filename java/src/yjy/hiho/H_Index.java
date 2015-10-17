package yjy.hiho;

import java.util.PriorityQueue;

public class H_Index {
    public int hIndex(int[] a) {
    	PriorityQueue<Integer> q = new PriorityQueue<Integer>();
    	int n = a.length;
    	if(n==1&&a[0]>=1){
    		return 1;
    	}
    	for(int i=0;i<n;i++){
    		q.add(a[i]);
    	}
    	int[] c = new int[n];
    	for(int i=0;i<n;i++){
    		c[n-1-i]=q.poll();
    	}
    	int r=0;
    	boolean has = false;
    	for(int i=0;i<n-1;i++){
    		if(c[i]>=i+1 && c[i+1]<=i+1){
    			r = i+1;
    			has = true;
    			continue;
    		}
    	}
    	if(n>=1 && c[n-1]>=n){
    		r = n;
    		has = true;
    	}
    	if(has){
    		return r;
    	}else{
    		return 0;
    	}
    }
	public static void main(String[] args) {
		H_Index s = new H_Index();
		int[] citations = {0,1,0};
		int r = s.hIndex(citations);
		System.out.println(r);
	}
}
