import java.util.Scanner;

public class Main {
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] check = new int[9];
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<check.length;) check[i++] = 0;
		
		if (n == 0) System.out.println(1);
		else {
			while(n > 0) {
				int temp = n % 10;
				if(temp == 9)
					check[6]++;
				else 
					check[temp]++;
				n /= 10;
			}
			
			if(check[6] % 2 == 0)
				check[6] /= 2;
			else 
				check[6] = check[6]/2 + 1;
			
			for(int i=0; i<check.length; i++) 
				if(check[i] > max) max = check[i];
			
			System.out.println(max);
		}
		sc.close();
	}
}
