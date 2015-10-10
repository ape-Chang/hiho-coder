package yjy.hiho;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
    	int n = prices.length;
    	if(n<=1)return 0;
    	int[] p = new int[n];
    	int min = prices[0];
    	p[0] = -min;
    	for(int i=0;i<n;i++){
    		min = Math.min(min,prices[i]);
    		p[i] = -min;
    	}
    	int max = 0;
    	for(int i=0;i<n;i++){
    		int tmp = p[i]+prices[i];
    		max = Math.max(max,tmp);
    		p[i] = max;
    	}
    	max = -prices[0];
    	for(int i=0;i<n;i++){
    		int tmp = p[i]-prices[i];
    		max = Math.max(max,tmp);
    		p[i] = max;
    	}
    	max = 0;
    	for(int i=0;i<n;i++){
    		int tmp = p[i]+prices[i];
    		max = Math.max(max,tmp);
    		p[i] = max;
    	}
        return p[n-1];
    }
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII s = new BestTimeToBuyAndSellStockIII();
		int[] prices = {0,2,3,9,5,6};
		int r = s.maxProfit(prices);
		System.out.println(r);
	}

}
