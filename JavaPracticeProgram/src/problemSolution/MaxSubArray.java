package problemSolution;

public class MaxSubArray {
	    public static int maxSubArray(int[] nums) {
	        int maxSum = nums[0]; // Initialize max sum
	        int currentSum = nums[0]; // Initialize current sum

	        for (int i = 1; i < nums.length; i++) {
	            currentSum = Math.max(nums[i], currentSum + nums[i]); // Extend or start new subarray
	            maxSum = Math.max(maxSum, currentSum); // Update max sum
	        }

	        return maxSum;
	    }

	    public static void main(String[] args) {
	        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
	        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums)); 
	        // Output: 6 (Subarray: [4, -1, 2, 1])
	    }
	}
