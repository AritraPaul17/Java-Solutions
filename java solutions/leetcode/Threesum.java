import java.util.*;

public class Threesum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (length < 3) return new ArrayList<>();

        Arrays.sort(nums);
        Set<List<Integer>> a = new HashSet<>();

        for(int i=0;i<length-2;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int l = i+1, r = length-1;
            while(r>l){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum==0){
                    a.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;r--;
                }
                else if(sum<0){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return new ArrayList<>(a);
    }
//a.add(Arrays.asList(nums[left], nums[i], nums[j]));
    public static void main(String[] args) {
        int []nums = {-1,0,1,2,-1,-4}; //[-4,-1,-1,0,1,2]
    }
}
