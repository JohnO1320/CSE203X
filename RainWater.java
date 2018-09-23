import java.util.Arrays;

public class RainWater {

	public static void main(String[] args) {
		int[] b = {5, 4, 2, 3, 4, 6};
		
		int[] LR = getLeftToRight(b);
		System.out.println(Arrays.toString(LR));
		int[] RL = getRightToLeft(b);
		System.out.println(Arrays.toString(RL)); 
		
		int water = 0;
		for (int i = 0; i < b.length; i++) {
			water += Math.min(LR[i], RL[i]) - b[i];
		}
		System.out.println("Water = " + water);

	}
	 
	public static int[] getLeftToRight(int[] b) {
		int[] LR = new int[b.length];
		int max = b[0];
		for (int i = 0; i < LR.length; i++) {
			max = Math.max(max, b[i]); // if (b[i] > max) max = b[i];
			LR[i] = max;
		}
		return LR;
	}
	
	public static int[] getRightToLeft(int[] b) {
		int[] RL = new int[b.length];
		int max = b[b.length - 1];
		for (int i = b.length - 1; i >= 0; i--) {
			max = Math.max(max, b[i]); // if (b[i] > max) max = b[i];
			RL[i] = max;
		}
		return RL;
	}

}
