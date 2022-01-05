package jan_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3613 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		
		if(word.contains("_"))
			changeToJava(word);
		else
			changeToC(word);
	}

	private static void changeToJava(String word) {
		StringBuilder sb = new StringBuilder();
		char[] test = word.toCharArray();
		boolean isCapital = false;
		
		if(test[0]=='_') {
			System.out.println("Error!");
			return;
		}
		
		for (char c : test) {
			if((c >= 'A' && c <='Z') || (isCapital && c == '_')) {
				System.out.println("Error!");
				return;
			}else if(!isCapital && c == '_'){
				isCapital = true;
			}else if(isCapital && c != '_'){
				isCapital = false;
				char t = (char) (c-32);
				sb.append(Character.toString(t));
			}else {
				sb.append(c);
			}
		}
		
		if(isCapital) {
			System.out.println("Error!");
			return;
		}
		
		System.out.println(sb.toString());
	}

	private static void changeToC(String word) {
		StringBuilder sb = new StringBuilder();
		char[] test = word.toCharArray();
		
		if(test[0] >= 'A' && test[0]<='Z'){
			System.out.println("Error!");
			return;
		}
		
		for (char c : test) {
			if(c >= 'A' && c<='Z') {
				sb.append("_");
				char t = (char)(c+32);
				sb.append(Character.toString(t));
			}else {
				sb.append(c);
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
