import java.util.Scanner;

public class Main {
	static boolean[] eratos = new boolean[1001];
	public static void main(String[] argc) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		int N = sc.nextInt();
		
		eratos[1] = true;
		
		get_eratos();
		
		for(int i=0; i<N; i++)
			if(!eratos[sc.nextInt()])
				result++;
		
		System.out.println(result);
		
		sc.close();
	}
	
	public static void get_eratos() {
		for(int i=2; i<1001; i++) {
			if(!eratos[i]) {
				for(int j=i+i; j < 1001; j += i)
					eratos[j] = true;
			}
			else // eratos[i] = true; 
				continue;
		}
	}
}
