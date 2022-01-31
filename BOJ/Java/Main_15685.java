import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int[][] d = {{0,1},{-1,0},{0,-1},{1,0}};
	private static boolean[][] isDragon = new boolean[101][101];
	private static Queue<DragonLine> q;
	private static int[] baseLoc = new int[2];
	static class DragonLine {
		int x;
		int y;
		int d;
		
		public DragonLine(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			q = new LinkedList<DragonLine>();
			isDragon[x][y] = true;
			
			x += d[dir][0];
			y += d[dir][1];
			
			if(x<0 || x>=101 || y<0 || y>=101) continue;
			isDragon[x][y] = true;
			baseLoc[0] = x;
			baseLoc[1] = y;
			q.add(new DragonLine(x, y, (dir+1)%4));
			
			baseLoc[0] = x;
			baseLoc[1] = y;
			
			while(g-->0) {
//				System.out.println("g--"+g);
				buildNextStep();
			}
			
		}

		print();
	}
	

	private static void print() {
		int answer = 0;
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if(isDragon[r][c] && isDragon[r+1][c] && isDragon[r][c+1] && isDragon[r+1][c+1])
					answer++;
			}
		}
		System.out.println(answer);
	}
	
	private static void buildNextStep() {
		Stack<DragonLine> prevStack = new Stack<DragonLine>();
		Queue<DragonLine> nxtQ = new LinkedList<DragonLine>();
		
		while(!q.isEmpty()) {
			DragonLine curr = q.poll();
//			System.out.println(curr.x+" "+curr.y);
			prevStack.add(curr);
			nxtQ.add(curr);
		}
		
		while(!prevStack.isEmpty()) {
			DragonLine current = prevStack.pop();
		 	
			int x = baseLoc[0] + d[current.d][0];
			int y = baseLoc[1] + d[current.d][1];
			
			if(x<0 || x>=101 || y<0 || y>=101) continue;
			isDragon[x][y] = true;
			baseLoc[0] = x;
			baseLoc[1] = y;
			nxtQ.add(new DragonLine(x, y, (current.d+1)%4));
		}
		
		while(!nxtQ.isEmpty()) {
			q.add(nxtQ.poll());
		}
		
	}

}
