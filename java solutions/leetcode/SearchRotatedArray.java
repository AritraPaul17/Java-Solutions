public class SearchRotatedArray {
    public static int search(int[] nums, int target) {
        int len = nums.length;
        if(len==0){
            return -1;
        }
        if (len==1){
            if(nums[0]==target)
                return 0;
            return -1;
        }
        int k = 0;
        int l =0, r= len-1;
        while(r>=l){
            int mid = (r+l)/2;
            int left = ((mid-1)+len)%len;
            int right = (mid+1)%len;
            if(nums[mid]<nums[left] && nums[mid]<nums[right]){
                k = mid;
                break;
            }
            else if(nums[mid]>nums[left] && nums[mid]>nums[right]){
                k = mid + 1;
                break;
            }
            else if(nums[mid]>nums[left] && nums[mid]<nums[right]){
                if(nums[mid]>nums[len-1])
                    l = (mid+1)%len;
                else
                    r = ((mid-1)+len)%len;
            }
        }

        l =0; r= len-1;
        if(target<=nums[len-1]){
            l = k;
            r = len-1;
        }
        else{
            l = 0;
            r = k-1;
        }
        while(r>=l){
            int mid = (r+l)/2;
            if(nums[mid]==target){
                return mid;
            } else if (nums[mid]>target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []nums = {7,0,1,2,4,5,6};
        int target = 2;

        System.out.println(search(nums,target));
    }
}
