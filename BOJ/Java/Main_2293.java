import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		int[] dp = new int[K+1];
		dp[0] = 1;
		
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coins);

		for (int j = 0; j<N && coins[j] <= K; j++) {
			for (int i = coins[j]; i <= K; i++) {
				dp[i] += dp[i-coins[j]];
			}
		}
		
		
		System.out.println(dp[K]);
	}


}

