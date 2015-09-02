/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 You may assume that the intervals were initially sorted according to their start times.
 
 Example 1:
 
 Given intervals [1,3],[6,9] insert and merge [2,5] in as [1,5],[6,9].
 
 Example 2:
 
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 
 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 
 Make sure the returned intervals are also sorted.
 */
import java.util.*;
public class IntervalProblem2{
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval.start > newInterval.end){
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }
        int n = intervals.size();
        if(intervals == null || intervals.size() < 1){
            intervals.add(newInterval);
        }
        else if(newInterval.start <= intervals.get(0).start){
            intervals.add(0, newInterval);
        }
        else if(newInterval.start >= intervals.get(n-1).start){
            intervals.add(n, newInterval);
        }
        else{
            for(int i = 0; i < intervals.size()-1; i++){
                if(intervals.get(i).start < newInterval.start && newInterval.start < intervals.get(i+1).start){
                    intervals.add(i+1, newInterval);
                    //flag = 1;
                    break;
                }
                
            }
        }
        
        return merge(intervals);  
    }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1)
            return intervals;
        ArrayList<Interval> result = new ArrayList<Interval>();        
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
        IntervalProblem2 ip = new IntervalProblem2();
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        //intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,6));
        //intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        //intervals.add(new Interval(12,16));
        Interval newInterval = new Interval(1, 2);
        
        ArrayList<Interval> result = ip.insert(intervals, newInterval);
        for(int i =0; i < result.size(); i++){
            System.out.printf("[%d, %d] ", result.get(i).start, result.get(i).end);
        }
    }
}
