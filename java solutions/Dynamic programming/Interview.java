import java.util.Scanner;

public class Interview {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter target position: ");
        int[] arr = {12,11,8,1,3,10};
        int n = arr.length;
        int k = 3;
        int max = Integer.MIN_VALUE, ind = -1, i=0;
        while(i<n){
            if(max<arr[i]){
                max = arr[i];
                ind = i;
            }
            i++;
        }
        int l = -1, r = -1;
        if(ind-k+1<0){
            l = ind;
            r = ind + k - 1;
        }else{
            l = ind-k+1;
            r = ind;
        }
        for(int j=l;j<=r;j++){
            System.out.println(arr[j]);
        }
    }
}
