package tree;
import java.util.Comparator;

public class BST <E>{
	Comparator comp;
	private Node root;
	class Node<E> {
		E item;
		Node<E> left;
		Node<E> right;	
		Node (E item) {
			this.item = item;
		}
		boolean isBalanced() {
			return checkBalanced(this) != -1;
		}
		private int checkBalanced(Node<E> n) {
			if(n == null) return 0;

			int lefth = checkBalanced(n.left);
			if(lefth <0) return -1;
			int righth = checkBalanced(n.right);
			if(righth < 0 ) return -1;
			if(Math.abs(lefth - righth) >1 ) return -1;
			return 1+Math.max(lefth, righth);
		}
		public void preOrderTraverse() {
                        System.out.println(this);
                        if(left != null) left.preOrderTraverse();
                        if(right != null) right.preOrderTraverse();
                }

		public void postOrderTraverse() {
                        if(left != null) left.postOrderTraverse();
                        if(right != null) right.postOrderTraverse();
			System.out.println(this);
                }
		public void inOrderTraverse() {
                        if(left != null) left.inOrderTraverse();
                        System.out.println(this);
                        if(right != null) right.inOrderTraverse();
                }	
		public String toString() {
			String results =  item.toString() + " " ;
	                results += " l:" + ((left == null) ? " " : left.item.toString());
			results += " r:" + ((right == null) ? " " : right.item.toString());
			return results;
		}

	}
	public BST ( Comparator comp )  {
		this.comp = comp;
	}
	public Node<E> put(Node current , E item) {
		Node<E> in = new Node<E>(item);
		if(current == null) {
			return in;
		}
		int result = comp.compare(item, current.item);
		
		if(result <0) {
			current.left = put(current.left, item);
		}else if (result > 0) {
			current.right = put(current.right, item);
		}
		return current;
	}
	public Node deleteMin(Node current) {
		if(current.left == null) {
			return current.right;
		}
		current.left = deleteMin(current.left);
		return current;
	}	
	public boolean isBST(Node <E> current , E min , E max) {
		if(current == null) return true;
		System.out.println("current : " + current.item + " min "+ min + " max " + max);
		if(min != null && comp.compare(current.item, min) <= 0) return false;
		if(max!= null && comp.compare(current.item, max) >= 0) return false;
		return isBST(current.left, min,current.item) && isBST(current.right, current.item, max);
	}
	public static void main(String[] args) {
		 Comparator<Integer> comp = new Comparator<Integer>() {
                        public int compare(Integer d1, Integer d2) {
                                return d1.compareTo(d2);
                        }
                };
		BST<Integer> st = new BST<Integer>(comp);
		//Integer[] arr = {8, 4, 12, 5, 10, 9, 11, 3, 0, 7,2 , 6, 14};
		Integer[] arr = {8, 4, 12, 5, 3, 10, 14,11 , 9, 7, 2};
		for (int i = 0; i<arr.length; i++) {
			 st.root  = st.put(st.root, arr[i]);
		}
		System.out.println(st.root);
		System.out.println("IS BST:" + st.isBST(st.root, null, null));
		System.out.println("is balanced : " + st.root.isBalanced());
		System.out.println("Pre order traverse");
		st.root.preOrderTraverse();
		System.out.println("Post order traverse");
		st.root.postOrderTraverse();
                System.out.println("in order traverse");
                st.root.inOrderTraverse();


	}
	
}
