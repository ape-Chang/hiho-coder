package yjy.hiho;

public class KthLargestElementInAnArray {
	
	class Heap{
		int[] heap;
		int k;
		void add(int n){
			if(n>heap[0]){
				heap[0] = n;
				this.adjust(0);
			}
		}
		void adjust(int i){
			int cur = i;
			while(cur<k){
				if(2*cur+1<k){
					int a,l,r;
					a = heap[cur];
					if(2*cur+2<k){
						l = heap[2*cur+1];
						r = heap[2*cur+2];
						if(a<=l && a<=r){
							break;
						}else{
							if(l<r){
								heap[cur] = l;
								heap[2*cur+1] = a;
								cur = 2*cur+1;
							}else{
								heap[cur] = r;
								heap[2*cur+2] = a;
								cur = 2*cur+2;
							}
						}
					}else{
						l = heap[2*cur+1];
						if(a<=l){
							break;
						}else{
							heap[cur] = l;
							heap[2*cur+1] = a;
							cur = 2*cur+1;
						}
					}
				}else{
					break;
				}
			}
		}
		Heap(int size,int[] nums){
			this.k = size;
			this.heap = new int[k];
			for(int i=0;i<k;i++){
				this.heap[i]=nums[i];
			}
			for(int i=k-1;i>=0;i--){
				this.adjust(i);
			}
		}
	}
	
    public int findKthLargest(int[] nums, int k) {
    	int n = nums.length;
    	if(n<k || n==0){
    		return -1;
    	}
    	Heap heap = new Heap(k,nums);
    	for(int i=k;i<n;i++){
    		heap.add(nums[i]);
    	}
        return heap.heap[0];
    }
	public static void main(String[] args) {
		KthLargestElementInAnArray s = new KthLargestElementInAnArray();
		int[] nums = {5,2,4,3,1};
		int r = s.findKthLargest(nums, 5);
		System.out.println(r);
	}

}
