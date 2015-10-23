package yjy.hiho;

import java.util.HashMap;

public class MaxPointsOnALine {
	
	static class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}

    public int maxPoints(Point[] points) {
    	int n = points.length;
    	if(n==0)return 0;
    	else if(n==1)return 1;
    	else if(n==2)return 2;
    	int max = 2;
    	for(int i=0;i<n;i++){
    		HashMap<Double,Integer> map = new HashMap<Double,Integer>();
    		Point base = points[i];
    		int samex = 0;
    		int samep = 0;
    		int submax = 0;
    		for(int j=0;j<n;j++){
    			Point pp = points[j];
    			if(base.x==pp.x && base.y==pp.y){
    				samep++;
    				continue;
    			}
    			if(base.x==pp.x){
    				samex++;
    				continue;
    			}
    			double k = (double)(pp.y-base.y)/(double)(pp.x-base.x);
    			Integer count = map.get(k);
    			if(count==null){
    				count = 0;
    				map.put(k,count);
    			}
    			map.put(k,count+1);
    			submax = Math.max(submax,count+1);
    		}
    		max = Math.max(max,samex+samep);
    		max = Math.max(max,submax+samep);
    	}
        return max;
    }
	
	public static void main(String[] args) {
		MaxPointsOnALine s = new MaxPointsOnALine();
		Point[] points = new Point[9];
		points[0] = new Point(84,250);
		points[1] = new Point(0,0);
		points[2] = new Point(1,0);
		points[3] = new Point(0,-70);
		points[4] = new Point(0,-70);
		points[5] = new Point(1,-1);
		points[6] = new Point(21,10);
		points[7] = new Point(42,90);
		points[8] = new Point(-42,-230);
		int r = s.maxPoints(points);
		System.out.println(r);
	}

}
