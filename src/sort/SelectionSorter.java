package sort;
import java.util.Comparator;

public class SelectionSorter<E> extends AbstractSorter<E> {

	public SelectionSorter(E[] elements, Comparator comp) {
		super(elements, comp);
	}
	public void sort() {
		for(int j=0; j < elements.length -1 ; j++) {
			int amin = j;
			for(int i=j+1; i<elements.length; i++ ) {
				if(comp.compare(elements[i] , elements[amin]) < 0 ) {
					amin = i;
				}
			}
			if(amin!=j) {
				E tmp = elements[j];
				elements[j] = elements[amin];
				elements[amin] = tmp;
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
