package problemSolution;

public class RemoveDuplicates {

	    public static int removeDuplicates(int[] nums) {
	        if (nums.length == 0) return 0;

	        int uniqueIndex = 0; // Pointer for unique elements

	        for (int i = 1; i < nums.length; i++) {
	            if (nums[i] != nums[uniqueIndex]) {
	                uniqueIndex++;
	                nums[uniqueIndex] = nums[i]; // Place the next unique element
	            }
	        }

	        return uniqueIndex + 1; // Length of array with unique elements
	    }

	    public static void main(String[] args) {
	        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5};
	        int length = removeDuplicates(arr);

	        System.out.println("Array length after removing duplicates: " + length);
	        System.out.print("Modified array: ");
	        for (int i = 0; i < length; i++) {
	            System.out.print(arr[i] + " ");
	        }
	    }
	}
