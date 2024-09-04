class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int lt = 0;
        int length = arr.length;
        int rt = length - 1;

        // 앞이 더 큰 지점 찾기 lt
        for (lt = 0; lt < length - 1; lt++) 
            if (arr[lt] > arr[lt + 1]) 
                break;

        // 끝까지 갔다면 없다는 것
        if (lt == rt) return 0;

        // rt 정렬이 안맞는 지점 찾기
        for (; 0 < rt ; rt--){
            if (arr[rt] < arr[rt - 1])
                break;
        }

        int min = Math.min(length - lt - 1, rt);
        for (; 0 <= lt; lt--){
            for (int i = rt; i < length; i++){
                if (arr[lt] > arr[i]) continue;
                min = Math.min(min, i - lt - 1);
                break;
            }
        }
        return min;
    }
}