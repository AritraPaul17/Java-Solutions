import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    static void solve(ArrayList l,int n,int o,int c,String curr){
        if(curr.length()==2*n){
            l.add(curr);
            return;
        }
        if(o<n){
            solve(l,n,o+1,c,curr+"(");
        }
        if(c<o){
            solve(l,n,o,c+1,curr+")");
        }
    }
    static List<String> generateParenthesis(int n) {
        ArrayList<String> l = new ArrayList<>();
        String curr = "";
        int o = 0, c = 0;
        solve(l,n,o,c,curr);
        return l;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
