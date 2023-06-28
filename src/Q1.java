import java.util.Scanner;
import java.util.Arrays;
public class Q1 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter the number of elements in the array");
		
		int size = reader.nextInt();
		int[] array = new int [size];
		
		System.out.println("Enter the " + size + " elements of the array: ");
		for (int i = 0; i < size ; i++) {
			array[i] = reader.nextInt();
		}
		
		Arrays.sort(array);
		
		System.out.println("This is what you entered after being sorted");
		for (int num : array ) {
			System.out.print(num + " ");
		}
		
		System.out.println("\nEnter an interger as the search key ");
		int key = reader.nextInt();
		
		long startTimeLin = System.nanoTime();
		int linIndex = linearSearch(array, key);
		long endTimeLin = System.nanoTime();
		
		// finding the time for linear 
		long totalTimeLin = endTimeLin - startTimeLin;
		
		long startTimeInterp = System.nanoTime();
		int interpIndex = interpSearch(array, key);
		long endTimeInterp = System.nanoTime();
		
		// finding the time for interp
		long totalTimeInterp = endTimeInterp - startTimeInterp;
		
		// which one is faster
		if (linIndex >= 0) {
			System.out.println("Using linear search: ");
			System.out.println("Search key FOUND at Index " + linIndex);
		}
		else {
			System.out.println("Search key NOT FOUND using linear search");
		}
		
		if (interpIndex >= 0) {
			System.out.println("Using interpolation search: ");
			System.out.println("Search key FOUND at Index " + interpIndex );
		}
		else {
			System.out.println("Search key NOT FOUND using interpolation search");
		}
		
		System.out.println("Runtime for the linear search is " + totalTimeLin + " nanoseconds");
		System.out.println("Runtime for the interpolation search is " + totalTimeInterp + " nanoseconds");
		
		if(totalTimeInterp < totalTimeLin) {
			System.out.print("Interpolative search is faster than the linear search because of the reduced number of comparisons. ");
		}
		else {
			System.out.print("Linear search is faster than the interpolative search because interpolative must be sorted first ");
		}
		
		System.out.println("\nQuestion 3");
		long startTimeLin2 = System.nanoTime();
		int linIndex2 = linearSearchV2(array, key);
		long endTimeLin2 = System.nanoTime();
		long totalTimeLin2 = endTimeLin2 - startTimeLin2;
		System.out.println("Runtime for linear search V2 search is " + totalTimeLin2 + " nanoseconds");
		
		// linear time comparison
//		long timeDiff = Math.abs((totalTimeLin - totalTimeLin2))/(totalTimeLin) * 100;
//		long timeDiff = (Math.abs(totalTimeLin2 - totalTimeLin)/totalTimeLin)*100000;
		float timeDiff = Math.abs((float)(totalTimeLin2 - totalTimeLin))/(float)(totalTimeLin) * 100;
		System.out.println(timeDiff + "%");
		
		reader.close();
	}
	
	static int linearSearch(int[] array, int key) {
		int found = -1;
		for (int i = 0; i < array.length; i ++) {			
			if (array[i] == key) {
				found = i; 
			}
		}
		return found;
	}
	
	static int linearSearchV2(int[] array, int key) {
		for (int i = 0; i < array.length; i ++) {			
			if (array[i] == key) {
				return i; 
			}
		}
		return -1;
	}
	
	static int interpSearch(int[] array, int key) {
		Arrays.sort(array);
		int low = 0;
		int mid, pos;
		int high = array.length-1;
		while(low <= high) {
			pos = (key - array[low]) / (array[high] - array[low]);
			mid = low + ((high - low) * pos);
			if (key < array[mid]) {
				high = mid - 1;
			}
			else if(key > array[mid]) {
				low = mid + 1;
			}
			else 
				return mid;
		}
		return -1;
	}

}
