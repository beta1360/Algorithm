import java.util.Scanner;

public class Main {
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T != 0) {
			eratos(T);
			T = sc.nextInt();
		}
		
		sc.close();
	}
	
	private static void eratos(int T) {
		boolean[] check = new boolean[2*T+1];
		check[0] = false;
		check[1] = false;
		
		for(int i=2; i<=2*T; i++) 
			check[i] = true;
		
		for(int i=2; i<= Math.sqrt(2*T); i++) {
			if(check[i])
				for(int j= i*i; j<=2*T; j+=i)
					check[j] = false;
		}
		
		int result = 0;
		
		for(int i=T+1; i<2*T+1; i++)
			if(check[i]) result++;
		System.out.println(result);
	}
}
