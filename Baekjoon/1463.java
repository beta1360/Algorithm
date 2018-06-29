import java.util.Scanner;

public class Main {
    static int N;
    static int dp[];

    public static void main(String[] argc){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        dp = new int[N+1];

        dp[N] = 0;

        for(int i=N; i>=1; i--){
            if((i%3 == 0) && (dp[i/3] != 0))
                dp[i/3] = Math.min(dp[i/3], dp[i]+1);
            else if((i%3 == 0) && (dp[i/3] == 0)) dp[i/3] = dp[i]+1;

            if((i%2 == 0) && (dp[i/2] != 0))
                dp[i/2] = Math.min(dp[i/2], dp[i]+1);
            else if((i%2 == 0) && (dp[i/2] == 0)) dp[i/2] = dp[i]+1;

            if(dp[i-1] != 0)
                dp[i-1] = Math.min(dp[i-1], dp[i]+1);
            else if(dp[i-1] == 0) dp[i-1] = dp[i]+1;
        }

        System.out.println(dp[1]);
    }
}
