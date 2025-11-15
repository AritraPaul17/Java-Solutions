public class SearchPosition {
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
//        if(target>nums[len-1]){
//            return len;
//        }
//        else if(target<nums[0]){
//            return 0;
//        }
        if(len==0){
            return 0;
        }
        int mid = 0;
        int low = 0, high = len-1;
        while(low<=high){
            mid = (high+low)/2;
            if(target==nums[mid]){
                return mid;
            }
            else if(target<nums[mid]){
                high = mid-1;
            }
            else if(target>nums[mid]){
                low = mid+1;
            }
        }
        if(target>nums[mid]){
            return mid+1;
        }
        return  mid;
    }

    public static void main(String[] args) {
        int []a = {1,3,5,6,8,10};
        int target = 0 ;
        System.out.println(searchInsert(a,target));
    }
}
