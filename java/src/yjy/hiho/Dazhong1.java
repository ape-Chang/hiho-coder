package yjy.hiho;

import java.util.Scanner;

public class Dazhong1{
		  public static void main(String[] args){
		   Scanner scan = new Scanner(System.in);
		   int n = scan.nextInt();
		   scan.close();
		   int a=1,b=1;
		   if(n==0){return;}
		   System.out.println("1");
		   if(n==1){return;}
		   System.out.println("1");
		   if(n==2){return;}
		   for(int i=2;i<n;i++){
		    b=b+a;
		    a=b-a;
		    System.out.println(b);
		   }
		  } 
		}
