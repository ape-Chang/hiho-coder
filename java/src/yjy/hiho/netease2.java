package yjy.hiho;

import java.util.Scanner;

public class netease2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()){
			int n = scan.nextInt();
			int c = scan.nextInt();
			for(int i=0;i<n;i++){
				int b = scan.nextInt();
				if(b<=c){
					c+=b;
				}else{
					c+=xymod(c,b);
				}
			}
			System.out.println(c);
		}
		scan.close();
	}
	
	public static int xymod(int a,int b){
        if(a<b){
        	int temp;
        	temp=a;
        	a=b;
        	b=temp;
        }
        if(0==b){
        	return a;
        }
        return xymod(a-b,b);
	}
}
