package yjy.hiho;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
    public List<Interval> insert(List<Interval> intervals, Interval n) {
    	ArrayList<Interval> r = new ArrayList<Interval>();
    	boolean nAdded = false;
    	for(Interval i:intervals){
    		if(n.end>=i.start && n.start<=i.start && i.end>n.end){
				n.end = i.end;
			}else if(n.end>=i.end && n.start<=i.end && i.start<n.start){
				n.start = i.start;
			}else if(i.start<=n.start && i.end>=n.end){
				n.start = i.start;
				n.end = i.end;
			}else if(i.start>=n.start && i.end<=n.end){
			}else{
				if(!nAdded && i.start>n.start){
					r.add(n);
					nAdded = true;
				};
				r.add(i);
			}
    	}
    	if(!nAdded){
    		r.add(n);
    	}
        return r;
    }
	public static void main(String[] args) {
		InsertInterval s = new InsertInterval();
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(6,9));
		Interval newInterval = new Interval(0,0);
		List<Interval> r = s.insert(intervals, newInterval);
		for(Interval i:r){
			System.out.println(String.format("%d %d",i.start,i.end));
		}
	}

}
