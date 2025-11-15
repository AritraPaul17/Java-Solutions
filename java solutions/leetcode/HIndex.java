public class HIndex {
    public static int hIndex(int[] citations) {
        int len = citations.length;
        int [] a = new int[len+1];
        for(int i=0;i<len;i++){
            if(citations[i]>=len){
                a[len]++;
            }
            else{
                a[citations[i]]++;
            }
        }
        int count = 0;
        for(int i=a.length-1;i>=0;i--){
            count += a[i];
            if(count>=i){
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] citations = {1,3,1};
        System.out.println(hIndex(citations));
    }
}
