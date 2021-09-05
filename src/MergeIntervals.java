import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }
        intervalList.sort(Comparator.comparingInt(i -> i.start));
        for(int i=0;i<intervalList.size() - 1;) {
            Interval i1 = intervalList.get(i), i2 = intervalList.get(i+1);
            if(i1.end >= i2.start) {
                if(i2.end > i1.end)
                    i1.end = i2.end;
                intervalList.remove(i+1);
                if(intervalList.size() < 2) break;
            } else {
                i++;
            }
        }
        int[][] result = new int[intervalList.size()][2];
        int i=0;
        for(Interval iVal: intervalList) {
            result[i][0] = iVal.start;
            result[i++][1] = iVal.end;
        }
        return result;
    }

    static class Interval {
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
