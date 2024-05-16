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
			if (target < nums[mid]) { // 타겟이 중간값보다 작은경우
				if (nums[end] < nums[mid] && target <= nums[end]) { 
                    // 뒤집힌경우(4 5 6 1 2 3) 가운데가 끝 포인터보다 더 큰경우 
                    // 타겟이 mid 기준으로 뒤쪽 어딘가 있는경우
					start = mid; // 기존의 이분탐색방법대로가 아닌 start를 중간지점으로
				} else {
					end = mid;
				}
			} else {
				if (nums[mid] < nums[start] && nums[start] <= target) { //뒤집힌경우 + 타겟이 mid 기준 앞쪽 어딘가 있는경우
					end = mid;//앞쪽에서 찾기
				} else {
					start = mid;//뒤쪽에서 찾기
				}
			}
			mid = (start + end) / 2;
		}
	}
}