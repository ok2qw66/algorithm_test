package jan_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1743 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
		int answer = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] space = new int[N][M];
		boolean[][] isVisited = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			space[r][c] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!isVisited[i][j] && space[i][j]!=0) {
					q.clear();
					int tempCnt = 1;
					
					isVisited[i][j] = true;
					q.add(new int[] {i,j});
					
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						
						for (int t = 0; t < 4; t++) {
							int r = curr[0] + d[t][0];
							int c = curr[1] + d[t][1];
							
							if(r<0 || r>=N || c<0 || c>=M) continue;
							if(space[r][c]!=0 && !isVisited[r][c]) {
								tempCnt++;
								isVisited[r][c] = true;
								q.add(new int[] {r,c});
							}
						}
					}
					
					answer = answer < tempCnt? tempCnt : answer;
					
				}
			}
		}
		
		System.out.println(answer);

	}

}
