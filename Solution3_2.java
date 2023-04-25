package test;

import java.util.Stack;

public class Solution3_2 {// 문자열 압축 해제
	public String solution(String s) {
		// 3(ab) = ababab stack ( 나오기 전까지 꺼냄
		String answer = "";
		Stack<String> st = new Stack<>(); // 3 ( 2 a (
		for (Character x : s.toCharArray()) {
			if (x == ')') {
				String tmp = "";
				while (!st.empty()) {
					String c = st.pop();
					if (c.equals("(")) {
						String num = "";
						while (!st.empty() && Character.isDigit(st.peek().charAt(0))) {
							num = st.pop() + num;
						}
						String res = "";
						int cnt = 0;
						if (num.equals("")) {
							cnt = 1;
						} else
							cnt = Integer.parseInt(num);
						for (int i = 0; i < cnt; i++) {
							res += tmp;
						}
						st.push(res);
						break;
					}
					tmp = c + tmp;// 여는 기호 아니면 tmp에 담기
				}
			} else
				st.push(String.valueOf(x));
		}
		for (String x : st)
			answer += x;
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3_2 T = new Solution3_2();
		System.out.println(T.solution("3(a2(b))ef"));
		System.out.println(T.solution("2(ab)k3(bc)"));
		System.out.println(T.solution("2(ab3((cd)))"));
		System.out.println(T.solution("2(2(ab)3(2(ac)))"));
		System.out.println(T.solution("3(ab2(sg))"));
	}
}
