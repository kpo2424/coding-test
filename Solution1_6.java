package test;

import java.util.Arrays;

public class Solution1_6 {
	//각 학생의 최소 과일 구하는 함수
	public int getMin(int[] fruit) {
		int min = 100;
		for (int x : fruit) { //과일을 하나씩 넣어서 비교
			min = Math.min(min, x);
		}
		return min; //과일의 최솟값 반환
	}

	//최소값이 유일한지 확인하는 함수
	public Boolean isMinUnique(int[] fruit) {  
		int cnt = 0;
		int min = getMin(fruit);//위 함수에서 구한 최솟값을 min 으로 선언
		for (int x : fruit) { //과일 하나씩 x에 할당
			if (x == min) //과일이 getMin함수의 최소값과 같으면 
				cnt++; //카운트 +1 
		}
		return cnt == 1; //return cnt == 1 ? true : false (리턴값이 1이 아니면 false 반환)
	}

	//최소 과일의 인덱스값 구하는 함수
	public int getMinIndex(int[] fruit) {
		int min = getMin(fruit);
		for (int i = 0; i < 3; i++) { //과일은 총 3개 > 3번 반복
			if (fruit[i] == min) //최솟값과 같은 과일의 인덱스 반환
				return i;
		}  
		return 0;
	}

	public int solution(int[][] fruit) {
		int answer = 0;
		int n = fruit.length; //학생 수 선언
		int[] ch = new int[n]; //교환 흔적 찾는 변수 ch. 크기가 n인 배열 선언
		for (int i = 0; i < n; i++) { // 학생 수 만큼 반복
			if (ch[i] == 1) // 교환 흔적이 있으면
				continue; // 다음 학생으로 넘어가서 다시 비교
			if (isMinUnique(fruit[i]) == false) // 최솟값이 유일하지 않으면 다시 핵생 찾기
				continue;
			for (int j = i + 1; j < n; j++) { //b의 과일 j
				if (ch[j] == 1) //교환 흔적이 있으면 
					continue;
				if (isMinUnique(fruit[j]) == false)
					continue;
				int a = getMinIndex(fruit[i]); //
				int b = getMinIndex(fruit[j]);
				if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
					if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
						fruit[i][a]++; // i의 최소 과일 +1
						fruit[i][b]--; // i의 (j의 최소 과일)과일 -1
						fruit[j][b]++; // j의 최소 과일 +1
						fruit[j][a]--; // j의 (i의 최소 과일)과일 -1
						ch[i] = 1;//교환한 흔적 1로 표시
						ch[j] = 1;
					}
				}
			}
		}
		for (int[] x : fruit) {
			answer += getMin(x);
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution1_6 T = new Solution1_6();
		System.out.println(T.solution(
				new int[][] { { 10, 20, 30 }, { 12, 15, 20 }, { 20, 12, 15 }, { 15, 20, 10 }, { 10, 15, 10 } }));
		System.out.println(T.solution(new int[][] { { 10, 9, 11 }, { 15, 20, 25 } }));
		System.out.println(T.solution(
				new int[][] { { 0, 3, 27 }, { 20, 5, 5 }, { 19, 5, 6 }, { 10, 10, 10 }, { 15, 10, 5 }, { 3, 7, 20 } }));
		System.out.println(T.solution(new int[][] { { 3, 7, 20 }, { 10, 15, 5 }, { 19, 5, 6 }, { 10, 10, 10 },
				{ 15, 10, 5 }, { 3, 7, 20 }, { 12, 12, 6 }, { 10, 20, 0 }, { 5, 10, 15 } }));
	}

}
