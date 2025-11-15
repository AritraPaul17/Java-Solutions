import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneNumber {
    static String getString(char c){
        switch (c){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }

    static void addString(String s,String sb,int n,List<String> list){
        if(sb.length()==n){
            list.add(sb.toString());
            return;
        }
        String str = getString(s.charAt(0));
        for(int i=0;i<str.length();i++){
            if(s.length()!=1)
                addString(s.substring(1),sb+str.substring(i,i+1),n,list);
            else
                addString("",sb+str.substring(i,i+1),n,list);
        }
    }
    static List<String> CombinationOfNumber(String s){
        int n = s.length();
        List<String> list = new ArrayList<>();
        String sb = "";
        addString(s,sb,n,list);
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
//        CombinationOfNumber("23");
//        System.out.println(getString('2'));
//        System.out.println(uniquePaths(2,3));

    }
}
