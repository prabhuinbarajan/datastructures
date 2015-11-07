import java.util.Comparator;
import  java.lang.reflect.Array;
public class MergeSorter1<E> extends AbstractSorter<E> {
	E[] helpers;
	
	public MergeSorter1(E[] elements , Comparator comp) {
		super(elements, comp);
		helpers = (E[]) Array.newInstance(elements[0].getClass(), elements.length);
	}
	public void sort() {
		mergeSort(elements, 0 , elements.length -1);
	}
	public void mergeSort(E[] elements , int lo, int hi) {
		if(lo < hi) {
			int middle= (lo+hi)/2;
			mergeSort(elements,0, middle);
			mergeSort(elements , middle+1 , hi);
			merge(elements, lo, middle, hi);
		}
	}
	public void merge(E[] elements, int lo, int middle , int hi) {
		for ( int i=lo; i<=hi; i++) {
			helpers[i] = elements [i];
		}
		int i = lo;
		int j = middle + 1;
		int k = lo;
		while ( i<=middle && j <= hi) {
			if(comp.compare(helpers[i] , helpers[j]) <=0) {
				elements[k] = helpers[i++];
			}else {
				elements[k] = helpers[j++];
			}
			k++;
		}
		while( i<=middle) {
			elements[k++] = helpers [i++];
		}
	}

	public String toString() {
		String result = "type: MergeSorter \n";
		result+= "characteristics: comparison based, stable sort, divide and conquer\n";
		result+="best case: O(n log n)\n";
		result+="avg case: O(n log n)\n";
		result+="worst case: O(n logn) \n";
		result+="worst case space complexity: О(n) total, O(n) auxiliary\n";
		result+="ref:https://en.wikipedia.org/wiki/Merge_sort\n";
		return result;
	}
}
