import java.util.List;
import java.util.ArrayList;

public class ArrayListDemo {
	
	// list.add(n)    - inserts n at end of list
	// list.add(i, n) - inserts n at index i 
    // list.remove(i) - removes element at index i
	
	// list.get(i)    - returns element at index i
	// list.set(i, n) - sets index i equal to element n
	// list.size()    - returns the size of the list
	
	public static void main(String[] args) {
		// int[] list = new int[];
		List<Integer> list = new ArrayList<>();
		list.add(7);
		list.add(2);
		list.set(0, 10);     // arr[0] = 10
		System.out.println(list + ", size = " + list.size());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
