package test2;

import java.util.HashMap;
import java.util.HashSet;

public class Solution3 { //서로 다른 빈도수 만들기
	public int solution(String s) {
		int answer = 0;

		HashMap<Character, Integer> sH = new HashMap<>();
		HashSet<Integer> ch = new HashSet<>(); // while문에서 중복을 제거하고 할당하므로 List도 가능
		for (char x : s.toCharArray()) { // s문자열을 하나씩 뽑아내서 x에 할당
			sH.put(x, sH.getOrDefault(x, 0) + 1); // key가 x인 값 없으면 0 리턴되고 +1
		} // sH.getOrDefault(x,0)메소드가 key(x)값 반환

		// sH 맵의 Key 값 중복 체크
		for (char key : sH.keySet()) {
			// ch에 key값이 포함되면(중복값이 있으면)
			while (ch.contains(sH.get(key))) {
				answer++; // 지운 횟수 카운트++
				sH.put(key, sH.get(key) - 1); // 문자수 -1을 key값에 할당
			}
			// key값이 0이 되면 다시 반복문. 다음 문자로 넘어감
			if (sH.get(key) == 0) {
				continue;
			}
			// ch HashSet에 중복 제거한 최종 key값 추가
			ch.add(sH.get(key));
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3 T = new Solution3();
		System.out.println(T.solution("aaabbbcccde"));
		System.out.println(T.solution("aaabbc"));
		System.out.println(T.solution("aebbbbc"));
		System.out.println(T.solution("aaabbbcccde"));
		System.out.println(T.solution("aaabbbcccdddeeeeeff"));
	}

}
