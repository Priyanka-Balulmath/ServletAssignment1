package problemSolution;

	class ListNodes {
	    int val;
	    ListNode next;
	    ListNodes(int val) { this.val = val; }
	}

	public class RemoveDuplicatesSortedList {
	    public static ListNode deleteDuplicates(ListNode head) {
	        ListNode current = head;

	        while (current != null && current.next != null) {
	            if (current.val == current.next.val) {
	                current.next = current.next.next; // Skip duplicate node
	            } else {
	                current = current.next; // Move to next distinct node
	            }
	        }

	        return head;
	    }

	    public static void main(String[] args) {
	        ListNode head = new ListNode(1);
	        head.next = new ListNode(1);
	        head.next.next = new ListNode(2);
	        head.next.next.next = new ListNode(3);
	        head.next.next.next.next = new ListNode(3);

	        ListNode result = deleteDuplicates(head);
	        while (result != null) {
	            System.out.print(result.val + " -> ");
	            result = result.next;
	        }
	        System.out.println("null");
	    }
	}
