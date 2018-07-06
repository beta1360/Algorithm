import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean visit[][];
    static int map[][];
    static long dp[][];

    static final int dx[] = {0, 1};
    static final int dy[] = {1, 0};
    static final int MAX_DIRECTION = 2;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        dp = new long[N+1][N+1];
        visit = new boolean[N+1][N+1];

        for(int i=1; i<=N; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; ++j)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dp[1][1]++;

        for(int i=1; i<=N; ++i){
            for(int j=1; j<=N; ++j){
                if((map[i][j] == 0) || ((i == N ) && (j == N))) continue;
                
                for(int d=0; d<MAX_DIRECTION; ++d){
                    int nx = j + dx[d] * map[i][j];
                    int ny = i + dy[d] * map[i][j];

                    if((nx <= N) && (ny <= N)) 
                        dp[ny][nx] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N][N]) ;

        br.close();
    }
}
