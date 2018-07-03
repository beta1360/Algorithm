import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static int n,m;
    static BigInteger dp[];
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        dp = new BigInteger[n+1];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");

        for(int i=2; i<=n; ++i)
            dp[i] = new BigInteger(dp[i-1].multiply(new BigInteger(Integer.toString(i))).toString());

        BigInteger result = dp[n].divide(dp[m]).divide(dp[n-m]);
        System.out.println(result);

        sc.close();
    }
}
