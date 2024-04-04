class Solution { 
	public static long solution(int w, int h) {
        long answer = 0;
        for(int i = 0; i < w; i++){
            long area = (long)Math.floor((double)h * i / w );
            answer += area;
        }
        return answer * 2;
	}
}