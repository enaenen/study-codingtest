package codingtest.sort;

import static codingtest.sort.PrintUtils.printArr;
import static codingtest.sort.PrintUtils.swap;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println("before");
		printArr(arr);
		bubbleSort(arr);
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
		printArr(arr);
	}

}
