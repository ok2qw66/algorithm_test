import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextInt();
		long y = sc.nextInt();
		long res = 1;
		long diff = 0;
		if(y == 0) diff = 1;
		
		for (long i = 1; i < x + y + diff; i++)
			res += 6 * i;
		
		System.out.println(res+y);

	}
}
