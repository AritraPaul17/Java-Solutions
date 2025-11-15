import java.util.*;

public class practise {
    public static void stringPerm(String s,String perm){
        if(s.length()==0){
            System.out.println(perm);
            return;
        }
        for(int i=0;i<s.length();i++){
            String str = s.substring(0,i)+s.substring(i+1);
            stringPerm(str,perm+s.substring(i,i+1));
        }
    }
    public static int path(int m,int n, int i, int j){
        if(i==m || j==n){
            return 0;
        }
        if (i==m-1 && j==n-1){
            return 1;
        }
        int count  = path(m,n,i+1,j) + path(m,n,i,j+1);
        return count;
    }
    public  static int placeTiles(int m,int n,int i,int j){
        if(m==0 && n==0){
            return 1;
        }
        //vertically
        int vert = placeTiles(m-j,n-i,i,j);
        //horizontally
        int hori = placeTiles(m-i,n-j,i,j);
        return vert + hori;
    }

    public static int solve(int []nums, int maxOR,int or,int i){
        if(i==nums.length) {
            if(maxOR==or) return 1;
            return 0;
        }

        int take = solve(nums,maxOR,or|nums[i],i+1);
        int dont = solve(nums,maxOR,or,i+1);
        return take+dont;
    }
    public static int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for(int i=0;i< nums.length;i++){
            maxOR |=nums[i];
        }
        int result = solve(nums,maxOR,0,0);
        return result;
    }

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int []rightSum = new int[n];
        rightSum[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            rightSum[i] = rightSum[i+1] + nums[i+1];
        }
        int leftSum = 0;
        for(int i=0;i<n;i++){
            if(rightSum[i]==leftSum)
                return i;
            else
                leftSum += nums[i];
        }
        return -1;
    }

    private static String getString(int n){
        StringBuilder s = new StringBuilder("0");
        for(int i=1;i<n;i++){
            StringBuilder str = new StringBuilder("1");
            for(int j=s.length();j>=0;j--){
                if(s.charAt(i)=='0')
                    str.append("1");
                else
                    str.append("0");
            }
            s.append(str) ;
        }
        return s.toString();
    }
    public char findKthBit(int n, int k) {
        int len = (int)Math.pow(2,n) - 1;
        char c;
        if(k==1) return '0';
        if(k==len/2+1)
            return '1';
        else if(k<len/2+1){
            c = findKthBit(n-1,k);
        }

        else{
            c = (findKthBit(n-1,len - k +1)=='0')?'1':'0';
        }
        return c;
    }


    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<len;i++){
            if(nums[i]>0)
                set.add(nums[i]);
        }
        int i=1;
        while(i>0){
            if(!set.contains(i))
                break;
            i++;
        }
        return i;
    }

    public static String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        set.add('A');set.add('E');set.add('I');set.add('O');set.add('U');
        StringBuilder sb = new StringBuilder(s);
        int l = 0, r = s.length()-1;
        while(r>l){
            while(l<s.length()){
//                System.out.println(s.charAt(l));
                if(set.contains(s.charAt(l))){
                    break;
                }
                l++;
            }
            while(r>=0){
                if(set.contains(s.charAt(r))){
                    break;
                }
                r--;
            }
            if(r>l){
                char c = sb.charAt(l);
                sb.setCharAt(l, sb.charAt(r));
                sb.setCharAt(r, c);
            }
            r--; l++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        stringPerm("abc","");
//        System.out.println(path(3,4,0,0));
//        placeTiles(2,4,1,2);
        int []nums = {1,2,0};
//        System.out.println(countMaxOrSubsets(nums));
//        System.out.println((firstMissingPositive(nums)));

        System.out.println(reverseVowels("IceCreAm"));
    }
}
