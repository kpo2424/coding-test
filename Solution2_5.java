package test;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class Solution2_5 { //회장선거
	public String solution(String[] votes, int k){
		//split으로 공백 받아 리스트로 반환
		String answer = " ";

		HashMap<String, HashSet<String>> voteHash = new HashMap<>();
		HashMap<String, Integer> candidate = new HashMap<>();//추천받은 사람과 투표수
		HashMap<String, Integer> present = new HashMap<>();
		for(String x : votes) { //votes 배열에서 x 문자열을 하나씩 뽑아내서 반복
			String a = x.split(" ")[0]; //추천한 사람 a변수에 할당
			String b = x.split(" ")[1]; //추천받은 사람 b변수에 할당
			
			// a라는 키가 voteHash에 없으면 새로운 HashSet을 생성하여 추가
			voteHash.putIfAbsent(a, new HashSet<String>());
			voteHash.get(a).add(b);// voteHash에서 a를 키로 가지는 HashSet에 b 추가
			candidate.put(b, candidate.getOrDefault(b,0)+1);// candidate에서 b를 키로 가지는 값의 수를 1 증가시킴
		}

		int max = Integer.MIN_VALUE;// 최대 득표 수를 저장할 변수
		for (String a : voteHash.keySet()) { // voteHash에서 키 값(추천인)을 하나씩 뽑아내서 a에 할당
			int cnt = 0; //선물 받을 사람을 세기 위한 변수
			for(String b : voteHash.get(a)) { //voteHash의 키(a)에 대한 value(b)를 하나씩 반복 
				if(candidate.get(b)>= k) {// b를 키로 가지는 candidate의 값이 k보다 크거나 같으면
					cnt++;// cnt를 1 증가시킴
				}
			}
			present.put(a, cnt);// present에서 a를 키로 가지는 값을 cnt로 설정
			max = Math.max(max,  cnt);// max값을 cnt와 비교하여 큰 값을 max로 설정함
		}
		
		// 최대 득표 수를 받은 후보자들의 이름을 저장할 ArrayList 변수 tmp 선언
		ArrayList<String> tmp = new ArrayList<>();
		for(String name : present.keySet()) {// present의 key 값들을 하나씩 반복
			if(present.get(name) == max) tmp.add(name);// 해당 key의 value가 max값과 같으면
		}
		tmp.sort((a,b)-> a.compareTo(b));// ArrayList를 오름차순으로 정렬
		answer = tmp.get(0); // ArrayList의 첫 번째 값을 결과값으로 저장
		return answer;
	}	
			
		

	public static void main(String[] args) {
		Solution2_5 T = new Solution2_5();
		System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
		System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
	}
}