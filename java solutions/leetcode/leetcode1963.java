import java.util.Stack;

public class leetcode1963 {
    public static int sol(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                st.push('[');
            }
            else{
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }
        int count = 0;
        while(!st.isEmpty()){
            st.pop();
            count++;
        }
        return (count+1)/2;
    }
    public static void main(String[] args) {
        System.out.println(sol("]]][][[["));
    }
}
