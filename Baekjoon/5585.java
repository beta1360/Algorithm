import java.util.Scanner;

public class Main {
	static int[] change = new int[] {500,100,50,10,5,1};
	
	static int INPUT = 1000;
	static int coin = 0;
	static int price;
	
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		int cur = INPUT - sc.nextInt();
		
		int i = 0;
		while(cur != 0) {
			int n = (int)(cur/change[i]);
			cur -= change[i++]*n;
			coin += n;
		}
		System.out.print(coin);
		sc.close();
	}
}
