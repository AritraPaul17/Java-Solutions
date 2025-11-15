public class leetcode189 {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int []a = new int[len];
        for(int i=3;i<k;i++){
            int ind = len - i;
            int val = nums[ind];

        }
    }

    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
        for (int i=0;i< nums.length;i++)
            System.out.println(nums[i]);
    }
}
