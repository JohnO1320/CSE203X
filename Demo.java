import java.util.*;

public class Demo {
	public static void main(String[] args) {
		Random r = new Random();
		int[] randNums = new int[100];
		for (int i = 0; i < randNums.length; i++) {
			randNums[i] = r.nextInt(10);
		}
		System.out.println(Arrays.toString(randNums));
		
		Map<Integer, Integer> counts = new HashMap<>();
		for (int n : randNums) {
			if (!counts.containsKey(n)) {
				counts.put(n, 0);
			}
			counts.put(n, counts.get(n) + 1);
		}
		System.out.println(counts);
		
		// iterate over maps
		int mode = -1;
		for (int key : counts.keySet()) {
			if (mode == -1 || counts.get(key) > counts.get(mode)) {
				mode = key;
			}
		}
		System.out.println(mode + " = " + counts.get(mode));
		
		// iterate over a map using an iterator
		Iterator<Integer> itr = counts.keySet().iterator();
		int mode1 = itr.next();
		while (itr.hasNext()) {
			int key = itr.next();
			if (counts.get(key) > counts.get(mode1)) {
				mode1 = key;
			}
		}
		System.out.println(mode1 + " = " + counts.get(mode1));
	}	
}