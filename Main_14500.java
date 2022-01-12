package jan_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500 {

	private static int[][] paper;
	private static int answer = 0;
	private static int[][] sero = {{-1,0},{0,-1},{0,1},{3,0},{1,-1},{2,-1},{1,1},{2,1}};
	private static int[][] garo = {{0,-1},{-1,0},{-1,1},{-1,2},{0,3},{1,2},{1,1},{1,0},{1,-1}};
	private static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
//				if(i <= N-3)
					findVertical(i,j,0,0); //세로로 연속 찾기 
//				if(j <= M-3)
					findHorizontal(i,j,0,0); //가로로 연속 찾기
				if(i < N-1 && j <M-1)
					findSquare(i,j); //정사각형 찾기
			}
		}
		
		System.out.println(answer);
		
	}

	private static void findSquare(int i, int j) {
		int sum = paper[i][j] + paper[i][j+1] + paper[i+1][j] + paper[i+1][j+1];
		answer = answer > sum ? answer : sum;
//		System.out.println("square -- "+i+" "+j+">> "+answer);
	}

	private static void findHorizontal(int i, int j, int count, int sum) {
		if(count ==2)
			goZigZagSero(i-2,j,4,sum);
		
		if(count==3) {
			setSero(i-3,j,sum);
		}else {
			if(i<0 || i>=N || j<0 || j>= M) return;
			findHorizontal(i+1, j, count+1, sum+paper[i][j]);
		}
	}

	

	private static void setSero(int i, int j, int sum) {
		for (int k = 0; k < 8; k++) {
			int r = i + sero[k][0];
			int c = j + sero[k][1];
			if(r<0 || r>=N || c<0 || c>= M) continue;
			answer = sum+paper[r][c] > answer ? sum+paper[r][c] : answer;
//			System.out.println("setSero -- "+i+" "+j+">> "+answer);
		}	
		
		
	}

	private static void goZigZagSero(int i, int j, int idx, int sum) {
		int test1 = sum;
		int test2 = sum;
		for (int k = 0; k < 2; k++,idx++) {
			int r = i + sero[idx][0];
			int c = j + sero[idx][1];
			if(r>=0 && r<N && c>=0 && c< M)
				test1 += paper[r][c];
			else
				test1 = -1000;
			
			r = i + sero[idx+2][0];
			c = j + sero[idx+2][1];
			if(r>=0 && r<N && c>=0 && c< M)
				test2 += paper[r][c];
			else
				test2 = -1000;
		}
		
		test1 = test1 > test2 ? test1 : test2;
		answer = test1 > answer ? test1 : answer;
//		System.out.println("goZigZagSero -- "+i+" "+j+" "+sum+">> "+answer);
	}

	private static void findVertical(int i, int j, int count, int sum) {
		if(count ==2)
			goZigZagGaro(i,j-2,5,sum);
		
		if(count==3) {
			setGaro(i,j-3,sum);
		}else {
			if(i<0 || i>=N || j<0 || j>= M) return;
			findVertical(i, j+1, count+1, sum+paper[i][j]);
		}
		
	}

	private static void setGaro(int i, int j, int sum) {
		for (int k = 0; k < 8; k++) {
			int r = i + garo[k][0];
			int c = j + garo[k][1];
			if(r<0 || r>=N || c<0 || c>= M) continue;
			answer = sum+paper[r][c] > answer ? sum+paper[r][c] : answer;	
//			System.out.println("setGaro -- "+i+" "+j+">> "+answer);
		}

	}

	private static void goZigZagGaro(int i, int j, int idx, int sum) {
		int test1 = sum;
		int test2 = sum;
		for (int k = 0; k < 2; k++,idx++) {
			int r = i + garo[idx][0];
			int c = j + garo[idx][1];
			if(r>=0 && r<N && c>=0 && c< M)
				test1 += paper[r][c];
			else
				test1 = -4000;
			
			r = i + garo[idx+2][0];
			c = j + garo[idx+2][1];
			if(r>=0 && r<N && c>=0 && c< M)
				test2 += paper[r][c];
			else
				test2 = -4000;
		}
		
		test1 = test1 > test2 ? test1 : test2;
		answer = test1 > answer ? test1 : answer;
//		System.out.println("goZigZagGaro -- "+i+" "+j+" "+sum+" >> "+answer);
	}

}
