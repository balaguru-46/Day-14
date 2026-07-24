import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {

    // Max Heap
    private PriorityQueue<Integer> left;

    // Min Heap
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        left.offer(num);

        // Move largest from left to right
        right.offer(left.poll());

        // Balance heaps
        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        }

        return (left.peek() + right.peek()) / 2.0;
    }
}