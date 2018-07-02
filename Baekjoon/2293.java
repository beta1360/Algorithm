import java.util.Scanner;

public class Main {
    static int n;
    static int k;
    static int coin[];
    static int dp[];

    public static void main(String[] argc){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        coin = new int[n];
        dp = new int[k+1];

        for(int i=0; i<n; i++)
            coin[i] = sc.nextInt();

        dp[0] = 1;
        for(int i=0; i<n; i++)
            for(int j=coin[i]; j<=k; j++)
                dp[j] += dp[j-coin[i]];

        System.out.println(dp[k]);
        sc.close();
    }
}
