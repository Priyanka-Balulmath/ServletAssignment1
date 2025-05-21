package problemSolution;

public class MoveZerosToEnd {

	    public static void moveZerosToEnd(int[] nums) {
	        int index = 0; // Pointer for non-zero elements

	        // Move non-zero elements forward
	        for (int num : nums) {
	            if (num != 0) {
	                nums[index++] = num;
	            }
	        }

	        // Fill the remaining space with zeros
	        while (index < nums.length) {
	            nums[index++] = 0;
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {0, 1, 0, 3, 12};
	        moveZerosToEnd(arr);

	        System.out.print("Modified array: ");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	    }
	}
