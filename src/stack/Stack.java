package stack;
public interface Stack<E> {
	public void push(E item);
	public E pop();
	public E peek();
	public int size();
	public boolean isEmpty();
	public void reverse();
}
