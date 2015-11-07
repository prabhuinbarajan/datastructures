
public class DoubleLinkedList<E> {
	class Node {
		E item;
		Node prev;
		Node next;
		public Node(E item) {
			this.item = item;
		}

		public  boolean equals(Object o) {
			if(o == null) {
				return false;
			}
			if(o instanceof DoubleLinkedList.Node) {
				return equals(((Node)o).item);
			}
			return o.equals(item);
		}
		public String toString() {
			return (item != null) ?item.toString():"null";
		}
	}

	Node head;
	Node tail;	
	public DoubleLinkedList() {
	}
	
	public void add(E item) {
		Node node = new Node(item);
		if(head == null) {
			head = tail = node;
		}else {
			tail.next= node;
			node.prev = tail;
			tail = node;
		}
	}
	
	private Node getNode(Node n) {
		if(isEmpty()) {
			return null;
		}
		if(n == null) {
			return null;
		}
		Node current = head;
		while(current != null) {
			if(current.equals(n)) {
				return current;
			}
			current = current.next;
		}
		return null;

	}
	private boolean isMember(Node n) {
		Node rnode = getNode(n);
		return (rnode != null);
	}

	public boolean addAfterNode(Node n, E item) {
		if(!isMember(n)) {
			return false;
		}
		Node newnode = new Node(item);
		newnode.prev = n;
		newnode.next = n.next;
		if(n.next != null) {
			n.next.prev = newnode;
		}
		if(n == tail ) {
			tail = newnode;
		} 
		n.next = newnode;
		return true;
	}		
		
	public boolean addBeforeNode(Node n , E item) {
		if(!isMember(n)) {
			return false;
		}
		Node newnode = new Node(item);
		newnode.next = n;
		newnode.prev = n.prev;
		if(n.prev != null) {
			n.prev.next = newnode;
		}
		if(head == n) {
			head = newnode;
		}
		n.prev = newnode;
		return true;
	}
	public boolean isEmpty(){
		return head == null;
	}

	private void print() {
		if(isEmpty()) {
			System.out.println("list is empty");
		}
		Node current  = head;
		System.out.print("start->");
		while(current != null) {
			System.out.print(current.item + "->");
			current = current.next;
		}
		System.out.println("finish");
	}
	public Node getHead(){
		return head;
	}
	public Node getTail() {
		return tail;
	}	
	
	public void reverse() {
		if(isEmpty()) {
			return;
		}
		Node current = tail;
		Node prev = null;
		while(current != null) {
			Node tmp = current.prev;
			current.prev = current.next; 
			current.next = tmp;
			current = tmp;
		}
		Node tmp = head;
		head = tail;
		tail = tmp;
	}
		
	public boolean isPalindrome(Node start, Node end) {
		if(start == end) {
			return true;
		}
		boolean palindrome = isPalindrome(start.next, end.prev);
		if(!palindrome) {
			return false;
		}
		if(!start.equals(end)) {
			return false;	
		}
		return true;

	}		
		

	public static void main(String[] args) {
                DoubleLinkedList <Integer> ll = new DoubleLinkedList<Integer>();
                System.out.println("printing empty linked list");
                ll.print();
                ll.add(1);
                ll.add(2);
                ll.add(3);
                ll.add(3);
                ll.add(4);
                ll.add(2);
                ll.add(1);
                System.out.println("printing constructed linked list");
                ll.print();
                ll.reverse();
                System.out.println("printing reversed linked list");
                ll.print();
                ll.reverse();
                System.out.println("printing re-reversed linked list");
                ll.print();
		DoubleLinkedList<Integer>.Node node1 = ll.new Node(3);
                DoubleLinkedList.Node node = ll.getNode(node1);
                DoubleLinkedList.Node tail = ll.getTail();
                DoubleLinkedList.Node head = ll.getHead();
		boolean isPalindrome = ll.isPalindrome(head, tail);
		System.out.println("isPalindrome:" + isPalindrome);
                //tail.next = node;
                //LinkedList.Node cycle = ll.getCircularNode();
                //System.out.println("circular node " + cycle );
                //System.out.println("ref: https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare");
        }

}
