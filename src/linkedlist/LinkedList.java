
public class LinkedList<E> {
	class Node {
		E item;
		Node  next;
		Node(E item) {
			this.item = item;
		}
		public boolean equals(Object o) {
			if(o == null) {
				return false;
			}
			if(o instanceof LinkedList.Node) {
				Node compare= (Node)o;
				return equals(compare.item);
			}
			if(this.item != null && this.item.equals(o)) {
                        	return true;
                        }
			return false;
				
		}
		public String toString()  {
			return item.toString();
		}
	}
	
	Node head;
	Node tail;

	public LinkedList () {

	}

	public void addFirst(E item) {
		Node node = new Node(item);
		if(head == null) {
			head = tail = node;
		}else {
			node.next  = head;
			head = node;
		}
	}
	
	public void addLast(E item) {
		Node node = new Node(item);
		if(head == null) {
			head = tail = node;
		}else {
			tail.next= node;
			tail = node;
		}
	}
	
	public void add(E item) {
		addLast(item);
	}

	public void reverse() {
		if(head == null) {
			return;
		}
		Node current =  head;
		Node phead = head;
		Node prev = null;
		while(current != null) {
			Node tmp = prev;
			prev = current;
			current = current.next;
			prev.next = tmp;		
		}
		head = prev;
		tail = phead;
	}
	public boolean isEmpty() {
		return head == null;
	}

	public Node getNode(E item) {
		if(isEmpty()) {
			return null;
		}
		Node current = head;
		while(current != null) {
			if(current.equals(item)) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	public Node getHead(){
		return head;
	}

	public Node getTail() {
		return tail;
	}
	public void print() {
		if(isEmpty()) {
			System.out.println("list empty");
		}
		Node current = head;
		System.out.print("start->");
		while(current != null) {
			System.out.print(current.item  + "->");
			current=current.next;
		}
		System.out.println("end");
	}	
	public Node getCircularNode() {
		if(isEmpty()) {
			return null;
		}
		Node rabbit,tortoise;
		rabbit = tortoise = head;
		do {
			if(rabbit.next==null) {
				return null;
			}
			rabbit = rabbit.next.next;
			tortoise = tortoise.next;
		}while(rabbit != tortoise);
	
		if(rabbit == null) {
			return null;
		}
		int mu = 0;
		tortoise= head;
		while(tortoise != rabbit) {
			tortoise= tortoise.next;
			rabbit = rabbit.next;
			mu++;
		}
		System.out.println("cycle detected " + mu + " nodes from head");
		return tortoise;
	}
	
	public Node compstart;

	public boolean isPalindrome() {
		compstart = head;
		if(isEmpty()) {
			return false;
		}
		return isPalindrome(head);
	}
	private boolean isPalindrome(Node right) {
		if(right == null) {
			return true;
		}
		boolean palindrome = isPalindrome(right.next);
		if(!palindrome) {
			return false;
		}
		palindrome = compstart.equals(right);
		compstart=compstart.next;
		return palindrome;
	}
		
	
	public static void main(String[] args) {
		LinkedList <Integer> ll = new LinkedList<Integer>();
		System.out.println("printing empty linked list");
		ll.print();
		ll.addFirst(1);
		ll.add(2);
		ll.add(3);
		ll.addLast(8);
		ll.add(15);
		ll.add(7);
		//ll.add(3);
		//ll.add(2);
		//ll.add(1);
		System.out.println("printing constructed linked list");
		ll.print();
		ll.reverse();
		System.out.println("printing reversed linked list");
		ll.print();
		ll.reverse();
		System.out.println("printing re-reversed linked list");
		ll.print();
		boolean palindrome = ll.isPalindrome();
		System.out.println("isPalindrome : " + palindrome);
		LinkedList.Node node = ll.getNode(3);
		LinkedList.Node tail = ll.getTail();
		tail.next = node;
		LinkedList.Node cycle = ll.getCircularNode();
		System.out.println("circular node " + cycle );
		System.out.println("ref: https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare");
	}		


}

