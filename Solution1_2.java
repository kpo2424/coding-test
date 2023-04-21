package test;

import java.util.Arrays;

class Solution1_2 { //로봇 청소기
	public int[] solution(int[][] board, int k){
		int[] answer = new int[2]; // 크기 2인 배열 선언 {1,2}
		int n = board.length; //nxn(정사각형이라 n 하나로) 보드 길이 선언
		int [] dx = {-1, 0, 1, 0}; //상하 방향
		int [] dy = {0, 1, 0, -1}; //오왼 방향
		//d = {(-1,0)12시, (0,1)3시, (1,0)6시, (0,-1)9시} >> 시계방향으로 90도 회전
		int x = 0, y = 0, d = 1, count = 0; //초기화, 1은 시작 3시 방향 설정
		while(count < k) { //k=시간(초)
			count++;
			int nx = x + dx[d]; //다음 x위치를 예상해봄
			int ny = y + dy[d]; //다음 y위치를 예상해봄
			//인덱스 범위를 벗어나거나 장애물1이 있으면
			if(nx < 0 || nx >= n || ny < 0 ||ny >= n || board[nx][ny] == 1) { 
				d = (d + 1) % 4; //시계방향으로 90도 회전시킴
				continue; //반복문으로 다시 돌아감
			}
			//장애물 없을 시, 다음 위치(nx, ny)로 이동
			x = nx;
			y = ny;
		}
		answer[0] = x;
		answer[1] = y;
		return answer; //k초 일 때 위치 출력 

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution1_2 T = new Solution1_2();
		int[][] arr1 = {{0, 0, 0, 0, 0}, 
			{0, 1, 1, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		int[][] arr2 = {{0, 0, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 1}, 
			{1, 1, 0, 0, 1, 0}, 
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = {{0, 0, 1, 0, 0}, 
			{0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr3, 25)));
		
	}
	
	

}
