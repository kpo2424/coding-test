package test;

import java.util.Arrays;
public class Solution1_1 {

	public char[] solution(int n, int[][] ladder){ //n은 학생 수(A,B ..) 
		char[] answer = new char[n]; // 코드 길이가 n인 answer선언{A, B, C..}
		for (int i = 0; i < n; i++) { // 학생 수만큼 반복
			answer[i] = (char)(65 + i); // 인덱스에 있는 학생을 A->65 정수형으로 변환
		}
		for (int[] line : ladder) { //첫번째 행 사다리{1, 3}, 두번째 라인{2, 4}, 세번째라인{1, 4}}
			// 각 요소를 line에 할당
			for(int x : line) { //(1,3)을 x=1, x=3 두번 할당(반복) 
				char tmp = answer[x]; //1-2 이어진 사다리 스위치 하기 위한 빈변수 설정.B담기 
				answer[x] = answer[x-1]; // x=1일때 [0],[1]값이 연결되어 있음. B에 A담기(B->A)
				answer[x-1] = tmp; // A에 B담기(A->B)
			} //첫번째 행에 대한 반복 끝나면 두번째 ladder 실행
		}
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


			Solution1_1 T = new Solution1_1();
			System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
			System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
			System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
			System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));

	}
	

}