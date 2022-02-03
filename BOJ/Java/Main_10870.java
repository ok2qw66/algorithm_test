import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static int[] fibo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		fibo = new int[21];
		fibo[1] = 1;
		fibo[2] = 1;
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(findFibo(N));
	}

	private static int findFibo(int n) {
		if(n<2) return fibo[n];
		return findFibo(n-1) + findFibo(n-2);
	}

	

}

