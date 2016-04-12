package sort;
import java.util.Comparator;

public class QuickSorter1<E> extends AbstractSorter<E> {
	public QuickSorter1(E[] elements, Comparator comp) {
		super(elements, comp);
	}
	public void sort() {
		quickSort(elements, 0 , elements.length -1);
	}
	private int partition( E[] elements, int p , int r) {
		int q = p;
		int j = q;
		while(j < r) {
			if(comp.compare(elements[j], elements[r])<0 ) {
				swap(j,q);
				q++;
			}
			j++;
		}
		swap(q,r);
		return q;
	
	}
	private void quickSort(E[] elements, int lo, int hi){
		if(lo<hi){
			int pivot= partition(elements, lo , hi);
			quickSort(elements, lo, pivot -1);
			quickSort(elements, pivot+1, hi);
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
		result+="ref: https://www.khanacademy.org/computing/computer-science/algorithms/quick-sort/a/analysis-of-quicksort\n";
		return result;
	}
		


}
