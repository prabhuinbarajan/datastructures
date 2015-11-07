import java.util.Comparator;
import java.lang.reflect.Constructor;
import static java.lang.System.out;
import java.lang.reflect.Type;



public class SortClient{
	
	public static void main(String[] args) throws Exception{
		if(args.length <1 ) {
			System.out.println("Usage : java SortClient <SortImplementationClass>");
			System.exit(1);
		}
		String sortImplementationClass = args[0];
		Class sorterClass = Class.forName(sortImplementationClass);
	 	Constructor ctor = sorterClass.getDeclaredConstructor(Object[].class, java.util.Comparator.class);
		System.out.println(ctor);
	    	//ctor.setAccessible(true);
		Integer[] arr = {1, 5 , 3, 9, 2, 7, 8, 6};
		Comparator<Integer> comp = new Comparator<Integer>() {
      			public int compare(Integer d1, Integer d2) {
        			return d1.compareTo(d2);
      			}
    		};
		//Sorter<Integer> sorter= new InsertionSorter<>((Integer[])arr, comp);
		Sorter<Integer> sorter = (Sorter) ctor.newInstance((Integer[])arr, comp);
		System.out.println("-----------------------------------------------------");
		sorter.print();
		sorter.sort();
		sorter.print();
		System.out.println(sorter);
		System.out.println("-----------------------------------------------------");
	}
}
