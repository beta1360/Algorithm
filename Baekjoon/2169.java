import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] mapValue;
    static int[][] dp;
    static int[][][] tempDP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        mapValue = new int[1003][1003];
        dp = new int[1003][1003];
        tempDP = new int[2][1003][1003];
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) 
                mapValue[i][j] = Integer.parseInt(st.nextToken());
        }

        dp[1][1] = mapValue[1][1];

        for (int j = 2; j <= M; j++)
            dp[1][j] += dp[1][j - 1] + mapValue[1][j];
        
        for (int i = 2; i <= N; i++) {
            tempDP[0][i][1] = dp[i - 1][1] + mapValue[i][1];
            for (int j = 2; j <= M; j++) 
                tempDP[0][i][j] = Math.max(dp[i - 1][j], tempDP[0][i][j - 1]) + mapValue[i][j];
            
            tempDP[1][i][M] = dp[i - 1][M] + mapValue[i][M];
            for (int j = M - 1; j >= 1; j--) 
                tempDP[1][i][j] = Math.max(dp[i - 1][j], tempDP[1][i][j + 1]) + mapValue[i][j];
            
            for (int j = 1; j <= M; j++) 
                dp[i][j] = Math.max(tempDP[0][i][j], tempDP[1][i][j]);
        }
        System.out.println(dp[N][M]);
        br.close();
    } 
}
