import java.util.Scanner;

public class Main {
    static long fibo[] = new long[91];
    static int n;

    public static void main(String[] argc){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        fibo[0] = 0;
        fibo[1] = 1;

        for(int i=1; i<n; i++)
            fibo[i+1] = fibo[i] + fibo[i-1];

        System.out.println(fibo[n]);
        sc.close();
    }
}
