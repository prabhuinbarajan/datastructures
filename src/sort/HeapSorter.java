package sort;
import java.util.Comparator;

public class HeapSorter <E> extends AbstractSorter<E> {
	int size;
	public HeapSorter(E[] items, Comparator comp) {
		super(items, comp);
		size = items.length;
	}

	public void sort() {
		size = elements.length;
		if(size <2 ) {
			return;
		}
		for(int k=size/2; k>=0; k--) {
			sink(k);
		}
		print();
		size = size-1;
		while(size>0){
			swap(0, size);
			sink(0);			
			size--;
		}
	}


	private void sink(int k) {
		if(size <2) {
			return;
		}
		while (2*k <= size-1 ) {
			int j = 2*k;
			if(j<size-1 && comp.compare(elements[j+1] , elements [j]) > 0) {
				j++;
			}
			if(comp.compare(elements[k] , elements[j]) > 0) {
				break;
			}
			swap(k, j);
			k=j;	
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
		return result;

	}



}
