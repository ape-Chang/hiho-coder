package yjy.hiho;

import java.util.Scanner;

public class Main1148 {
	
	static class MyDate{
		int year;
		int month;
		int day;
		MyDate(String dateStr){
			String[] A = dateStr.split(" ");
			String monthStr = A[0];
			if(monthStr.equals("January")){
				this.month = 1;
			}else if(monthStr.equals("February")){
				this.month = 2;
			}else if(monthStr.equals("March")){
				this.month = 3;
			}else if(monthStr.equals("April")){
				this.month = 4;
			}else if(monthStr.equals("May")){
				this.month = 5;
			}else if(monthStr.equals("June")){
				this.month = 6;
			}else if(monthStr.equals("July")){
				this.month = 7;
			}else if(monthStr.equals("August")){
				this.month = 8;
			}else if(monthStr.equals("September")){
				this.month = 9;
			}else if(monthStr.equals("October")){
				this.month = 10;
			}else if(monthStr.equals("November")){
				this.month = 11;
			}else if(monthStr.equals("December")){
				this.month = 12;
			}
			this.day = Integer.parseInt(A[1].substring(0, A[1].length()-1));
			this.year = Integer.parseInt(A[2]);
		}
		
		int compareTo2_29(){
			if(this.month==2){
				if(this.day == 29){
					return 0;
				}else if(this.day < 29){
					return -1;
				}else{
					return 1;
				}
			} else if(this.month>2){
				return 1;
			}else{
				return -1;
			}
		}
		
		boolean isLunNian(){
			if(this.year%400==0){
				return true;
			}
			if((this.year%4==0)&&(this.year%100!=0)){
				return true;
			}
			return false;
		}
	}
	
	public static int num4LunNianFromYear1(int year){
		int result = year/4;
		result -= year/100;
		result += year/400;
		return result;
	}
	
	public static void solveCase(int caseNum, Scanner scan){
		String dateStr1 = scan.nextLine();
		String dateStr2 = scan.nextLine();
		MyDate date1 = new MyDate(dateStr1);
		MyDate date2 = new MyDate(dateStr2);
		// 1
		if(date1.year == date2.year){
			if(date1.isLunNian() && date1.compareTo2_29()<=0 && date2.compareTo2_29()>=0){
				System.out.println("Case #"+caseNum+": 1");
				return;
			}else{
				System.out.println("Case #"+caseNum+": 0");
				return;
			}
		}
		int modifier = 0;
		if(date1.isLunNian()){
			if(date1.compareTo2_29()>0){
				modifier--;
			}
		}
		if(date2.isLunNian()){
			if(date2.compareTo2_29()<0){
				modifier--;
			}
		}
		int num1 = Main1148.num4LunNianFromYear1(date1.year-1);
		int num2 = Main1148.num4LunNianFromYear1(date2.year);
		int result = num2-num1+modifier;
		System.out.println("Case #"+caseNum+": "+result);
		return;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String NStr = scan.nextLine();
		int N = Integer.parseInt(NStr);
		for(int i=0;i<N;i++){
			Main1148.solveCase(i+1,scan);
		}
		scan.close();
	}
}
