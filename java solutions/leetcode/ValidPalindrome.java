public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String sb = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int l = 0, r = sb.length()-1;
        System.out.println(sb);
        while(r>l){
            if(sb.charAt(l) != sb.charAt(r)){
                return false;
            }
            l++; r--;
        }
        return  true;
    }

    public static void main(String[] args) {
        String s = "A man, a_plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
