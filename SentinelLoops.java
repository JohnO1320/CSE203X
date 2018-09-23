
public class SentinelLoops {
	public static void main(String[] args) {
		
		// Fence Post Problem
		
		// |---|---|---|---| -> 5 posts
		fencePost(10);	
	}
	
	public static void fencePost(int n) {
		String fence = "|";
		int i = 1;
		while (i < n) {
			fence += "---|";
			i++;
		}
		System.out.println(fence);
	}
	
	
}
