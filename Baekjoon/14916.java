package p14916;

import java.util.Scanner;

public class Main {
	static int[] change = new int[] {5, 2};
	
	static int min = Integer.MAX_VALUE;
	static int cur;
	
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		cur = sc.nextInt();
		
		int temp = (int)(cur/change[0]);
		
		for(int i=0; i<=temp; i++) {
			int sub = cur - change[0]*i;
			int coin = i;
			if(sub % change[1] == 0) {
				coin += (int)(sub/change[1]);
				if(coin < min) min = coin;
			}
		}
    if(min != Integer.MAX_VALUE)
		  System.out.print(min);
    else
      System.out.print("-1");
		sc.close();
	}
}
