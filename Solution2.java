package test2;

import java.util.Arrays;
import java.util.HashMap;

public class Solution2 { //최소 갯수 추가하여 같은 빈도수 만들기
	public int[] solution(String s) {
		int[] answer = new int[5]; // {a,b,c,d,e}

		// key:문자, value:문자가 저장된 횟수
		HashMap<Character, Integer> sH = new HashMap<>();
		// s문자열의 모든 문자를 HashMap에 추가
		for (char x : s.toCharArray()) { // 문자열 s를 문자 배열로 변환하고 x를 차례로 순회
			if (x == 'a' || x == 'b' || x == 'c' || x == 'd' || x == 'e') {
				sH.put(x, sH.getOrDefault(x, 0) + 1);
			} else { //문자열에 알파벳이 포함되지 않으면
 				sH.put(x, 0); //value값 0으로 지정
			}
		}
		//vale 값 중 최댓값 찾기
		int max = Integer.MIN_VALUE; //가장 작은 수로 최대값의 초기값 설정
		for (int y : sH.values()) { //value() : value 값 반환하는 메소드
			max = Math.max(max, y); 
		}
		
		//max 값에서 각 vale 값 빼기
		//해시맵에서 각 key 값에 해당하는 vale값 찾아서 빼기
		for (char x : "abcde".toCharArray()) { // 문자열 abcde를 배열로 변환하고 x를 차례로 순회
			int result = max - sH.getOrDefault(x, 0); //최댓값으로 맞춰주기 위해 추가할 수 구하기
			//System.out.println(result);
			answer[x-'a'] = result; //알파벳에 해당하는 인덱스에 result값 할당
		}
			
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 T = new Solution2();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}

}
