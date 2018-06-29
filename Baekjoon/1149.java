import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int r,g,b;
    static int dp[][];

    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N][3];

        String line[] = br.readLine().split("\\s");
        dp[0][0] = r = Integer.parseInt(line[0]);
        dp[0][1] = g = Integer.parseInt(line[1]);
        dp[0][2] = b = Integer.parseInt(line[2]);

        for(int i=1; i<N; i++){
            line = br.readLine().split("\\s");
            r = Integer.parseInt(line[0]);
            g = Integer.parseInt(line[1]);
            b = Integer.parseInt(line[2]);

            dp[i][0] = Math.min(dp[i-1][1]+r, dp[i-1][2]+r);
            dp[i][1] = Math.min(dp[i-1][0]+g, dp[i-1][2]+g);
            dp[i][2] = Math.min(dp[i-1][0]+b, dp[i-1][1]+b);
        }

        int min = dp[N-1][0];
        min = Math.min(min, dp[N-1][1]);
        min = Math.min(min, dp[N-1][2]);
        System.out.println(min);

        br.close();
    }
}
