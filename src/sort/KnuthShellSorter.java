package sort;
import java.util.Comparator;


public class KnuthShellSorter <E> extends AbstractSorter <E> {
	int hcap = 1;
	public KnuthShellSorter(E[] elements, Comparator comp) {
		super (elements, comp);
	}

	public void sort() {
		int h = 1;
		while( h < elements.length/3) {
			h=h*3+1;
		}
		hcap = h;
		while(h>0) {
			
			System.out.println("h value in iteration " + h);
			for(int i=h; i < elements.length; i++) {
				for(int j=i; j >=h  && comp.compare(elements[j-h], elements[j]) > 0; j-=h) {
					E val=elements[j];
					elements[j] = elements[j-h];
					elements[j-h] = val;
				}	
			}
			h=h/3;
		}
		System.out.println("h value in iteration " + h);
	
	}
	public String toString() {
		String result = "Type : KnuthShellSort - Gap Sequence 3h+1\n";
		result += "max h value for this array length " + hcap + "\n";
		result+="best case : O(n log2 n) comparisons,  O(1) swaps \n";
		result+="avg case: quadratic O(n^3/2) \n";
		result+="worst case: quadratic O(n^2) \n";
		result+="ref : http://stackoverflow.com/questions/4833423/shell-sort-java-example\n";
		result+="ref : http://interactivepython.org/runestone/static/pythonds/SortSearch/TheShellSort.html\n";
		result+="ref : https://dzone.com/articles/algorithm-week-shell-sort\n";
		result+="ref :  an adaptive sorting algorithm in that it executes faster when the input is partially sorted.\n";
		result+="Worst case space complexity: О(n) total, O(1) auxiliaryi\n";
		return result;
	}
}
