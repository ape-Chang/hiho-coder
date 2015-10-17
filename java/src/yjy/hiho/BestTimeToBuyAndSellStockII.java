package yjy.hiho;

public class BestTimeToBuyAndSellStockII {

	public int maxProfit1(int[] prices) {
		int N = prices.length;
		if(N==0){
			return 0;
		}
		int[] p = new int[N];
		p[0] = 0;
		for(int i=1;i<N;i++){
			int max = p[i-1];
			for(int j=i-1;j>=0;j--){
				max = Math.max(max,(p[j]+prices[i]-prices[j]));
			}
			p[i]=max;
		}
        return p[N-1];
    }
	
	public int maxProfit(int[] prices) {
		int R = 0;
		boolean hold = false;
		int buy = 0;
		int N = prices.length;
		if(N<=1){
			return 0;
		}else if(N==2){
			return Math.max(0,prices[1]-prices[0]);
		}
		int cur,next;
		for(int i=0;i<N-1;i++){
			cur = prices[i];
			next = prices[i+1];
			if(hold){
				if(cur>next){
					hold = false;
					R+=cur-buy;
				}
			}else{
				if(cur<next){
					hold = true;
					buy = cur;
				}
			}
		}
		
		if(hold){
			R+=prices[N-1]-buy;
		}
        return R;
    }
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockII s = new BestTimeToBuyAndSellStockII();
		int [] prices = {1,4,3,9,7,6,1,2};
		int R = s.maxProfit(prices);
		System.out.println(R);
	}

}
