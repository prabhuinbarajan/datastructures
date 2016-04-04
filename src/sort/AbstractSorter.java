package sort;
import java.util.Comparator;

public abstract class AbstractSorter <E > implements Sorter<E>{
	E[] elements;
	Comparator comp;
	public AbstractSorter(E[] arr , Comparator comp) {
		this.elements = arr;
		this.comp = comp;
	}
	public abstract void sort() ;
	public boolean isEmpty() {
		return (elements == null || elements.length == 0 ) ;
	}
	public void print() {
		if(isEmpty()) return;
		for(int i=0; i< elements.length; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println("");
	}
	protected void swap(int i , int j ) {
		E tmp = elements[i];
		elements[i] = elements[j];
		elements[j] = tmp;
	}
}
