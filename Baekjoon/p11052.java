import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] p;
    static int[] dp;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        p = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; ++i)
            p[i] = Integer.parseInt(st.nextToken());

        dp[1] = p[1];

        for(int i=1; i<=N; ++i)
            for(int j=1; j<=i; ++j)
                dp[i] = Math.max(dp[i], dp[i-j] + p[j]);

        System.out.println(dp[N]);
        br.close();
    }
}
