import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] argc){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        dp = new int[N][2];

        for(int i=0; i<N; ++i)
            arr[i] = sc.nextInt();
        sc.close();

        dp[0][1] = arr[0];

        dp[1][0] = dp[0][1];
        dp[1][1] = dp[0][1] + arr[1];

        for(int i=2; i<N; i++){
            dp[i][0] = dp[i-1][1];
            dp[i][1] = Math.max(dp[i-2][0]+arr[i-1], dp[i-2][1]) + arr[i];
        }
        System.out.println(dp[N-1][1]);
    }
}
