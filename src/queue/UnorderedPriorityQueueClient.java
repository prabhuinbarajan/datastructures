package queue;
import java.util.Comparator;
public class UnorderedPriorityQueueClient {

	public static void main(String[] args ) {
                Integer[] arr = {1, 5 , 3, 9, 2, 7, 8, 6};
                Comparator<Integer> comp = new Comparator<Integer>() {
                        public int compare(Integer d1, Integer d2) {
                                return d1.compareTo(d2);
                        }
                };
		Queue<Integer> queue = new UnorderedPriorityQueue<Integer> ( arr.length, comp);
		for(int i = 0; i < arr.length; i++)  {
			queue.enqueue(arr[i]);
		}
		System.out.println("ref : http://algs4.cs.princeton.edu/24pq/UnorderedArrayMaxPQ.java.html ");
		System.out.println("ref : http://algs4.cs.princeton.edu/24pq/");
		System.out.println("ref: characteristics : O(n) time for removal, o(1) for insertion");
		System.out.println("queue ");
		System.out.println(queue);
		for(int i = 0; i < arr.length; i++) {
			System.out.println("dequeue:" + queue.dequeue());
		}
		queue.dequeue();
	}

}
