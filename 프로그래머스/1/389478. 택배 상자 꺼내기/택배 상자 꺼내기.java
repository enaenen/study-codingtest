class Solution {
    public static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int solution(int n, int w, int num) {
        int answer = 1;
        int h = n / w + 1;
        int[][] map = new int[h][w];
        // 상자 만들기
        boolean isRight = false;
        int boxIdx = 1;
        
        int targetHeight = 0;
        int targetWidth = 0;
        
        for (int i = 0; i < h; i++){
            if (boxIdx == num) targetHeight = i;
            
            if (isRight) {
                for (int j = w - 1; j > -1 ; j--) {
                    if (boxIdx == num) targetWidth = j;
                    map[i][j] = boxIdx++;
                }
                isRight = false;
            }
            else {
                for (int j = 0; j < w; j++) {
                    if (boxIdx == num) targetWidth = j;
                    map[i][j] = boxIdx++;
                }
                isRight = true;
            }
        }
        print(map);
        for (int i = h - 1; i > targetHeight; i--){
            if (map[i][targetWidth] == num) break;
            if (map[i][targetWidth] <= n) answer++;
        }
        return answer;
    }
}

