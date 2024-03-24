package codingtest.sort;

interface PrintUtils {
	static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	static void swap(int[] arr, int i, int min) {
		int tmp = arr[i];
		arr[i] = arr[min];
		arr[min] = tmp;
	}

}
