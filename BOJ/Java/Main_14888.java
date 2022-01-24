package jan_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14888 {

	private static int[] number;
	private static int[] operator = new int[4];
	private static int[] operOrder;
	private static long[] maxMin = {-1000000000,1000000000};
	private static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		operOrder = new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		setOrder(0);
		System.out.println(maxMin[0]);
		System.out.println(maxMin[1]);

	}
	private static void setOrder(int idx) {
		if(idx == N-1) {
			calculate();
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(operator[i] >0) {
				operator[i]--;
				operOrder[idx] = i;
				setOrder(idx+1);
				operator[i]++;
			}
		}
	}
	
	private static void calculate() {
//		System.out.println(Arrays.toString(operOrder));
		int answer = number[0];
		for (int i = 0; i < N-1;) {
			switch (operOrder[i]) {
			case 0: // +
				answer += number[++i];
				break;
			case 1: // -
				answer -= number[++i];
				break;
			case 2: // *
				answer *= number[++i];
				break;
			case 3: // /
				if(answer < 0) {
					answer = 0 - (Math.abs(answer)/number[++i]);
				}else {
					answer /= number[++i];
				}
				break;
			}
		}
		
		maxMin[0] = maxMin[0] < answer ? answer : maxMin[0];
		maxMin[1] = maxMin[1] > answer ? answer : maxMin[1];
		
	}

}
