package test;

import java.util.Arrays;

class Solution3 { // 현수와 강아지 만나기
	public int solution(int[][] board) {
		int n = board.length; // 지도는 정사각형
		// 시계방향으로 방향 전환
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		// 1 = 현수 위치, 2 = 강아지 위치
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		// 현수 x1(행)위치 찾기
		for (int i = 0; i < n; i++) {
			// 현수 x2(열)위치 찾기
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 2) { // 현수(2)를 찾으면
					x1 = i; // 현수 위치 저장
					y1 = j;
				}
				if (board[i][j] == 3) {// 강아지(3)를 찾으면
					x2 = i; // 강아지 위치 저장
					y2 = j;
				}
			}
		}
		// d1 = 현수 방향, d2 = 강아지 방향, count = 시간(분)
		int d1 = 0, d2 = 0, count = 0;
		// 10000분 동안 찾기
		while (count < 10000) {
			count++;
			// 현수의 다음 예상 위치
			int nx1 = x1 + dx[d1];
			int ny1 = y1 + dy[d1];
			// 강아지의 다음 예상 위치
			int nx2 = x2 + dx[d2];
			int ny2 = y2 + dy[d2];

			boolean flag1 = true, flag2 = true; //flag를 true로 선언

			//현수가 board 인덱스가 범위 벗어나거나 장애물(1) 만나면
			if (nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= n || board[nx1][ny1] == 1) {
				d1 = (d1 + 1) % 4; //방향전환
				flag1 = false; // 밑에 true 조건문 건너뜀
			}
			//위에 조건문 해당 안되면 실행
			if (flag1 == true) {
				//다음 위치로 이동
				x1 = nx1;
				y1 = ny1;
			}
			
			//강아지가 board 인덱스가 범위 벗어나거나 장애물(1) 만나면
			if (nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= n || board[nx2][ny2] == 1) {
				d2 = (d2 + 1) % 4;
				flag2 = false;
			}
			//위에 조건문 해당 안되면 실행
			if (flag2 == true) {
				//다음 위치로 이동
				x2 = nx2;
				y2 = ny2;
			}
			//현수와 강아지의 위치가 같으면 종료
			if (x1 == x2 && y1 == y2)
				break;
		}
		//10000분 후에 못 찾으면 0반환
		if (count >= 10000) {
			return 0;
		}
		return count;

	}

	public static void main(String[] args) {
		Solution3 T = new Solution3();
		int[][] arr1 = { { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 2, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 3, 0, 0, 0, 1 },
				{ 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 } };
		System.out.println(T.solution(arr1));
		int[][] arr2 = { { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 1, 0, 1, 0 }, { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0, 2, 1 },
				{ 0, 0, 0, 1, 0, 1, 0, 0, 0, 1 }, { 0, 1, 0, 1, 0, 0, 0, 0, 0, 3 } };
		System.out.println(T.solution(arr2));

	}

}
