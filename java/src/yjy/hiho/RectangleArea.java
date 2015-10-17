package yjy.hiho;

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int A1 = Math.abs(A-C)*Math.abs(B-D);
    	int A2 = Math.abs(E-G)*Math.abs(H-F);
    	int a=0,b=0;
    	if(A<=E&&E<=C&&C<=G){
    		a = Math.abs(C-E);
    	}else if(E<=A&&A<=G&&G<=C){
    		a = Math.abs(G-A);
    	}else if(A<=E&&E<=G&&G<=C){
    		a = Math.abs(G-E);
    	}else if(E<=A&&A<=C&&C<=G){
    		a = Math.abs(C-A);
    	}
    	
    	if(B<=F&&F<=D&&D<=H){
    		b = Math.abs(D-F);
    	}else if(F<=B&&B<=H&&H<=D){
    		b = Math.abs(H-B);
    	}else if(B<=F&&F<=H&&H<=D){
    		b = Math.abs(H-F);
    	}else if(F<=B&&B<=D&&D<=H){
    		b = Math.abs(D-B);
    	}
    	
        return A1+A2-a*b;
    }
	public static void main(String[] args) {
		RectangleArea s = new RectangleArea();
		int r = s.computeArea(-3,0,3,4,0,-1,9,2);
		System.out.println(r);
	}

}
