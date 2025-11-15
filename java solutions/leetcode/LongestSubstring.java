import java.util.HashMap;
import java.util.HashSet;

class LongestSubstring{
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0, j = 0;
        if(length == 0 || length == 1){
            return  length;
        }
        int maxLen = 0;
        while(j<length){
            if(!map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),j);
            }
            else{
                maxLen = Math.max(maxLen,j-i);
                int a = i;
                i = map.get(s.charAt(j)) + 1;
                System.out.println(i);
                if(i==j)
                    map.clear();
                else{
                    for (int x=a;x<i;x++)
                        map.remove(s.charAt(x));
                }
                map.put(s.charAt(j),j);
            }
            j++;
        }
        maxLen = Math.max(maxLen,j-i);
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "wobgrovw";
        System.out.println(lengthOfLongestSubstring(s));
    }
}