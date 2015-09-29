package yjy.hiho;

import java.util.Scanner;

public class MainMS1 {
	static double MAX=0;
	static double x0;
	static double y0;
	static double r;
	static int R_X=0;
	static int R_Y=0;
	
	public static void checkUpRight(double dx,double dy){
		double R = r*r;
		int x = (int)dx;
		if(x!=dx){
			x++;
		}
		int y = (int)dy;
		if(y!=dy){
			y++;
		}
		while((x-x0)*(x-x0)+(y-y0)*(y-y0)<=R){
			y++;
		}
		y--;
		double B = x0+r;
		double D = (x-x0)*(x-x0)+(y-y0)*(y-y0);
		if(D<=R){
			if(D>MAX){
				MAX = D;
				R_X = x;
				R_Y = y;
			}else if(D==MAX){
				if(x>R_X){
					R_X = x;
					R_Y = y;	
				}else if(x==R_X && y>R_Y){
					R_X = x;
					R_Y = y;
				}
			}
		}
		while(x+1<=B){
			x++;
			while((x-x0)*(x-x0)+(y-y0)*(y-y0)>R && y-1>=y0){
				y--;
			}
			D = (x-x0)*(x-x0)+(y-y0)*(y-y0);
			if(D<=R){
				if(D>MAX){
					MAX = D;
					R_X = x;
					R_Y = y;
				}else if(D==MAX){
					if(x>R_X){
						R_X = x;
						R_Y = y;	
					}else if(x==R_X && y>R_Y){
						R_X = x;
						R_Y = y;
					}
				}
			}
		}
	}
	public static void checkUpLeft(double dx,double dy){
		double R = r*r;
		int x = (int)dx;
		int y = (int)dy;
		if(y!=dy){
			y++;
		}
		while((x-x0)*(x-x0)+(y-y0)*(y-y0)<=R){
			y++;
		}
		y--;
		double B = x0-r;
		double D = (x-x0)*(x-x0)+(y-y0)*(y-y0);
		if(D<=R){
			if(D>MAX){
				MAX = D;
				R_X = x;
				R_Y = y;
			}else if(D==MAX){
				if(x>R_X){
					R_X = x;
					R_Y = y;	
				}else if(x==R_X && y>R_Y){
					R_X = x;
					R_Y = y;
				}
			}
		}
		while(x-1>=B){
			x--;
			while((x-x0)*(x-x0)+(y-y0)*(y-y0)>R && y-1>=y0){
				y--;
			}
			D = (x-x0)*(x-x0)+(y-y0)*(y-y0);
			if(D<=R){
				if(D>MAX){
					MAX = D;
					R_X = x;
					R_Y = y;
				}else if(D==MAX){
					if(x>R_X){
						R_X = x;
						R_Y = y;	
					}else if(x==R_X && y>R_Y){
						R_X = x;
						R_Y = y;
					}
				}
			}
		}
	}
	public static void checkDownRight(double dx,double dy){
		double R = r*r;
		int x = (int)dx;
		if(x!=dx){
			x++;
		}
		int y = (int)dy;
		while((x-x0)*(x-x0)+(y-y0)*(y-y0)<=R){
			y--;
		}
		y++;
		double B = x0+r;
		double D = (x-x0)*(x-x0)+(y-y0)*(y-y0);
		if(D<=R){
			if(D>MAX){
				MAX = D;
				R_X = x;
				R_Y = y;
			}else if(D==MAX){
				if(x>R_X){
					R_X = x;
					R_Y = y;	
				}else if(x==R_X && y>R_Y){
					R_X = x;
					R_Y = y;
				}
			}
		}
		while(x+1<=B){
			x++;
			while((x-x0)*(x-x0)+(y-y0)*(y-y0)>R && y+1<=y0){
				y++;
			}
			D = (x-x0)*(x-x0)+(y-y0)*(y-y0);
			if(D<=R){
				if(D>MAX){
					MAX = D;
					R_X = x;
					R_Y = y;
				}else if(D==MAX){
					if(x>R_X){
						R_X = x;
						R_Y = y;	
					}else if(x==R_X && y>R_Y){
						R_X = x;
						R_Y = y;
					}
				}
			}
		}
	}
	public static void checkDownLeft(double dx,double dy){
		double R = r*r;
		int x = (int)dx;
		int y = (int)dy;
		while((x-x0)*(x-x0)+(y-y0)*(y-y0)<=R){
			y--;
		}
		y++;
		double B = x0-r;
		double D = (x-x0)*(x-x0)+(y-y0)*(y-y0);
		if(D<=R){
			if(D>MAX){
				MAX = D;
				R_X = x;
				R_Y = y;
			}else if(D==MAX){
				if(x>R_X){
					R_X = x;
					R_Y = y;	
				}else if(x==R_X && y>R_Y){
					R_X = x;
					R_Y = y;
				}
			}
		}
		while(x-1>=B){
			x--;
			while((x-x0)*(x-x0)+(y-y0)*(y-y0)>R && y+1<=y0){
				y++;
			}
			D = (x-x0)*(x-x0)+(y-y0)*(y-y0);
			if(D<=R){
				if(D>MAX){
					MAX = D;
					R_X = x;
					R_Y = y;
				}else if(D==MAX){
					if(x>R_X){
						R_X = x;
						R_Y = y;	
					}else if(x==R_X && y>R_Y){
						R_X = x;
						R_Y = y;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		MAX = 0;
		Scanner scan = new Scanner(System.in);
		x0 = scan.nextDouble();
		y0 = scan.nextDouble();
		r = scan.nextDouble();
		checkUpRight(x0,y0);
		checkUpLeft(x0,y0);
		checkDownRight(x0,y0);
		checkDownLeft(x0,y0);
		System.out.println(String.format("%d %d",R_X,R_Y));
		scan.close();
	}

}
