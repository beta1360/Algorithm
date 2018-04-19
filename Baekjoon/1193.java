import java.util.Scanner;

public class Main {
	 public static void main(String[] argv) {
		 Scanner sc = new Scanner(System.in);
		 int X = sc.nextInt();
		 int cnt = 0, sum = 0;
		 
		 while(sum < X)  
			 sum += cnt++;
		 
		 int t_cnt = cnt;
		 int n = 1;
		 for(int i= sum-cnt+1; i<X; i++) {
			 cnt--; n++;
		 }
		 if (t_cnt%2 != 0)
			 System.out.println(cnt+"/"+n);
		 else 
			 System.out.println(n+"/"+cnt);
		 sc.close();
	 }
}
