import java.util.Comparator;

public class QuickSorter<E> extends AbstractSorter<E> {
	public QuickSorter(E[] elements, Comparator comp) {
		super(elements, comp);
	}
	public void sort() {
		quickSort(elements, 0 , elements.length -1);
	}
	private int partition( E[] elements, int lo , int hi) {
		int i = lo;
		int j = hi;
		E pivot = elements[ (i+j)/2];
		while( i <= j ) {
			while(comp.compare(elements[i] , pivot) < 0) {
				i++;
			}
			while(comp.compare(elements[j], pivot) > 0) {
				j--;
			}
			if( i <= j) {
				E tmp = elements[i];
				elements[i] = elements[j];
				elements[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	
	}
	private void quickSort(E[] elements, int lo, int hi){
		int index= partition(elements, lo , hi);
		if(lo < index -1) {
			quickSort(elements, lo, index -1);
		}
		if(index < hi) {
			quickSort(elements, index, hi);
		}
	}	


	public String toString() {
		String result= "type: QuickSorter\n";
		result+= "characteristics: in place, comparison , unstable, divide and conquer \n";
		result+= "best case: O(n log n) simple partition, O(n) three way partition, equal key \n";
		result+= "worst case: O(n^2)\n";
		result+= "avg case: O(n log n) \n";
		result+="worst case space complexity : O(n) naive , O(log n) auxillary\n";
		result+="ref: https://en.wikipedia.org/wiki/Quicksort#Parallelization\n";
		result+="ref: http://www.algolist.net/Algorithms/Sorting/Quicksort\n";
		return result;
	}
		


}
