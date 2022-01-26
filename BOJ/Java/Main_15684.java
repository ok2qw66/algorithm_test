package jan_2022;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_15684 {

	private static boolean[][] isExistGaro;
	private static int N,M,H;
	private static int answer = 4;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		isExistGaro = new boolean[H+1][N+2];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			isExistGaro[a][b] = true;
		}
		
		goSet(1,0);
		answer = answer ==4 ? -1 : answer;
		System.out.println(answer);
	}

	private static boolean goSet(int row, int cnt) {
		//System.out.println(row+" "+cnt);
		if(isPossible(cnt)) return true;
		
		if(row == H+1 || cnt==3) return false;
		
		for (int i = 1; i < N; i++) {
			if(!isExistGaro[row][i] && !isExistGaro[row][i-1]) {
				isExistGaro[row][i] = true;
				goSet(row, cnt+1);
				isExistGaro[row][i] = false;
			}
		}
		goSet(row+1,cnt);
		
		return false;
		
	}
	
	private static boolean isPossible(int cnt) {
//		System.out.println("start = "+cnt);
//		for (int i = 1; i <= H; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(isExistGaro[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		for (int start = 1; start<= N; start++) {
			int current = start;
//			System.out.println(current);
			for (int garoLoc = 1; garoLoc <= H; garoLoc++) {
//				System.out.println(current+" > "+garoLoc);
				if(isExistGaro[garoLoc][current-1]) {
					current--;
				}else if(isExistGaro[garoLoc][current]) {
					current++;
				}
//				System.out.println("current = "+current);
			}
			
			if(current != start) return false;	
		}
		
//		System.out.println(cnt);
		answer = cnt < answer ? cnt : answer;
		return true;
	}

}
