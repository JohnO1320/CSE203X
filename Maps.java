import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Maps {

	public static void main(String[] args) {
		// map - dictionary
		
		// sets - set of unique values
		// maps - set of unique of unique keys -> values
		// K -> V
		// words -> definitions
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		map.put(1, 3);
		map.put(2, 3);
		map.put(4, 5);
		System.out.println(map);
		
		System.out.println(map.keySet());
		

	}

}
