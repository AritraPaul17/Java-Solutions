import java.util.ArrayList;

public class leetcode66 {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        if (digits[len-1]!=9){
            int []a = new int[len];
            for(int i=0;i<len;i++){
                a[i] = digits[i];
            }
            a[len-1] = a[len-1]+1;
            return a;
        }

        int pos = -1;
        for(int i=len-1;i>=0;i--){
            if(digits[i]!=9)
                break;
            pos = i;
        }
        System.out.println(pos);
        if(pos==0){
            int []a = new int[len+1];
            a[0] = 1;
            return a;
        }
        int []a = new int[len];
        for(int i=0;i<pos-1;i++){
            a[i] = digits[i];
        }
        a[pos-1] = digits[pos-1]+1;
        return a;
    }

    public static void main(String[] args) {
        int []digits = {9,8,9};
        int []a = plusOne(digits);
        for (int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }
}
