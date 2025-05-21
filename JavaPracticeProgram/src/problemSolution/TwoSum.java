package problemSolution;

import java.util.HashMap;

public class TwoSum {
    public static int[] findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i]; 
            if (seen.containsKey(diff)) {
                return new int[]{seen.get(diff), i}; // Return indices of the two numbers
            }
            seen.put(nums[i], i); // Store the current number with its index
        }
        
        return new int[]{-1, -1}; // Return an invalid index pair if no solution found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = findTwoSum(nums, target);
        
        System.out.println("Indices: " + result[0] + ", " + result[1]); // Output: 0, 1 (since 2 + 7 = 9)
    }
}
