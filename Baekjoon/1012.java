import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; ++i)
            System.out.println(testCase(br));
        br.close();
    }

    private static int testCase(BufferedReader br) throws IOException {
        int min = 0;
        int M, N, K;
        boolean[][] map;
        boolean[][] visit;
        Queue<Point> q = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<K; ++i){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[y][x] = true;
        }

        for(int i=0; i<N; ++i){
            for(int j=0; j<M; ++j){
                if(map[i][j] && !visit[i][j]) {
                    min++;
                    visit[i][j] = true;
                    q.offer(new Point(j, i));

                    while(!q.isEmpty()){
                        Point cur = q.poll();

                        for(int d=0; d<4; ++d){
                            int nx = cur.x + dx[d];
                            int ny = cur.y + dy[d];

                            if((nx >= 0) && (nx < M) && (ny >= 0) && (ny < N)){
                                if(!visit[ny][nx] && map[ny][nx]){
                                    q.offer(new Point(nx, ny));
                                    visit[ny][nx] = true;
                                 }
                            }
                        }
                    }
                }
            }
        }

        return min;
    }

    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
