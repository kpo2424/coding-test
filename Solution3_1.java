package test;
import java.util.HashSet;

public class Solution3_1 {// 최대 길이 연속수열
	public int solution(int[] nums) {
		int answer=0;
		HashSet <Integer> set = new HashSet<>();// 중복값 허용 안함
		for (int x : nums) { //set에 중복 제외 값 다시 담기
			set.add(x); 
		}
		for (int x : set) { //인수 하나씩 반복
			if(set.contains(x-1)) //연속되는 수열의 최소값 찾기
				continue; 
			int cnt = 0;
			while(set.contains(x)) { //1씩 증가하는 연속 수열이 있으면 카운트
				cnt++;
				x++;
			}
			answer = Math.max(answer, cnt); //연속하는 수열 중에 최대 길이의 수열 찾기
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3_1 T = new Solution3_1();
		System.out.println(T.solution(new int[] { 8, 1, 9, 3, 10, 2, 4, 0, 2, 3 }));
		System.out.println(T.solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0 }));
		System.out.println(T.solution(new int[] { 3, 3, 3, 3, 3, 3, 3, 3 }));
		System.out.println(T.solution(new int[] { -3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1 }));
		System.out.println(T.solution(new int[] { -5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7 }));
	}
}
