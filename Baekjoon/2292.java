import java.util.Scanner;
/*
 * 1  :  1 
 * 6  :  2 ~ 7
 * 12 :  8 ~ 19
 * 18 : 20 ~ 37
 * 24 : 38 ~ 61
 */


public class Main {
	static long N;
	static int cnt = 1;
	
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int i = 1;
		while(i < N) {
			i += 6*cnt;
			cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
}
