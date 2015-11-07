public interface Queue<E> {
	public boolean isEmpty();
	public E dequeue();
	public void enqueue(E item);
	public int size();
	public boolean isFull();
	public E peek();
}
