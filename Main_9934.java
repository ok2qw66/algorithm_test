package jan_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9934 {

	private static int[] visited;
	private static StringBuilder[] sb;
	private static int L;
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		L = (int)Math.pow(2, N);
		sb = new StringBuilder[N];
		
		visited = new int[L];
		
		for (int i = 0; i < N; i++) {
			sb[i] = new StringBuilder();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < L; i++) {
			visited[i] = Integer.parseInt(st.nextToken());
		}
		
		findAnswer(0, 1, L-1);
		
		for (int i = 0; i < N; i++) {
			sb[i].setLength(sb[i].length()-1);
			System.out.println(sb[i].toString());
		}
	}

	private static void findAnswer(int depth, int start, int end) {
//		System.out.println("test "+start+" -> "+end);
		int idx = start==end? start : (start+end)/2;
//		System.out.println("-> "+idx);
		if(idx<1 || idx > L) return;
		
		sb[depth].append(visited[idx]).append(" ");
		
		if(start < idx )
			findAnswer(depth+1, start,idx-1);
		if(start != idx && idx <= end)
			findAnswer(depth+1, idx+1, end);
	}

}
