package test;

import java.util.Arrays;

public class Solution1_7 {
	public int solution(int[] keypad, String password) {
		int answer = 0;
		int[][] pad = new int[3][3]; // 3x3인 2차원 빈 키패드 선언하기
		//dist 배열은 0부터 9까지의 인덱스로 생성되며, 키패드 값을 인덱스로 사용할 때는 해당 값에 1을 더해서 사용
		//0~8 인덱스를 사용하는데 **키패드 값을 인덱스로 사용할때 해당 값에 1더해서 사용하므로 1~9 인덱스 하용하게 됨
		int[][] dist = new int[10][10];
		// 좌/우/상/하/대각선으로 이동 가능
		int[] dx = { -1, 0, 1, 0, -1, -1, 1, 1 }; // 4-7인덱스 값이 대각선
		int[] dy = { 0, 1, 0, -1, -1, 1, -1, 1 };
		//d = {(-1,0)12시, (0,1)3시, (1,0)6시, (0,-1)9시, (-1,-1)11시, (-1,1)1시, (1,-1)7시, (1,1)5시}
		// 키패드에 값 부여하는 코드
		for (int i = 0; i < 3; i++) { // i는 행
			for (int j = 0; j < 3; j++) { // j는 열
				pad[i][j] = keypad[i * 3 + j]; // 키패드 값을 패드 배열 안에 할당
			}
		}
		// 모든 원소 값 2로 초기화 (인접하지 않은 값 2초 소요)
		for (int i = 0; i < 10; i++) {
			Arrays.fill(dist[i], 2); // 각 i행에 2 할당
		}
		// 행과 열이 같은 원소는 0으로 초기화 (자기자신은 0초 소요)
		for (int i = 0; i < 10; i++) {
			dist[i][i] = 0;
		}
		
		// 상하좌우대각선은 1초 소요
		// 해당 비밀번호의 위치 찾기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int from = pad[i][j];//**키패드 처음 인덱스부터 번호 찾기
				
				for (int k = 0; k < 8; k++) { //상하좌우대각선으로 갈 수 있으면
					//행과 열이 모두 0~2범위(인덱스) 안에 있으면
					if (i + dx[k] >= 0 && i + dx[k] < 3 && j + dy[k] >= 0 && j + dy[k] < 3) { 
						int to = pad[i + dx[k]][j + dy[k]]; //다음 방향으로 이동
						dist[from][to] = 1;//비밀번호의 상하좌우대각선 값을 dist 배열에 1로 할당
					}
				}
			}
		}
		for (int i = 1; i < password.length(); i++) {
			// 비밀번호를 문자형에서 정수형으로 변환//문자 0은 아스키코드 값으로 48
			int from = (int) (password.charAt(i - 1) - 48); 
			int to = (int) (password.charAt(i) - 48);
			answer += dist[from][to]; //dist 배열에서 소요되는 초 찾아서 다 더하면 총 소요 시간 나옴
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1_7 T = new Solution1_7();
		System.out.println(T.solution(new int[] { 2, 5, 3, 7, 1, 6, 4, 9, 8 }, "7596218"));
		System.out.println(T.solution(new int[] { 1, 5, 7, 3, 2, 8, 9, 4, 6 }, "63855526592"));
		System.out.println(T.solution(new int[] { 2, 9, 3, 7, 8, 6, 4, 5, 1 }, "323254677"));
		System.out.println(T.solution(new int[] { 1, 6, 7, 3, 8, 9, 4, 5, 2 }, "3337772122"));
	}

}
