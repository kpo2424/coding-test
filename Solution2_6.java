package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//문서 도난
class Info implements Comparable<Info> { // Info 클래스 생성 및 Comparable 인터페이스 구현
	public String name; // 이름을 저장할 변수
	public int time; // 시간을 저장할 변수

	Info(String name, int time) { // 생성자 함수
		this.name = name;
		this.time = time;
	}

	@Override
	public int compareTo(Info ob) { // Comparable 인터페이스의 compareTo 메소드 재정의
		System.out.println("compare out : " + (this.time - ob.time)); // 비교되는 값을 출력
		return this.time - ob.time; // 현재 객체의 시간에서 매개변수로 받은 객체의 시간을 뺀 값을 반환
	}
}

class q1 {
	public int getTime(String time) { // 시간을 분으로 변환하는 함수
		int H = Integer.parseInt(time.split(":")[0]); // 시간을 ':'을 기준으로 분리한 후, 첫번째 값을 시간으로 변환
		int M = Integer.parseInt(time.split(":")[1]); // 시간을 ':'을 기준으로 분리한 후, 두번째 값을 분으로 변환
		return H * 60 + M; // 분으로 변환 후 반환
	}

	public String[] solution(String[] reports, String times) { // 주어진 시간 범위 내에 보고서를 작성한 사람들의 이름을 반환하는 함수
		ArrayList<Info> tmp = new ArrayList<>(); // Info 객체를 저장할 ArrayList 생성
		for (String x : reports) { // 보고서를 하나씩 순회하며
			String a = x.split(" ")[0]; // 보고서에서 이름을 추출
			String b = x.split(" ")[1]; // 보고서에서 시간을 추출
			tmp.add(new Info(a, getTime(b))); // Info 객체를 생성하고 ArrayList에 추가
		}
		Collections.sort(tmp); // ArrayList를 시간 오름차순으로 정렬

		int s = getTime(times.split(" ")[0]); // 시작 시간을 분으로 변환
		Info startTime = new Info("startTime", s); // 시작 시간을 Info 객체로 생성
		int e = getTime(times.split(" ")[1]); // 끝 시간을 분으로 변환
		Info endTime = new Info("endTime", e); // 끝 시간을 Info 객체로 생성

		ArrayList<String> res = new ArrayList<>(); // 결과를 저장할 ArrayList 생성
		for (Info ob : tmp) { // 정렬된 ArrayList를 하나씩 순회하며
			if (ob.compareTo(startTime) > 1 && ob.compareTo(endTime) <= 0) { // 주어진 시간 범위 내에 있는 보고서라면
				res.add(ob.name); // 해당 보고서의 이름을 결과 ArrayList에 추가
			}
			if (ob.compareTo(endTime) > 0) // 끝 시간을 넘어간 보고서가 나오면
				break; // 반복문 종료
		}
		String[] answer = new String[res.size()]; // 결과

		for (int i = 0; i < res.size(); i++) {
			answer[i] = res.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		q1 T = new q1();
		System.out.println(Arrays.toString(
				T.solution(new String[] { "john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57" },
						"08:33 09:45")));
		System.out.println(Arrays.toString(T.solution(new String[] { "ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57",
												"bill 17:35", "tom 07:23", "john 15:23", "park 09:59" },
										"15:01 19:59")));
		System.out.println(Arrays.toString(
				T.solution(new String[] { "cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50" },
						"14:20 15:20")));
	}
}
