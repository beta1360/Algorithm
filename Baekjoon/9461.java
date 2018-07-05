import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long dp[] = new long[101];
        dp[1] = 1; dp[2] = 1; dp[3]= 1; dp[4] = 2;
 
        for(int i =1; i< T+1; i++) {
            int k = Integer.parseInt(br.readLine());
            if(k > 4)
                for(int j =4; j<=k; j++)
                    dp[j]= dp[j-3]+dp[j-2];
            System.out.println(dp[k]);
        }
    }
}
