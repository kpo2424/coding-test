package test;

import java.util.Arrays;

public class Solution3_4 {// 5kg이하 들수 있음, 여러개 옮길 수 있음
	// 이동 횟수 구하기
	public int solution(int[] nums) {
		int answer = 0;
		Arrays.sort(nums);// 몸무게 오름차순 정렬
		int left = 0;
		int rigth = nums.length - 1;
		while (left <= rigth) {// 오른쪽이 더 클 때까지 반복
			if (nums[left] + nums[rigth] <= 5) { // 작은 수와 큰 수 양쪽 값의 합이 5 보다 작으면
				answer++;// 태울 수 있는 보트 카운트
				left++;// 다음 사람
				rigth--;// 다음 사람

			} else {
				answer++;
				rigth--;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3_4 T = new Solution3_4();
		System.out.println(T.solution(new int[] { 2, 5, 3, 4, 2, 3 }));
		System.out.println(T.solution(new int[] { 2, 3, 4, 5 }));
		System.out.println(T.solution(new int[] { 3, 3, 3, 3, 3 }));
	}

}
