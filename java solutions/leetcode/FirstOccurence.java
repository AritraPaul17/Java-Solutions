public class FirstOccurence {
    public static int strStr(String haystack, String needle) {
        int needLen = needle.length();
        int loopLen = haystack.length() - needLen;
        for(int i=0;i<loopLen+1;i++){
            String s = haystack.substring(i,i+needLen);
            if(s.equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(strStr("leetcode","leeto"));;
    }
}
