package yjy.hiho;

import java.util.Scanner;

// 这都行！！ 笑尿
public class netease1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k =scan.nextInt();
		int[][] A = new int[n][m];
		for(int i=0;i<k;i++){
			int x = scan.nextInt()-1;
			int y = scan.nextInt()-1;
			A[x][y]++;
		}
		scan.close();
		int[][] BMap = new int[n][m];
		for(int i0=0;i0<n;i0++){
			for(int j0=0;j0<m;j0++){
				for(int i=i0;i<Math.min(n,i0+3);i++){
					for(int j=j0;j<Math.min(m,j0+3);j++){
						BMap[i0][j0]+=A[i][j];
					}
				}
			}
		}
		
		int max = 0;
		for(int i1=0;i1<n;i1++){
			for(int j1=0;j1<m;j1++){
				for(int i2=i1;i2<n;i2++){
					for(int j2=0;j2<m;j2++){
						int tmp = BMap[i1][j1]+BMap[i2][j2];
						if(i2-i1<3 && Math.abs(j1-j2)<3){
							if(j2>=j1){
								for(int q=i2;q<=Math.min(n-1,i1+2);q++){
									for(int p=j2;p<=Math.min(m-1,j1+2);p++){
										tmp-=A[q][p];
									}
								}
							}else{
								for(int q=i2;q<=Math.min(n-1,i1+2);q++){
									for(int p=j1;p<=Math.min(m-1,j2+2);p++){
										tmp-=A[q][p];
									}
								}
							}
						}
						max = Math.max(max,tmp);
					}
				}
			}
		}
		System.out.println(max);
	}
}
