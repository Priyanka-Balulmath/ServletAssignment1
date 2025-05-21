package problemSolution;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding elements
        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(1);

        // Retrieving and removing elements
        System.out.println("Head of Queue: " + pq.peek()); // Retrieves the smallest element
        while (!pq.isEmpty()) {
            System.out.println("Removed: " + pq.poll()); // Removes elements in priority order
        }
    }
}
