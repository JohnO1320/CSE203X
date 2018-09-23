import java.util.Arrays;

public class ArraysDemo {
	public static void main(String[] args) {
		int[][] matrix = {{0, 1, 2},
				          {3, 4, 5},
				          {6, 8, 9}};
		
		for (int row = 0; row < matrix.length; row++) {
			System.out.println(Arrays.toString(matrix[row]));
		}
	}
}
