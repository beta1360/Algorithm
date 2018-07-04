import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static int N;
    static BigInteger dp[][];

    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        dp = new BigInteger[N+1][10];

        if(N == 1){
            System.out.println(9);
            return;
        }  else {
            // initialize
            BigInteger result = BigInteger.ZERO;
            dp[2][0] = new BigInteger("1");
            dp[2][1] = new BigInteger("1");
            for(int i=2; i<9; ++i) dp[2][i] = new BigInteger("2");
            dp[2][9] = new BigInteger("1");

           for(int i=3; i<=N; ++i){
               for(int j=0; j<10; ++j){
                   if(j == 0) dp[i][j] = dp[i-1][1];
                   else if(j == 9) dp[i][j] = dp[i-1][8];
                   else dp[i][j] = dp[i-1][j-1].add(dp[i-1][j+1]);
               }
           }

           for(int i=0; i<10; ++i) result = result.add(dp[N][i]);
           System.out.println(result.mod(new BigInteger("1000000000")));
        }
    }
}
