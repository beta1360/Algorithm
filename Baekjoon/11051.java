import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static int N, K;
    static BigInteger dp[];
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        dp = new BigInteger[N+1];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");

        BigInteger tmp;
        for(int i=2; i<=N; i++){
            tmp = new BigInteger(Integer.toString(i));
            dp[i] = new BigInteger(dp[i-1].multiply(tmp).toString());
        }

        System.out.println(dp[N].divide(dp[K]).divide(dp[N-K]).mod(new BigInteger("10007")));
        sc.close();
    }
}
