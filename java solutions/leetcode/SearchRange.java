public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int []a = {-1,-1} ;
        if (len==0){
            return a;
        }
        int l = 0, r = len-1,found = -1;
        int low = -1, up = -1;
        while(r>l){
            int mid = (r+l)/2;
            if(nums[mid]==target){
                found = mid;
                low = up = found;
                a[0] = low;
                a[1] = up;
                break;
            } else if (nums[mid]>target) {
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        if(l>r){
            return a;
        }

        int left = l, right = r;
        while(left<=right){
            int mid = (right+left)/2;
            if(nums[mid]==target){
                low = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        a[0] = low;

        left = l; right = r;
        while(left<=right){
            int mid = (right+left)/2;
            if(nums[mid]==target){
                up = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        a[1] = up;

        return a;
    }

    public static void main(String[] args) {

        int []nums = {};
        int []a = searchRange(nums,6);
        System.out.println(a[0]+"  "+a[1]);

    }
}
