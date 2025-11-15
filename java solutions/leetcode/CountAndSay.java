import java.util.*;

public class CountAndSay {
    public static String countAndSay(int num){
        if(num==1){
            return "1";
        }
        String s = countAndSay(num-1);
        String str = "";
        int l = 0, r = 1, count = 1;
        while(r<s.length()){
            if(s.charAt(r)==s.charAt(r-1)){
                count++;
            }
            else{
                str = str + count + s.substring(l,l+1);
                count = 1;
                l=r;
            }
            r++;
        }
        str = str + count + s.substring(l,l+1);
        return str;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> a = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    a.add(1);
                }
                else{
                    a.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
            }
            list.add(a);
        }
        return list;
    }
    public static void main(String[] args) {
        int []nums = {2,4,16,3,9,81,6561};
        System.out.println();
    }
}
