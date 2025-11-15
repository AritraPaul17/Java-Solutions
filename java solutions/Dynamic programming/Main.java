import java.util.*;

public class Main {

        private static void permute(String s,String ans, Set<String> set) {
            if(s.length()==0){
                set.add(ans);
                return;
            }
            for(int i=0;i<s.length();i++){
                String str = s.substring(0,i) + s.substring(i+1);
                permute(str,ans+s.charAt(i),set);
            }
        }

    public static String[] findPermutations(String str){
        //Implement your code here and change the return value accordingly
        Set<String> uniquePerms = new LinkedHashSet<>();
        permute(str,"",uniquePerms);
        String arr[] = new String[uniquePerms.size()];
        int k=0;
        for(String s:uniquePerms){
            arr[k++] = s;
        }
        return arr;
    }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            for(int i=0;i<t;i++){

                String str = sc.next();
                String permutations[] = findPermutations(str);
                for(String permutation: permutations){
                    if (permutation!=null)
                        System.out.println(permutation);
                }
            }
        }
}