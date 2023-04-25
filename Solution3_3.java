package test;

import java.util.Arrays;

public class Solution3_3 {// 침몰하는 타이타닉_구명보트의 최소개수 구하기
	// 두명이하의 보트에 m이하로 탑승 가능
	public int solution(int[] nums, int m) {
		int answer = 0;
		Arrays.sort(nums);// 몸무게 오름차순 정렬
		int left = 0;
		int rigth = nums.length - 1;
		while (left <= rigth) {// 오른쪽이 더 클 때까지 반복
			if (nums[left] + nums[rigth] <= m) { // 작은 수와 큰 수 양쪽 값의 합이 m 보다 작으면
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
		Solution3_3 T = new Solution3_3();
		System.out.println(T.solution(new int[] { 90, 50, 70, 100, 60 }, 140));
		System.out.println(T.solution(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 }, 100));
		System.out.println(T.solution(
				new int[] { 68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81 }, 120));
	}
}
