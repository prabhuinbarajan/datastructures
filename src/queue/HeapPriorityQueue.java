
import java.util.Comparator;
public class HeapPriorityQueue<E> implements Queue<E> {
	int capacity;
	E[] items;
	int size;
	Comparator comp;
	public HeapPriorityQueue(int capacity, Comparator comp) {
		this.capacity= capacity+1;
		this.comp = comp;
		items = (E[]) new Object[this.capacity];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty () {
		return size ==0;
	}
	public boolean isFull() {
		return size==capacity;	
	} 
	
	public HeapPriorityQueue(E[] arr, Comparator comp) {
		this.capacity  = arr.length;
		this.comp = comp;
		this.items = (E[]) new Object[arr.length];
		for(int i=0; i<	arr.length; i++) {
			items[i+1] = arr[i];
			size++;	
		}
		for(int k=capacity/2; k>=1; k--) {
			sink(k);
		}
	}
	
	private void sink(int k) {
		while(2*k <= size) {
			int j = 2*k;
			if(j <size &&  comp.compare(items[j+1] , items[j]) > 0 ) {
				j++;
			}
			if( comp.compare(items[k], items[j]) > 0)  {
				break;
			}
			E tmp = items [k];
			items[k] = items [j];
			items[j] = tmp;	
			k=j;
		}
	}

	private void swim(int k) {
		//System.out.println("swim :" + k  + " items[k] " + items[k] +  ": items[k/2] :" + items[k/2] );
		while(k > 1 && comp.compare(items[k/2], items[k]) < 0) {
			E tmp = items[k/2];
		 	items[k/2] = items[k];
			items[k] = tmp;
			k=k/2;
		}
	}
	
	public void enqueue(E item) {
		if(isFull()) {
			throw new RuntimeException("queue is full " + size + ":" + capacity);
		}
		items[++size] = item;
		swim(size);
	} 

	public E dequeue() {
		if(isEmpty()) {
			throw new RuntimeException("queue is empty " + size + ":" + capacity);
		}
		E item = items[1];
		items[1] = items[size];
		items[size--] = null;
		sink(1);
		return item;
	}			
	
	public E peek() {
		if(isEmpty()) {
                        throw new RuntimeException("queue is empty " + size + ":" + capacity);
                }
		return items[1];
	}
        public String toString() {
                String result = "queue size : " + size();
                if(!isEmpty()) {
                        for(int i = 1; i<=size; i++ ) {
                                result += " " + items[i];
                        }
                }
                return result;
        }	

}
