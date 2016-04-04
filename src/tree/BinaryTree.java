package tree;
import java.util.Queue;
import java.util.LinkedList;
   	class Node <E> {

                E item;
                Node<E> left;
                Node<E> right;
                Node<E> parent;
                Node (E item) {
                        this.item = item;
                }
		public int depth() {
			int depth = 0;
			Node u = this;
			do{
				u = u.parent;
				depth++;
			}while(u!=null);
			return depth-1;		
		}
		public int height() {
			int height = 0;
			int childleftheight = (left == null) ? 0 : left.height();
			int childrightheight = (right == null) ? 0 : right.height();
			height =  1+ Math.max(childleftheight, childrightheight);	
			return height;

		}
		public void dfTraverse() {
			System.out.println("item" + item);
			if( left!= null ) {
				left.dfTraverse();
			}
			if(right != null) {
				right.dfTraverse();
			}
		}
		public void bfTraverse() {
			Queue<Node<E>> q = new LinkedList<Node<E>>();
			q.add(this);
			while(!q.isEmpty()) {
				Node u = q.remove();
				System.out.println("item :" + u.item);
				if(u.left!=null) {q.add(u.left);}
				if(u.right!= null) { q.add(u.right); }
			}
		}
		public void preOrderTraverse() {
			System.out.println(this);
			if(left != null) left.preOrderTraverse();
			if(right != null) right.preOrderTraverse();
		}	
		
		public String toString() {
			return item.toString();
		}

        }


public class BinaryTree{


	public static void main(String[] args ) {
		Node<Integer> r = new Node<Integer>(3);
		Node<Integer> l = new Node<Integer>(4);
		Node<Integer> ri = new Node<Integer>(5);
		Node<Integer> ll = new Node<Integer>(6);
		Node<Integer> lri = new Node<Integer>(7);
		r.left = l;
		r.right = ri;
		l.parent = ri.parent = r;
		l.left = ll;
		l.right=lri;
		lri.parent = ll.parent = l;
		System.out.println( "depth : lri " +  lri.depth() + ":" + l.right + ":" + l.left);		
		System.out.println(" depth : r " +  r.depth());		
		System.out.println(" height : r " + r.height());		
		r.dfTraverse();			
		System.out.println("breadth first");
		r.bfTraverse();
		System.out.println("pre order traversal");
		r.preOrderTraverse();
		

	}



}
