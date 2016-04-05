package tree;
import java.util.Random;
import java.util.LinkedList;

class TNode<E extends Comparable<?>> {
   E value;
   TNode<E> left;
   TNode<E> right;
   public TNode(E val) {
	this.value = val;
   }
   public String toString() {
	return  value.toString();
   }
}



public class BinaryTree2  {
	private static Random rand = new Random();
	public static TNode<Integer> getSampleBinaryTree(int depth , int range) {
		if(depth == 0) return null;
		TNode<Integer> root = new TNode<Integer>(rand.nextInt(range));
		root.left = getSampleBinaryTree(depth-1, range);
		root.right = getSampleBinaryTree(depth-1, range);	
	 	return root;	
	}
	public static void dfWithoutRecursion(TNode<Integer> node) {
		LinkedList<TNode<Integer>> list = new LinkedList<TNode<Integer>>();	
		
		TNode<Integer> current = node;
		while(!list.isEmpty() || current !=null) {
			if(current != null) {
				list.push(current);
				current = current.left;
			}else {
				current=list.pop();
				System.out.println(current + " ");
				current=current.right;
			}	
		}
	}
	public static void main(String[] args) {
		TNode<Integer> btree = getSampleBinaryTree(5, 50);
		BTreePrinter.printNode(btree);
		dfWithoutRecursion(btree);		
	}

}
