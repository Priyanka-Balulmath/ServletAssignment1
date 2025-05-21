package problemSolution;

public class BestTimeToBuySellStocks {

	    public static int maxProfit(int[] prices) {
	        if (prices.length == 0) return 0;

	        int minPrice = Integer.MAX_VALUE;
	        int maxProfit = 0;

	        for (int price : prices) {
	            minPrice = Math.min(minPrice, price); // Track lowest price
	            maxProfit = Math.max(maxProfit, price - minPrice); // Update max profit
	        }

	        return maxProfit;
	    }

	    public static void main(String[] args) {
	        int[] prices = {7, 1, 5, 3, 6, 4};
	        System.out.println("Maximum Profit: " + maxProfit(prices)); 
	        // Output: 5 (Buy at 1, Sell at 6)
	    }
	}