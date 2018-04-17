import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] A;
	
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		A = new int[N];
		
		for(int i=0; i<A.length; i++)
			A[i] = sc.nextInt();
	
		Arrays.sort(A);
		int result = A[0]*A[N-1];
		
		System.out.println(result);
	}
}
