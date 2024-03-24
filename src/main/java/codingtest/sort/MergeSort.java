package codingtest.sort;

import static codingtest.sort.PrintUtils.printArr;

public class MergeSort {

	static int[] sortedArray;

	public static void main(String[] args) {
		int[] arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		sortedArray = new int[arr.length];
		System.out.println("before");
		printArr(arr);

		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left == right) {
			return;
		}
		int mid = (left + right) / 2;

		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);

		merge(arr, left, mid, right);
	}

	public static void mergeSortBottomUp(int[] arr, int left, int right){
		// 1 - 2 - 4 - 8 ...
		for (int i = 1; i <= right; i+=i){
			for (int j = 0; j <= right - i; i +=(2*i)){
				int low = j;
				int mid = j + i - 1;
				int high = Math.min(j + (2*i) - 1, right);
				merge(arr, low, mid, high);
			}
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int idx = left;

		while (l <= mid && r <= right) {

			if (arr[l] <= arr[r]) {
				sortedArray[idx] = arr[l];
				idx++;
				l++;
			} else {
				sortedArray[idx] = arr[r];
				idx++;
				r++;
			}
		}
		if (l > mid) {
			while (r <= right) {
				sortedArray[idx] = arr[r];
				idx++;
				r++;
			}
		} else {
			while (l <= mid) {
				sortedArray[idx] = arr[l];
				idx++;
				l++;
			}
		}

		if (right + 1 - left >= 0)
			System.arraycopy(sortedArray, left, arr, left, right + 1 - left);

		printArr(arr);
	}


}
