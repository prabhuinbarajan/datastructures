import java.util.Comparator;
public class UnorderedPriorityQueue<E> implements Queue<E> {
	int capacity;
	int size;
	E[] items;
	Comparator<E> comp;

	public UnorderedPriorityQueue(int capacity, Comparator<E> comp) {
		this.capacity = capacity;
		this.comp = comp;
		items = (E[] ) new Object[this.capacity];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty()  {
		return size==0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	public void enqueue(E item) {
		if(isFull()) {
			throw new RuntimeException ( "queue is full : " + size() + ": " + capacity);
		}
		items[size++] = item;	
	}

	public E peek() {
		if(isEmpty()) {
			throw new RuntimeException("queue is empty :" + size() + ": "  + capacity);
		}
		return items[0];
	}
	
	public E dequeue() {
		if(isEmpty()) {
                        throw new RuntimeException("queue is empty :" + size() + ": "  + capacity);
                }
		int max = 0;
		for(int i= 1 ; i<size; i++) {
			if(comp.compare(items[max], items[i]) <0)  {
				max = i;
				//System.out.println(items[i] + " : max - " + max);
			}	
		}
		E tmp  = items[size-1];
		items[size-1] =  items[max];
		items[max] = tmp;
		return items[--size];
	}

        public String toString() {
                String result = "queue size : " + size();
                if(!isEmpty()) {
                        for(int i = 0; i<size; i++ ) {
                                result += " " + items[i];
                        }
                }
                return result;
        }
}
