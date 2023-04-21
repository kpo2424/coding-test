package test;

import java.util.Arrays;

public class Solution1_4 { // 좌석 번호 찾기
	public int[] solution(int c, int r, int k) {
		int[] answer = new int[2];
//		if (c * r < k)
//			return new int[] { 0, 0 };
		// 사람 수가 좌석 수보다 많으면 [0,0] 반환
		if (c * r < k) { 
			answer[0] = 0;
			answer[1] = 0;
			return answer;
		}

		int[][] board = new int[c][r]; // 좌석배치 2차원 배열 선언하기

		// 시계방향으로 방향 전환
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int x = 0, y = 0, d = 1, count = 1; // 초기화, d는 3시 방향에서 시작
		
		while (count < k) { //k번째까지 카운트(2번 자리부터 카운트하는 반복문)
			//다음 예상 위치
			int nx = x + dx[d];
			int ny = y + dy[d];
			//인덱스 범위를 벗어나거나 좌석이 비어있지 않으면
			if (nx < 0 || nx >= c || ny < 0 || ny >= r || board[nx][ny] != 0) {
				d = (d + 1) % 4; //방향 전환
				continue; //반복문으로 돌아감
			}
			board[x][y] = count;//사람들을 자리에 할당
			count++; //다음 사람으로 이동

			//예상 위치를 현재 위치로 할당 
			x = nx; 
			y = ny;

		}
		//첫번째 사람의 자리
		//좌석은 (1,1)부터 시작되니깐 +1
		answer[0] = x + 1; 
		answer[1] = y + 1;
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution1_4 T = new Solution1_4();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}

}
