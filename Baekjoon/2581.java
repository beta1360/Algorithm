import java.util.Scanner;

public class Main {
	static boolean[] eratos = new boolean[10001];
	public static void main(String[] argc) {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		int min;
		int sum = 0;
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		eratos[1] = true;
		
		get_eratos();
		
		min = N;
		
		for(int i=M; i<=N; i++) {
			if(!eratos[i]) {
				sum += i;
				if(!flag) {
					flag = true;
					min = i;
				}	
			}
		}
		
		if(sum != 0) {
			System.out.println(sum);
			System.out.println(min);
		} else 
			System.out.println("-1");

		sc.close();
	}
	
	public static void get_eratos() {
		for(int i=2; i<10001; i++) {
			if(!eratos[i]) {
				for(int j=i+i; j < 10001; j += i)
					eratos[j] = true;
			}
			else // eratos[i] = false; 
				continue;
		}
	}
}
