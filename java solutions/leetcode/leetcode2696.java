public class leetcode2696 {
    public static int solution(String s){
        int length = s.length();
        StringBuilder sb = new StringBuilder(s);
        int len = sb.length(), i = 1;
        s = s.replaceAll("AB","");
        s = s.replaceAll("CD","");
        return s.length();
    }
    public static void main(String[] args) {
//        StringBuilder s = new StringBuilder("ABFCACDB");
        System.out.println(solution("ABFCACDB"));
//        s.replace(0,2,"");
//        System.out.println(s);;
    }
}
