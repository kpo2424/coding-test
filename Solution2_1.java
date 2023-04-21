package test2;

import java.util.HashMap;

public class Solution2_1 { // 한번만 사용한 최초 문자의 인덱스 찾기
	public int solution(String s) {
		// key:문자, value:문자가 저장된 횟수
		HashMap<Character, Integer> sH = new HashMap<>();
		// s문자열의 모든 문자를 HashMap에 추가
		for (char x : s.toCharArray()) { // 문자열 s를 문자 배열로 변환하고 x를 차례로 순회
			sH.put(x, sH.getOrDefault(x, 0) + 1);// key(x)값 없으면 0 리턴되고 +1하여 value값 새로 지정
		} // sH.getOrDefault(x,0)메소드가 key(x)값을 반환

		// 문자열의 길이만큼 반복
		for (int i = 0; i < s.length(); i++) {
			if (sH.get(s.charAt(i)) == 1) { // 문자열 s에서 i번째 문자의 value값이 1이면
				return i + 1; // 해당 인덱스+1(인덱스 0부터 시작) 리턴 
			}
		}
		return -1; // 한번만 사용한 문자 없으면 -1 리턴

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2_1 T = new Solution2_1();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}

}
