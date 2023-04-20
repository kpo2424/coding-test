package test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution5 {
	public int solution(int[] nums) {
		int answer = 0;// 초기값 할당

		// 피크값 저장
		List<Integer> peaks = new ArrayList<>();// 피크 값 담을 리스트 객체 생성
		int n = nums.length; // 숫자의 크기
		for (int i = 1; i < n - 1; i++) { // 숫자 인덱스 1번부터 시작( 0은 바이토닉 수열이 될 수 없음)
			if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) { // 양옆보다 크면 솟은 값
				peaks.add(i); // 피크 인덱스에 담아
			}
		}

		// 피크값 기준으로 좌우 길이 count하다가 증가하면 멈춤
		for (int x : peaks) { // 모든 peaks 값을 순회하며 x 변수에 하나씩 넣어줌
			int left = x; // 피크 기준 왼쪽
			int rigth = x; // 피크 기준 오른쪽
			int count = 1; // 수열의 길이 카운트

			// 피크 기준 왼쪽 비교
			while (left - 1 >= 0 && nums[left - 1] < nums[left]) {// 0번 인덱스까지 비교. 왼쪽으로 갈 숫자가 더 작으면(감소 시)
				left--; //왼쪽으로 이동
				count++; //수열의 길이 +1
			}
			// 피크 기준 오른쪽 비교
			while (rigth + 1 < n && nums[rigth] > nums[rigth + 1]) { //마지막 인덱스까지 비교. 오른쪽으로 갈 숫자가 더 크면(증가 시)
				rigth++; //오른쪽 이동
				count++; //수열의 길이 +1
			}
			answer = Math.max(answer, count); //모든 피크 값의 수열의 길이를 answer에 넣고 새로운 count와 비교해 큰 값 반환
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution5 T = new Solution5();
		System.out.println(T.solution(new int[] { 1, 2, 1, 2, 3, 2, 1 }));
		System.out.println(T.solution(new int[] { 1, 1, 2, 3, 5, 7, 4, 3, 1, 2 }));
		System.out.println(T.solution(new int[] { 3, 2, 1, 3, 2, 4, 6, 7, 3, 1 }));
		System.out.println(T.solution(new int[] { 1, 3, 1, 2, 1, 5, 3, 2, 1, 1 }));
	}

}
