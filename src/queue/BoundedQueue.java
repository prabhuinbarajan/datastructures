
public class BoundedQueue<E> implements Queue<E> {
	int size;
	E[] items;
	int r;
	int f;
	public BoundedQueue(int size) {
		this.size = size;
		items  = (E[]) new Object[this.size];
	}


	public int size() {
		if(r > f) {
			return r-f;
		}
		return size - r+f;
	}
	public boolean isEmpty() {
		 return (r == f) ? true : false;
	}
	public boolean isFull() {
		int diff = r-f;
		return (diff == -1 || diff == size -1);
	}
	public void enqueue(E item) {
		if(isFull()) {
			throw new RuntimeException("the queue is full : " + size() + " r:" + r + " f:" + f);
		}
		items[r] = item;
		r = (r+1)%size;
	}
	public E dequeue() {
		if(isEmpty()) {
			throw new RuntimeException("the queue is empty :" + size() + " r:" + r + " f:" + f);
		}
		E item = items[f];
		items[f] = null;
		f=(f+1)% size;
		return item;
	}
	public E peek() {
                if(isEmpty()) {
                        throw new RuntimeException("the queue is empty :" + size() + " r:" + r + " f:" + f);
                }
		return items[f];
	}
	public String toString() {
                String result = "queue size : " + size();
		System.out.println(" f : " + f + " r: " + r + " size:" + size());
		if(!isEmpty()) {
	         	for(int i = f; i<r; ) {
        	        	result += " " + items[i];
				i=(i+1)%size;
                	}
                }
                return result;
        }

}
