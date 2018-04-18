import java.util.Scanner;

public class Main {
	static int N;
	static int cnt = 99;
	static int[] n = new int[3];
	
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		if(N < 100) 
			System.out.println(N);
		else  {
			for(int i=100; i<=N; i++) {
				if(i == 1000) break;
	
				int index = i;
				n[0]=(int)(index/100); index%=100;
				n[1]=(int)(index/10); index%=10;
				n[2]=index;
				
				if((n[0]-n[1])==(n[1]-n[2]))  cnt++;
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
