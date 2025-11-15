import java.util.HashSet;

public class LongrstSubstring {
    static int lengthOfLongestSubstring(String s){
        int length = s.length();
        HashSet<Character> set = new HashSet<>();
    if(length == 0 || length == 1){
           return  length;
    }
    int maxLen = 0;
        for(int i=0;i<length;i++){
            int j = i;
            while(j<length){
                char c = s.charAt(j);
                if(!set.contains(c)){
                    set.add(c);
                    j++;
                }
                else{
                    set.clear();
                    break;
                }
            }
            if((j-i)>maxLen){
                maxLen = j-i;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
}
