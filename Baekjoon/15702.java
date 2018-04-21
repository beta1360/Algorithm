import java.util.Scanner;

public class Main {
	static int N,M;
	static String[] p;
	static int[] point;
	static int[] sum;
	
	static int max = Integer.MIN_VALUE;
	static int max_index = Integer.MAX_VALUE;
	
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		
		p = new String[N]; point = new int[N];
		sum = new int[M+1];
		
		for(int i=0; i<N;) point[i++] = sc.nextInt();
		for(int i=0; i<M+1; ) sum[i++] = 0; 
		
		for(int i=0; i<M; i++) {
			int student = sc.nextInt();
			for(int j=0; j<N; j++) {
				p[j] = sc.next();
				if(p[j].equals("O"))
					sum[i] += point[j];
			}
			if(sum[i] > max) {
				max = sum[i];
				max_index = student;
			}
			if((sum[i] == max) && (student < max_index))
				max_index = student;
		}
		
		System.out.println(max_index+" "+max);
		sc.close();
	}
}
