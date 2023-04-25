package test;

import java.util.Scanner;

public class Solution3_6 { // 10이하의 n개의 자연수가 주어지면 이 중 m개 뽑아 나열
	static int[] pm, ch, arr;
	static int n, m;

	public void DFS(int L) {
		if (L == m) { // m개의 수를 뽑아서 나열했을 때
			for (int x : pm) {
				System.out.print(x + " ");
			}
			System.out.println();
		} else {

			for (int i = 0; i < n; i++) { // 중복을 허용하지 않고, 순서를 고려하여 뽑기 위해서
				if (ch[i] == 0) {
					ch[i] = 1;
					pm[L] = arr[i];
					DFS(L + 1);
					ch[i] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3_6 T = new Solution3_6();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		arr = new int[n];
		for(int i = 0; i < n; i ++) arr[i] = kb.nextInt();
		ch = new int[n];
		pm = new int[m];
		T.DFS(0);
	}
}
