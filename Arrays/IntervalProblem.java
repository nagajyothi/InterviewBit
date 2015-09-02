/*
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 For example:
 
 Given [1,3],[2,6],[8,10],[15,18],
 
 return [1,6],[8,10],[15,18].
 
 Make sure the returned intervals are sorted.
 */
import java.util.*;

public class IntervalProblem{
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1)
            return intervals;
        Collections.sort(intervals, new IntervalComparator());
        ArrayList<Interval> result = new ArrayList<Interval>();
        Stack<Interval> s = new Stack<Interval>();
        Interval prev = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(prev.end >= current.start){
                Interval merged = new Interval(prev.start, Math.max(prev.end, current.end));                
                prev = merged;
            }
            else{
                result.add(prev);
                prev = current;
            }
        }
        result.add(prev);
        return result;
    }
    
    public static void main(String[] args){
        IntervalProblem ip = new IntervalProblem();
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        ArrayList<Interval> result = ip.merge(intervals);
        for(int i =0; i < result.size(); i++){
            System.out.printf("[%d, %d] ", result.get(i).start, result.get(i).end);
        }
    }
}