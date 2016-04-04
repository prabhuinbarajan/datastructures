package tree;
import java.util.Comparator;

public class  RBBST<E> {

	private static boolean RED = true;
	private static boolean BLACK = !RED;
	private Comparator comp;	
	private Node<E> root;

	private class Node<E> {
		E item;
		boolean color;
		Node<E> left, right, parent;
		Node(E item) {
			this.item = item;
		}
		Node (E item , boolean color) {
			this(item);
			this.color = color;
		}

		public String toString(){
			return item.toString();
		}
		
	}

	RBBST(Comparator comp) {
		this.comp = comp;
	}
	
	public void put(E item) {
		root = put(root, item);
	}
	
	public Node<E> put(Node<E> current, E item) {
		Node<E> newNode = new Node<E>(item, RED);
		if(current == null) {
			newNode.color = BLACK;
			return newNode;
		}
		int results = comp.compare(current.item, newNode.item);
		if(results > 0) {
			current.left = put(current.left,item);
		}
		if (results < 0) {
			current.right = put(current.right, item);
		} 
		return  balance(current);
	}

	private Node<E> balance(Node<E> h) {
		if(isRed(h.right)) {
			h = rotateLeft(h);
		}
		if(isRed(h.left) && isRed(h.left.left) ) {
			h = rotateRight(h);
		}
		if(isRed(h.right) && isRed(h.left)) {
			flipColors(h);
		}

		return h;
	}

	private Node<E> rotateLeft(Node <E> h) {
		Node x = h.left;
		h.right = x.left;
		x.left = h;		
		x.color = h.color;
		h.color = RED;
		return x;
	}
	private Node<E> rotateRight(Node<E> h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	public void flipColors (Node<E> h) {
		h.color = !h.color;
		h.right.color = !h.right.color;
		h.left.color = !h.left.color;
	}
	public boolean isRed(Node<E> node) {
		if(node == null) {
			return false;
		}
		return node.color;
	}
	public boolean isBalanced() {
		int black = 0;
		Node current = root;

		while(current!= null ) {
			if(current.color == BLACK) {
				black++;
			}
			current = current.left;
		}
		return isBalanced(root, black);
	}

	private boolean isBalanced(Node<E> current , int black) {
		if(current == null) { return black == 0; }
		if(!isRed(current)) { black--; }
		return isBalanced(current.left, black) && isBalanced(current.right , black);	
	}
	
	//http://algs4.cs.princeton.edu/33balanced/RedBlackBST.java.html

}

