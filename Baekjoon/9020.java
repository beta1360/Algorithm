import java.util.Scanner;

public class Main {
	static boolean[] eratos = new boolean[10001];
	public static void main(String[] argc) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		get_eratos();
		
		for(int t=0; t<T; t++) {
			int N = sc.nextInt();
			int n = N/2;
			int a=0; int b=N;
			for(int i=n; i>= 2; i--) {
				a = i;
				b = N-i;
				if(!eratos[a] && !eratos[b])
					break;
			}
			
			System.out.println(a+" "+b);
		}

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
