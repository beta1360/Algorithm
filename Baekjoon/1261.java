import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] dp;
    static final int dx[] = {0, 1, 0, -1};
    static final int dy[] = {1, 0, -1, 0};

    public static void main(String[] argv) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M+1][N+1];
        dp = new int[M+1][N+1];

        for(int i=1; i<=M; ++i) {
            String line = br.readLine();

            for(int j=1; j<=N; ++j)
                map[i][j] = line.charAt(j-1);
        }

        for(int i=1; i<=M; ++i)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(1,1));
        dp[1][1] = 0;

        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i=0; i<4; ++i){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M){
                    if(map[ny][nx] == '1'){
                        if(dp[ny][nx] > dp[cur.y][cur.x] + 1){
                            dp[ny][nx] = dp[cur.y][cur.x] + 1;
                            q.offer(new Point(nx, ny));
                        }
                    } else if(map[ny][nx] == '0'){
                        if(dp[ny][nx] > dp[cur.y][cur.x]){
                            dp[ny][nx] = dp[cur.y][cur.x];
                            q.offer(new Point(nx, ny));
                        }
                    }
                }
            }
        }

        bw.write(dp[M][N] +"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
