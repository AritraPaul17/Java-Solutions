public class challenge2220 {
    static int binary(int n){
        int bin = 0, i=1;
        while(n>0){
            bin += (n%2)*i;
            n /=2;
            i*=10;
        }
        return bin;
    }
    public static int minBitFlips(int start, int goal) {
        int binStart = binary(start);
        int binGoal = binary(goal);
        int checkGoal = binGoal;
        int count =0;
        int check = 0, i=1;
        while(check != checkGoal){
            int rStart = binStart % 10;
            int rGoal = binGoal % 10;
            if(rStart != rGoal){
                count++;
            }
            check += rGoal*i;
            i *= 10;
            System.out.println(check);
            binStart/=10;
            binGoal/=10;
        }
        while(binStart !=0){
            count++;
            binStart--;
        }
        return count;
    }

    public static String longestDiverseString(int a, int b, int c) {
        int maxLen = a+b+c;
        int ca = 0, cb = 0, cc = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<maxLen;i++){
            if((a>=b && a>=c && ca!=2) || (cb==2 && a>0) || (cc==2 && a>0)){
                sb.append('a');
                a--;
                ca++;
                cb=0;
                cc=0;
            }
            else if((b>=a && b>=c && cb!=2) || (ca==2 && b>0) || (cc==2 && b>0)){
                sb.append('b');
                b--;
                cb++;
                ca=0;
                cc=0;
            }
            else if((c>=a && c>=b && cc!=2) || (ca==2 && c>0) || (cb==2 && c>0)){
                sb.append('c');
                c--;
                cc++;
                ca=0;
                cb=0;
            }
            else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(minBitFlips(3,4));
        System.out.println(longestDiverseString(1,2,7));
    }
}
