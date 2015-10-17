package yjy.hiho;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class MergeIntervals {
	static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
    public List<Interval> merge(List<Interval> intervals) {
    	ArrayList<Interval> r = new ArrayList<Interval>();
    	if(intervals.size()==0){
    		return r;
    	}
    	TreeMap<Integer,Interval> map = new TreeMap<Integer,Interval>();
    	for(Interval i:intervals){
    		Interval tmp = map.get(i.start);
    		if(tmp == null || tmp.end<i.end){
    			map.put(i.start, i);
    		}
    	}
    	Iterator<Interval> it = map.values().iterator();
    	int start,bound;
    	Interval first = it.next();
    	start = first.start;
    	bound = first.end;
    	while(true){
    		if(!it.hasNext()){
    			r.add(new Interval(start,bound));
    			break;
    		}
    		Interval i = it.next();
    		if(i.start<=bound){
    			bound = Math.max(bound,i.end);
    		}else{
    			r.add(new Interval(start,bound));
    			start = i.start;
    			bound = i.end;
    		}
    	}
        return r;
    }
	public static void main(String[] args) {
		MergeIntervals s = new MergeIntervals();
		ArrayList<Interval> l = new ArrayList<Interval>();
		l.add(new Interval(2,3));
		l.add(new Interval(5,5));
		l.add(new Interval(2,2));
		l.add(new Interval(3,4));
		l.add(new Interval(3,4));
		List<Interval> r = s.merge(l);
		for(Interval i:r){
			System.out.println(String.format("%d %d",i.start,i.end));
		}
	}

}
