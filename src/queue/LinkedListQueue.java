

public class LinkedListQueue<E> implements Queue<E> {
	class Node {
		E item;
		Node next;
	}
	Node head;
	Node tail;
	int size;
	public LinkedListQueue() {
	}	
	
	public boolean isFull() {
		return false;
	}
	public boolean isEmpty() {
		return (head==null);
	}

	public void enqueue(E item) {
		Node node = new Node();
		node.item = item;
		if(head== null) {
			head = tail = node;
		}else {
			tail.next = node;
			tail = node;
		}
		size++;
	}
	public E dequeue() {
		if(isEmpty()) {
			throw new RuntimeException("queue is empty :");
		}
		E item = head.item;
		head = head.next;
		size--;
		return item;
	}

	public E peek() {
        	if(isEmpty()) {
                        throw new RuntimeException("queue is empty :");
                }
		return head.item;
	}
	public int size() {
		return size;
	}

	public String toString() {
		String result = "size : " + size  + "\n"; 
		if(!isEmpty()) {
			Node current=head;
			while(current!= null) {
				result += " " + current.item;
				current = current.next;
			}	
		}
		return result;
	}

}
