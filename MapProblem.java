import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapProblem {
	public static void main(String[] args) {
		String s = "Apple apple dog blue Blue blue Cat";
		String[] words = s.split(" ");
		System.out.println(Arrays.toString(words));
		// create a count for every word in s, ignoring case
		// returns the string that occurs the most
		
		String result = modeString(words);
		System.out.println(result);
	}
	
	public static String modeString(String[] words) {
		Map<String, Integer> counts = new HashMap<>();
		String mode = null;
		for (String word : words) {
			word = word.toLowerCase();
			if (!counts.containsKey(word)) {
				counts.put(word, 0);
			}
			// increase the count of word by 1
			int count = counts.get(word) + 1;
			counts.put(word, count);
			
			if (mode == null || count > counts.get(mode)) {
				mode = word;
			}
		}
		return mode;
	}
}
