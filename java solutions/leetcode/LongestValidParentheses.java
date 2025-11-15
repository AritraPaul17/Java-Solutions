
public class LongestValidParentheses {
    static int longestValidParentheses(String s){
        int len = s.length();
        int maxLen = 0, count = 0;
        int o = 0, c = 0;
        for(int i =0;i<len;i++){
            if(s.charAt(i)=='('){
                o++;
            } else if (s.charAt(i)==')') {
                c++;
            }
            if(o==c){
                count = 2*o;
            }
            if(c>o){
                o=0;
                c=0;
                if (maxLen<count){
                    maxLen = count;
                }
                count=0;
            }
        }
        if (maxLen<count){
            maxLen = count;
        }
        o=0; c=0; count=0;
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)==')'){
                c++;
            } else if (s.charAt(i)=='(') {
                o++;
            }
            if(o==c){
                count = 2*c;
            }
            if(c<o){
                o=0;
                c=0;
                if (maxLen<count){
                    maxLen = count;
                }
                count=0;
            }
        }
        if (maxLen<count){
            maxLen = count;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = ")()(()()(";
        System.out.println(longestValidParentheses(s));
    }
}
