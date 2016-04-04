package sort;
import java.util.Comparator;

public class InsertionSorter<E> extends AbstractSorter<E> {
	public InsertionSorter(E[] elements, Comparator comp) {
		super(elements, comp);
	}
	public void sort() {
		if(isEmpty()) return;
		for(int i = 1; i < elements.length; i++) {
			int j = i;
			E val = elements[j];
			while(j > 0 && comp.compare(elements[j-1] , val) > 0 )  {
				elements[j]=elements[j-1];
				j = j-1;
			}
			elements [j] = val;
		}
	}
	public String toString()  {
		String result =  "type : Insertion Sort\n";
		result += "best case : O(n) comparisons, O(1) swaps\n";
		result += "average case : quadratic O(n^2)\n";
		result += "worst case : quadratic O(n^2)\n";
		result += "wiki : https://en.wikipedia.org/wiki/Insertion_sort\n";
		result+="Worst case space complexity: О(n) total, O(1) auxiliaryi\n";
		return result;
	}

}


