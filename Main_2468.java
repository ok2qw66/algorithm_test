package jan_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 {
	private static int answer = 0;
	private static int[][] area;
	private static boolean[][] isVisited;
	private static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int max = 0;
		area = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int x = Integer.parseInt(st.nextToken());
				area[i][j] = x;
				max = max > x ? max : x;
			}
		}
		
		for (int x = 0; x <= max; x++) {
			findSafetyZone(x);
		}

		System.out.println(answer);
	}
	
	private static void findSafetyZone(int x) {
		int count = 0;
		isVisited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(area[i][j]> x && !isVisited[i][j]) {
					count++;
					setVisited(i,j,x);
				}
					
			}
		}
//		System.out.println(x +" "+count);
		answer = answer < count ? count : answer;
	}

	private static void setVisited(int i, int j, int x) {
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		
		Queue<int[]> q = new LinkedList<int[]>();
		isVisited[i][j] = true;
		q.add(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int k = 0; k < 4; k++) {
				int r = curr[0] + dir[k][0];
				int c = curr[1] + dir[k][1];
				
				if(r<0 || r>= N || c<0 || c>= N || area[r][c] <= x || isVisited[r][c]) continue;
				
				isVisited[r][c] = true;
				q.add(new int[] {r,c});
			}
		}
	}

}
