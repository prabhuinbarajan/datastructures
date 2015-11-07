
public class QueueClient {

	public static void main(String[] args ) {
		Queue<Integer> intQueue = new BoundedQueue<Integer> (5);
		//Queue<Integer> intQueue = new LinkedListQueue<Integer> ();
		System.out.println("ref: https://www.cs.princeton.edu/~rs/AlgsDS07/");
		System.out.println("ref: http://cs.lmu.edu/~ray/notes/queues/");
		System.out.println("ref: http://www.tutorialspoint.com/javaexamples/data_queue.htm");
		System.out.println("ref: http://oppansource.com/queue-implementation-in-java-using-circular-array/");
		intQueue.enqueue(1);
		intQueue.enqueue(5);
		intQueue.enqueue(7);
		System.out.println("peek " + intQueue.peek());
		System.out.println("queue ");
		System.out.println(intQueue);
		System.out.println("dequeue: " + intQueue.dequeue());
		System.out.println("dequeue: " + intQueue.dequeue());
		System.out.println("dequeue: " + intQueue.dequeue());
		System.out.println("dequeue: " + intQueue.dequeue());
		System.out.println("dequeue: " + intQueue.dequeue());


	}

}
