import java.util.*;

public class Solution {

    public static int maxWidthRamp(int[] nums) {
        int len = nums.length;
        int []min = new int[len];
        int []max = new int[len];
        min[0] = nums[0]; max[len-1] = nums[len-1];
        for(int i=1;i<len;i++){
            if(nums[i]<=min[i-1])
                min[i] = nums[i];
            else
                min[i] = min[i-1];
        }
        for(int i=len-2;i>=0;i--){
            if(nums[i]>=max[i+1])
                max[i] = nums[i];
            else
                max[i] = max[i+1];
        }

        int i=0,j=0,maxWid = 0;;
        while(j<len){
            if(max[j]>=min[i]){
                maxWid = Math.max(maxWid,j-i);
                j++;
            }
            else{
                i++;
            }
        }
        return maxWid;
    }

    class RandomizedSet {
        HashSet<Integer> set ;
        public RandomizedSet() {
           set = new HashSet<>();
        }

        public boolean insert(int val) {
            if (set.contains(val)){
                return false;
            }
            set.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!set.contains(val)){
                return false;
            }
            set.remove(val);
            return true;
        }

        public int getRandom() {
            return set.iterator().next();
        }
    }

    public static int ceil(int val){
        if(val%3==0)
            return val/3;
        return val/3+1;
    }
    public static long maxKelements(int[] nums, int k) {
        int len = nums.length;
        long score = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<len;i++){
            heap.add(nums[i]);
        }
        for(int i=0;i<k;i++){
            long val = (long)heap.remove();
            score += val;
            heap.add(ceil((int)val));
        }
        return score;
    }


//    public static int maxUniqueSplit(String s) {
//        HashSet<String> set = new HashSet<>();
//        int len = s.length();
//        int i = 1, j = 0;
//        while(i<len){
//            if(!set.contains(s.substring(j,i))){
//                System.out.println(s.substring(j,i));
//                set.add(s.substring(j,i));
//                j = i;
//            }
//            i++;
//        }
//        if(j<len){
////            System.out.println(s.substring(j,i));
//            set.add(s.substring(j,i));
//            j = i;
//        }
//        return set.size();
//    }
    public static int maxUniqueSplit(String s) {
        return backtrack(0, s, new HashSet<>());
    }
    private static int backtrack(int start, String s, HashSet<String> seen) {
        if (start == s.length()) {
            return 0;
        }
        int maxSplits = 0;
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (!seen.contains(substring)) {
                seen.add(substring);
                maxSplits = Math.max(maxSplits, 1 + backtrack(end, s, seen));
                seen.remove(substring);
            }
        }
        return maxSplits;
    }


    public static void main(String[] args) {
        int []nums = {1,10,3,3,3};
//        System.out.println(maxWidthRamp(nums));
        //min = [6,0,0,0,0,0]
        //max = [8,8,8,5,5,5]
//        System.out.println(maxKelements(nums,3));
//        System.out.println(ceil(10));
//        int []asteroids = {5,10,-5,10,-5};
//        int []a = asteroidCollision(asteroids);
//        for (int el:a){
//            System.out.println(el);
//        }
//        System.out.println(maxUniqueSplit("wwwzfvedwfvhsww"));
    }
}
