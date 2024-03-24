package codingtest.sort;

import static codingtest.sort.PrintUtils.printArr;
import static codingtest.sort.PrintUtils.swap;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		printArr(arr);
		System.out.println("after");
		selectionSort(arr);
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, i, min);
		}
		printArr(arr);
	}


}
