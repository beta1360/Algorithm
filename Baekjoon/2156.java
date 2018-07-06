import java.util.Scanner;

public class Main {
    static int wine[];
    static int dp[][];
    static int n;

    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        wine = new int[n];
        dp = new int[n][3];
        
        for(int i=0; i<n; ++i) wine[i] = sc.nextInt();
        sc.close();
        
        dp[0][0] = 0;
        dp[0][1] = wine[0];
        dp[0][2] = wine[0];

        for(int i=1; i<n; ++i){
            dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
            dp[i][1] = dp[i-1][0] + wine[i];
            dp[i][2] = dp[i-1][1] + wine[i];
        }

        System.out.println(Math.max(Math.max(dp[n-1][0], dp[n-1][1]),dp[n-1][2]));
    }
}
