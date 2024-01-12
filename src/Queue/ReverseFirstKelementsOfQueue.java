package Queue;

//File Created by -- > anuragbhatt
//Created On -- > 12/01/24,Friday

import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseFirstKelementsOfQueue {

    public static void main(String[] args) {

        var q = new ArrayDeque<Integer>();
        q.add(1); q.add(2); q.add(3); q.add(4); q.add(5);

        System.out.println(modifyQueue(q, 3));
    }

    public static Queue<Integer> modifyQueue (Queue<Integer> q , int k )
    {
        ArrayDeque<Integer> reversedQueue = new ArrayDeque<>();

        // Move the first k elements from the original queue to reversedQueue
        for (int i = 0; i < k && !q.isEmpty(); i++) {
            reversedQueue.addFirst(q.remove());
        }

        // Move the remaining elements from the original queue to reversedQueue
        while (!q.isEmpty()) {
            reversedQueue.add(q.remove());
        }

        q.addAll(reversedQueue);

        return q;
    }
}
