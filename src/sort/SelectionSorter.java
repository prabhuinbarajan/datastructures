package sort;
import java.util.Comparator;

public class SelectionSorter<E> extends AbstractSorter<E> {

	public SelectionSorter(E[] elements, Comparator comp) {
		super(elements, comp);
	}
	public void sort() {
		for(int i=0; i < elements.length -1 ; i++) {
			int amin = i;
			for(int j=i+1; j<elements.length; j++ ) {
				if(comp.compare(elements[j] , elements[amin]) < 0 ) {
					amin = j;
				}
			}
			if(amin!=i) {
				swap(i, amin);
			}
		}
	}
	public String toString() {
		String result="type: SelectionSorter (j=0;n-1, i=j+1;n)\n";
		result+="characteristics: in-place, unstable, comparison sort\n";
		result+="best case: O(n^2), comparison, O(1) swaps\n";
		result+="worst case: O(n^2) comparison, O(n) swaps \n";
		result+="avg case: O(n^2) comparison, O(n) swaps \n";
		result+="worst case space complexity: O(n)total, O(1) auxiliary\n";
		result+="ref:https://en.wikipedia.org/wiki/Selection_sort\n";
		return result;
	}

}
