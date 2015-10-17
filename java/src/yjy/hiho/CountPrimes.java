package yjy.hiho;

public class CountPrimes {
    public int countPrimes(int n) {
    	boolean[] m = new boolean[n];
    	if(n<=1)return 0;
    	int count = 0;
    	for(int i=2;i<n;i++){
    		if(m[i])continue;
    		count++;
    		for(int j=2*i;j<n;j+=i){
    			m[j]=true;
    		}
    	}
        return count;
    }
	public static void main(String[] args) {
		CountPrimes s = new CountPrimes();
		int r = s.countPrimes(0);
		System.out.println(r);
	}

}
