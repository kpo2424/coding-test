package test;

import java.util.HashMap;

public class Solution2_4 { //음수가 있는 부분 수열
	// 연속된 숫자의 합이 m이 되기 위한 경우의 수
	// 그동안 나왔던 연산에서 빼서 m을 만드는 것으로 연산
	public int solution(int[] nums, int m) {
		int answer = 0;
		HashMap<Integer, Integer> nH = new HashMap<>();
		int sum = 0;
		nH.put(0, 1);
		for (int x : nums) {
			sum += x; //연속된 숫자의 합 sum에 x를 더함
			//sum-m이 nH에 포함되어 있으면 answer에 nH의 sum-m값을 더해줌
			if (nH.containsKey(sum - m))
				answer += nH.get(sum - m);
			//nH HashMap에 sum이라는 키 값이 없으면 0을 값으로 넣어주고 1을 더해줌
			nH.put(sum, nH.getOrDefault(sum, 0) + 1);
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2_4 T = new Solution2_4();
		System.out.println(T.solution(new int[] { 2, 2, 3, -1, -1, -1, 3, 1, 1 }, 5));
		System.out.println(T.solution(new int[] { 1, 2, 3, -3, 1, 2, 2, -3 }, 5));
		System.out.println(T.solution(new int[] { 1, 2, 3, -3, 1, 2 }, 3));
		System.out.println(T.solution(new int[] { -1, 0, 1 }, 0));
		System.out.println(T.solution(new int[] { -1, -1, -1, 1 }, 0));
	}

}
