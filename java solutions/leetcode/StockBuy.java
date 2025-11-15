public class StockBuy {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int max = 0, l=0, r=1;
        while(r<len){
            if(prices[l]<prices[r]){
                max += prices[r] - prices[l];
                l = r;
            } else if (prices[l]>prices[r]) {
                l = r;
            }
            r++;
        }
        return max;
    }
    public static void main(String[] args) {
        int []prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }
}
