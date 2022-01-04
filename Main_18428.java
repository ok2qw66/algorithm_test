package jan_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_18428 {

	private static int[][] school;
	private static int[][] teacher = new int[9][2];
	private static int t;
	private static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		t = 0;
		school = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			int j = 0;
			for (String string : line) {
				if(string.equals("T")) {
					teacher[t][0] = i;
					teacher[t++][1] = j;
					school[i][j++] = -1;
				}else if(string.equals("S")) {
					school[i][j++] = 1;
				}else {
					school[i][j++] = 0;
				}
			}
			
		}
		
		String answer = install(0,0,0)? "YES" : "NO";
		System.out.println(answer);
	}
	
	private static boolean install(int i, int j, int count) {
		if(count==3)
			return verify();
		
		for (;i < N; i++) {
			for (;j<N;j++) {
				if(school[i][j]==0) {
					school[i][j] = -1;
					if(install(i,j,count+1))
						return true;
					school[i][j] = 0;
				}	
			}
			j = 0;
		}
		
		return false;
		
	}

	private static boolean verify() {
		for (int i = 0; i < t; i++) {
			if(findStudent(teacher[i][0], teacher[i][1]))
				return false;
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(school[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		return true;
	}

	private static boolean findStudent(int i, int j) {
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		
		for (int k = 0; k < 4; k++) {
			int r = i;
			int c = j;
			while(true) {
				r += dir[k][0];
				c += dir[k][1];
				
				if(r<0 || r>=N || c<0 || c>=N || school[r][c]<0)
					break;
				else if(school[r][c]==1)
					return true;
			}
		}
		
		return false;
	}

}
