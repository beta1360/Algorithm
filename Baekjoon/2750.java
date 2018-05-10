import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; )
			arr[i++] = sc.nextInt();
		
		Arrays.sort(arr);
		
		for(int i=0; i<N; ) 
			System.out.println(arr[i++]);
		
		sc.close();
	}
}
