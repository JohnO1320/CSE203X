
public class MyArrayList {
	// create your own ArrayList (for ints)
	
	// you should have only two fields seen below
	
	// you should have a single constructor that
	// creates an empty MyArrayList
	
	// implement the following methods:
	//     void add(int n)
	//     int get(int index)
	//     int size()
	//     boolean isEmpty()
	//     String toString()
	
	//     add(int index, int n)
	//     remove(int index)
	
    private int[] array;
	private int size;
	
	public MyArrayList() {
		array = new int[10];
		size = 0;
	}
	
	public void add(int n) {
		if (size == array.length) {
			resize();
		}
		array[size] = n;
		size++;
	}
	
	public void add(int index, int n) {
		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}
		array[index] = n;
		size++;		
	}
	
	public void remove(int index) {
		for (int i = index; i < size; i++) {
			array[i] = array[i + 1];
		}
		size--;
	}
	
	public int get(int index) {
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
		return array[index];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		if (size == 0) return "[]";
		String result = "[";
		result += array[0];
		for (int i = 1; i < size; i++) {
			result += ", " + array[i];
		}
		return result + "]";
	}
	
	private void resize() {
		int[] newArray = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}
}
