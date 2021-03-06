package jan_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16987 {

	private static int[][] egg;
	private static int N;
	private static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		egg = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			egg[i][0] = Integer.parseInt(st.nextToken());
			egg[i][1] = Integer.parseInt(st.nextToken());
		}
		
		breakEgg(0, 0);
		System.out.println(answer);

	}

	private static void breakEgg(int idx, int breakEggCnt) {
		if(idx == N || breakEggCnt >= N-1) {
			answer = Math.max(breakEggCnt, answer);
			return;
		}else if(egg[idx][0] <=0) {
			breakEgg(idx+1,breakEggCnt);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(i == idx) continue;
			if(egg[i][0] > 0) { //계란이 존재한다면
				int breakEgg = 0;
				egg[idx][0] -= egg[i][1];
				egg[i][0] -= egg[idx][1];
				
				if(egg[idx][0] <= 0) breakEgg++;
				if(egg[i][0] <= 0) breakEgg++;
				
//				System.out.println("go > "+idx+"->"+i);
//				for(int k = 0; k<N;k++) {
//					System.out.print(egg[k][0]+" ");
//				}
				//System.out.println("===============");
				breakEgg(idx+1, breakEggCnt+breakEgg);
				
				egg[idx][0] += egg[i][1];
				egg[i][0] += egg[idx][1];
				
			}
		}
		
	}

}
