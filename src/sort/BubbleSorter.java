package sort;
import java.util.Comparator;
public class BubbleSorter <E> extends AbstractSorter<E> {

	public BubbleSorter(E[] elements, Comparator comp) {
		super (elements, comp);
	}
	public void sort() {
		for(int i=0; i< elements.length; i++) {
			for(int j=1; j < elements.length -i; j++) {
				if(comp.compare(elements[j-1], elements[j]) > 0) {
					E elem = elements[j-1];
					elements[j-1] = elements[j];
					elements[j] = elem;
				}
			}
			print();
		}

	}
	public String toString() {
		String result="type : Bubble Sorter i=0-arr.length , j=1 - (arr.length-i) \n";
		result += "best case : O(n) comparisons, O(1) swaps in a presorted array\n";
		result += "worst case : O(n^2)\n";
		result += "avg case : O(n^2)\n";
		result += "space complexity : O(1)\n";
		result += "ref: https://en.wikipedia.org/wiki/Bubble_sort\n";
		result += "ref: http://stackoverflow.com/questions/16088994/sorting-an-array-of-int-using-bubblesort\n";
		return result;
	}



}
