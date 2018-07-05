import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M,N;
    static String[] map;
    static boolean visit[][];
    static Queue<Point> q;
    static int dp[][];
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = new LinkedList<Point>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new String[M];
        visit = new boolean[M][N];
        dp = new int[M][N];

        for(int i=0; i<M; ++i) map[i] = br.readLine();

        bfs(0,0);
        System.out.println(dp[M-1][N-1]);

        br.close();
    }

    private static void bfs(int start_x, int start_y){
        visit[start_y][start_x] = true;
        dp[start_y][start_x] = 1;
        q.offer(new Point(start_x, start_y));

        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i=0; i<4; ++i) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if((nx >=0) && (nx < N) && (ny >=0) && (ny < M)){
                    if(map[ny].charAt(nx) == '1') {
                        if (!visit[ny][nx]) {
                            dp[ny][nx] = dp[cur.y][cur.x] + 1;
                            visit[ny][nx] = true;
                            q.offer(new Point(nx, ny));
                        } else
                            dp[ny][nx] = Math.min(dp[cur.y][cur.x] + 1, dp[ny][nx]);
                    }
                }
            }
        }
    }

    public static class Point{
        public int x;
        public int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
