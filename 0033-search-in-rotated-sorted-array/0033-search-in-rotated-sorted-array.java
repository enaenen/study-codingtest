class Solution {
    public int search(int[] nums, int target) {

		int start = 0;
		int end = nums.length - 1;
		int mid = nums.length / 2;

		while (true) {
			if (start == mid) {// 2개밖에 안남은 경우
				if (nums[start] != target && nums[end] != target) {
					return -1;
				}
				if (nums[start] == target) {
					return start;
				} else {
					return end;
				}
			}
			if (nums[start] == target) {
				return start;
			}
			if (target < nums[mid]) {
				if (nums[end] < nums[mid] && target <= nums[end]) {
					start = mid;
				} else {
					end = mid;
				}
			} else {
				if (nums[mid] < nums[start] && nums[start] < target) {
					end = mid;
				} else {
					start = mid;
				}
			}
			mid = (start + end) / 2;
		}
	}
}