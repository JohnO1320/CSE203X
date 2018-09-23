import java.util.ArrayList;
import java.util.List;

public class TestMyArrayList {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		MyArrayList list2 = new MyArrayList();
		System.out.println(list2);
		
		list1.add(5);
		
		list2.add(5);
		list2.add(6);
		list2.add(7);
		list2.add(1, 10);
		
		System.out.println(list1);
		System.out.println(list2);
	}
}
