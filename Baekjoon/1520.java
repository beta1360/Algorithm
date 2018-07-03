import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int arr[][];
    static int dp[][];

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    // UP, RIGHT, DOWN, LEFT

    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        dp = new int[M][N];

        for(int m=0; m<M; m++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            for (int n = 0; n < N; n++) {
                arr[m][n] = Integer.parseInt(st.nextToken());
                dp[m][n] = -1;
            }
        }

        System.out.println(dfs(0,0));
        br.close();
    }

    private static int dfs(int x, int y) {
        if ((y == (M - 1)) && (x == (N - 1)))
            return 1;

        if (dp[y][x] != -1)
            return dp[y][x];

        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if ((nx >= 0) && (nx < N) && (ny >= 0) && (ny < M))
                if (arr[y][x] > arr[ny][nx])
                    dp[y][x] += dfs(nx, ny);
        }
        return dp[y][x];
    }
}
