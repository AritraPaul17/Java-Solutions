import java.util.Arrays;

public class LongestCommonPrefix {
    static String longestCommonPrefix(String []s){
        if(s.length==1){
            return s[0];
        }
        Arrays.sort(s);
        int len = s.length;
        int i =0;
        while(i<s[0].length() && i<s[len-1].length()){
            if(s[0].charAt(i)!=s[len-1].charAt(i)){
                break;
            }
            i++;
        }
        return s[0].substring(0,i);
    }

    public static void main(String[] args) {
        String []s = {"flow","flower","fluent","jhut"};
        System.out.println(longestCommonPrefix(s));
    }
}
