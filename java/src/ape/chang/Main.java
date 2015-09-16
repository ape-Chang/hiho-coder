package ape.chang;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {  
    
    static class FourSegments {
	static class Point {
	    public int x, y;
	    public static Point readPoint(Scanner scanner) {
		Point point = new Point();
		point.x = scanner.nextInt();
		point.y = scanner.nextInt();
		return point;
	    }
	    @Override public boolean equals(Object obj) {
		if (obj instanceof Point && x == ((Point) obj).x && y == ((Point) obj).y)
		    return true;
		else
		    return false;
	    }
	    @Override public int hashCode() {return x<<16 + y;}
	}
	static class Segment {
	    Point from;
	    Point to;
	    public Segment(Point from, Point to) {this.from = from; this.to = to;}
	    public boolean connectedTo(Segment segment) {
		return (this.from.equals(segment.from) || this.from.equals(segment.to) ||
			this.to.equals(segment.from) || this.to.equals(segment.to));
	    }
	    public boolean parallelTo(Segment segment) {
		return (from.x-to.x)*(segment.from.y-segment.to.y) == 
			(from.y-to.y)*(segment.from.x-segment.to.x);
	    }
	    public boolean perpendicularTo(Segment segment) {
		return (from.x-to.x)*(segment.from.x-segment.to.x) + 
			(from.y-to.y)*(segment.from.y-segment.to.y) == 0;
	    }
	}
	public Set<Point> points;
	public List<Segment> segments;
 	public FourSegments() {
	    points = new HashSet<Point>();
	    segments = new ArrayList<Segment>();
	}
	public static FourSegments readFourSegments(Scanner scanner) {
	    FourSegments r = new FourSegments();
	    for (int i = 0; i < 4; ++i) {
		 Point p = Point.readPoint(scanner);
		 Point q = Point.readPoint(scanner);
		 r.points.add(p);
		 r.points.add(q);
		 r.segments.add(new Segment(p, q));
	    }
	    return r;
	}
	public boolean isRectangele() {
	    if (points.size() != 4) return false;
	    Segment p = segments.get(0);
	    for (int i = 1; i < 4; ++i) {
		Segment q = segments.get(i);
		if ((p.connectedTo(q) && p.perpendicularTo(q)) || 
			(!p.connectedTo(q) && p.parallelTo(q)))
		    continue;
		return false;
	    }
	    return true;
	}
    }

    public static void main(String[] args) {
	try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
	Scanner scanner = new Scanner(System.in);
	int t = Integer.valueOf(scanner.nextLine());
	while (t-- > 0) {
	    if (FourSegments.readFourSegments(scanner).isRectangele())
		System.out.println("YES");
	    else
		System.out.println("NO");
	}
	scanner.close();
    }

}

