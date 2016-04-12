package sort;
import java.util.Comparator;

public class HeapSorter1<E> extends AbstractSorter<E> {
	int size;
	public HeapSorter1(E[] items, Comparator comp) {
		super(items, comp);
		size = items.length;
	}

	public void sort() {
		buildHeap();
		int N = size-1;
		while(N > 0 ) {
			swap(N--, 0);
			heapify(0,N);
		}
	}
	private void heapify(int index, int size){
		int left= index*2;
		int right=index*2+1;
		int largest = index;
		if(left <=size && comp.compare(elements[left], elements[largest]) >0) {
			largest = left;
		}
		if(right <=size && comp.compare(elements[right], elements[largest])>0) {
			largest = right;
		}
		if(largest != index) {
			swap(largest, index);
			heapify(largest, size);
		}
		print();


	}
	private void buildHeap() {
		for(int i=size/2; i>=0; i--) {
			heapify(i, size-1);
		}
	}


	public String toString() {
		String result = "type: HeapSorter\n";
		result += "characteristics : unstable, not easily parallelizable, \n";
		result+="best case :O ( nlogn)  \n";
		result+="avg case :O ( nlogn)  \n";
		result+="worst case :O ( nlogn)  \n";
		result+="worst case space complexity :O (n)  \n";
		result+="ref: \n";
		result+="ref:https://en.wikipedia.org/wiki/Heapsort \n";
		result+="ref:http://www.ee.ryerson.ca/~courses/coe428/sorting/heapsort.html\n";
		return result;

	}



}
