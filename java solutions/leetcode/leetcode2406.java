public class leetcode2406 {
    public int minGroups(int[][] intervals) {
        int len = intervals.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            min = Math.min(min,intervals[i][0]);
            max = Math.max(max,intervals[i][1]);
        }
        int res[] = new int[max+2];
        for(int i=0;i<len;i++){
            res[intervals[i][0]]++;
            res[intervals[i][1]+1]--;
        }
        int sum = 0, val = Integer.MIN_VALUE;
        for (int i=0;i< max+2;i++){
            sum += res[i];
            val = Math.max(val,sum);
        }
        return val;
    }

    public static void main(String[] args) {
        leetcode2406 lc = new leetcode2406();
        int [][]intervals = {{5,10},{6,8},{1,5},{2,3},{1,10}};
        System.out.println(lc.minGroups(intervals));
    }
}
