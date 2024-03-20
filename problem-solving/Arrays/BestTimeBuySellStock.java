package Arrays;

public class BestTimeBuySellStock {
    public static void main(String[] args) {
        int[] prices = new int[]{7,6,4,3,1};
        int currentMin = prices[0];
        int profit = 0;
        for (int price : prices) {
            if (price < currentMin) currentMin = price;
            int currentProfit = price - currentMin;
            if (currentProfit > profit) profit = currentProfit;
        }
        System.out.println(profit);
    }
}
