import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int dp[][];

    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][N];

        dp[0][0] = Integer.parseInt(br.readLine());

        for(int i=1; i<N; ++i){
            String[] token = br.readLine().split("\\s");
            for(int j=0; j <= i; ++j) {
                if(j == 0)
                    dp[i][j] = dp[i-1][j] + Integer.parseInt(token[j]);
                else if(j == (i+1))
                    dp[i][j] = dp[i-1][j-1] + Integer.parseInt(token[j]);
                else
                    dp[i][j] = Math.max(dp[i-1][j-1] + Integer.parseInt(token[j])
                            , dp[i-1][j] + Integer.parseInt(token[j]));
            }
        }

        int max = 0;
        for(int i=0; i<N; i++)
            max = Math.max(max, dp[N-1][i]);

        System.out.println(max);
        br.close();
    }
}
