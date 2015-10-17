package yjy.hiho;

public class BestTimeToBuyAndSellStock {
	
	public int maxProfit(int[] prices) {
		int n = prices.length;
		if(n<=1){
			return 0;
		}
		int[] min = new int[n];
		min[0] = prices[0];
		for(int i=1;i<n;i++){
			min[i] = Math.min(prices[i], min[i-1]);
		}
		int max = 0;
		for(int i=1;i<n;i++){
			max = Math.max(max,prices[i]-min[i-1]);
		}
        return max;
    }

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock s = new BestTimeToBuyAndSellStock();
		int[] prices = {1,4,2,3,4,7,8};
		int r = s.maxProfit(prices);
		System.out.println(r);
	}

}
