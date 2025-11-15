import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class leetcode283 {
    public static void moveZeroes(int[] nums) {
        int left = 0, right = 0, count = 0;
        while(right < nums.length){
            if(count==0 && nums[right]==0){
                count = 1;
                left = right;
            }
            else if(count==1 && nums[right]!=0){
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
            }
            right++;
        }
    }

    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                sb.replace(sb.length()-1,sb.length(),"");
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static int maximumSwap(int num) {
        char []digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        int []maxright = new int[n];
        maxright[n-1] = n-1;
        for(int i = n-2;i>=0;i--){
            if(digits[i]>digits[maxright[i+1]]){
                maxright[i] = i;
            }
            else {
                maxright[i] = maxright[i+1];
            }
        }
        for(int i=0;i<n;i++){
            if(digits[maxright[i]]!=digits[i]){
                char temp = digits[maxright[i]];
                digits[maxright[i]] = digits[i];
                digits[i] = temp;
                return Integer.valueOf(new String(digits));
            }
        }
        return num;
    }


    public static int maxOperations(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<n;i++){
            if(nums[i]>=k){
                continue;
            }
            else{
                if(map.containsKey(k-nums[i])){
                    res++;
                    if(map.get(k-nums[i])==1)
                        map.remove(k-nums[i]);
                    else
                        map.put(k-nums[i],map.get(k-nums[i])-1);
                }
                else {
                    if(map.containsKey(nums[i]))
                        map.put(nums[i],map.get(nums[i])+1);
                    else
                        map.put(nums[i],1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int []nums = {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
//        System.out.println(removeStars("leet**cod*e"));
        System.out.println(maxOperations(nums,3));
    }
}
