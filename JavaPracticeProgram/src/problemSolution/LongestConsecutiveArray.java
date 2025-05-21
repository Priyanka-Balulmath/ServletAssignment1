package problemSolution;

	import java.util.HashSet;

	public class LongestConsecutiveArray {
	    public static int longestConsecutive(int[] nums) {
	        HashSet<Integer> numSet = new HashSet<>();
	        for (int num : nums) {
	            numSet.add(num);
	        }

	        int longest = 0;

	        for (int num : numSet) {
	            if (!numSet.contains(num - 1)) { // Start of a sequence
	                int length = 1;
	                while (numSet.contains(num + length)) {
	                    length++;
	                }
	                longest = Math.max(longest, length);
	            }
	        }

	        return longest;
	    }

	    public static void main(String[] args) {
	        int[] arr = {100, 4, 200, 1, 3, 2};
	        System.out.println(longestConsecutive(arr)); // Output: 4 (sequence: 1, 2, 3, 4)
	    }
	}
