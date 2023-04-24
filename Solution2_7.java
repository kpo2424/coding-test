package test;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class Solution2_7 { // 경고메일
	public int getTime(String time) {
		int H = Integer.parseInt(time.split(":")[0]); // 시간 파싱
		int M = Integer.parseInt(time.split(":")[1]); // 분 파싱
		return H * 60 + M; // 분으로 변환하여 반환
	}

	public String[] solution(String[] reports, int time) {
		HashMap<String, Integer> inT = new HashMap<>(); // 출근 시간을 저장할 HashMap
		HashMap<String, Integer> sumT = new HashMap<>(); // 일한 시간을 저장할 HashMap
		for (String x : reports) { // 모든 출퇴근 기록을 순회
			String a = x.split(" ")[0]; // 이름 파싱
			String b = x.split(" ")[1]; // 시간 파싱
			String c = x.split(" ")[2]; // 상태 파싱
			if (c.equals("in")) // 출근 상태라면
				inT.put(a, getTime(b)); // 출근 시간 저장
			else // 퇴근 상태라면
				sumT.put(a, sumT.getOrDefault(a, 0) + (getTime(b) - inT.get(a))); // 일한 시간을 계산하여 저장
		}
		ArrayList<String> res = new ArrayList<>(); // 경고 메일을 받을 사람들의 이름을 저장할 ArrayList
		for (String name : sumT.keySet()) { // 모든 직원에 대해서
			if (sumT.get(name) > time) // 일한 시간이 time 분을 초과하면
				res.add(name); // 경고 메일을 받을 대상에 추가
		}
		res.sort((a, b) -> a.compareTo(b)); // 이름순으로 정렬
		String[] answer = new String[res.size()]; // 배열 생성
		for (int i = 0; i < res.size(); i++) { // 모든 이름에 대해서
			answer[i] = res.get(i); // 배열에 저장
		}
		return answer; // 경고 메일을 받을 대상을 반환
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2_7 T = new Solution2_7();
		System.out
				.println(
						Arrays.toString(T.solution(
								new String[] { "john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in",
										"john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out" },
								60)));
		System.out
				.println(
						Arrays.toString(T.solution(
								new String[] { "bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in",
										"john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out" },
								120)));
		System.out.println(Arrays.toString(T.solution(
				new String[] { "cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out",
						"luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out" },
				70)));
		System.out
				.println(
						Arrays.toString(T.solution(
								new String[] { "chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in",
										"daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out" },
								60)));
	}
}