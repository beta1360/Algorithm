import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int dx[] = {1, 0, -1, 0};
    private static final int dy[] = {0, 1, 0, -1};

    private static int R, C, T;
    private static int map[][];
    private static int ty, by;
    private static Queue<Point> q = new LinkedList<>();

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        boolean isDetected = false;
        for(int r=0; r<R; ++r) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < C; ++c) {
                map[r][c] = Integer.parseInt(st.nextToken());

                if(map[r][c] == -1 && !isDetected){
                    ty = r; by = r+1;
                    isDetected = true;
                } else if (map[r][c] != 0){
                    q.offer(new Point(c, r));
                }

            }
        }

        br.close();

        for(int t=0; t<T; ++t){
            spreadDust();
            onCleaner();
            offerDustPlace();
        }

        System.out.println(remainDust());
    }

    private static void spreadDust(){
        int dust[][] = new int[R][C];

        while(!q.isEmpty()){
            Point cur = q.poll();
            int cnt = 0;

            for(int d=0; d<4; ++d){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (!(ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] < 0)){
                    cnt++;
                    dust[ny][nx] += map[cur.y][cur.x] / 5;
                }
            }

            dust[cur.y][cur.x] += map[cur.y][cur.x] - (map[cur.y][cur.x]/5) * cnt;
        }

        copyMap(dust);
    }

    private static void copyMap(int dust[][]){
        for(int r=0; r<R; ++r)
            System.arraycopy(dust[r], 0, map[r], 0, C);

        map[ty][0] = map[by][0] = -1;
    }

    private static void onCleaner(){
        // 청소기에서 나가는 바람
        map[ty][0] = map[by][0] = 0;

        // 청소기 상단(반시계)
        for (int i = ty; i >= 1; i--) map[i][0] = map[i - 1][0];
        map[ty][0] = 0;
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
        for (int i = 0; i < ty; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int i = 0; i < C - 1; i++) map[ty][C - 1 - i] = map[ty][C - 2 - i];

        // 청소기 하단(시계)
        for (int i = by; i < R - 1; i++) map[i][0] = map[i + 1][0];
        map[by][0] = 0;
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i >= by + 1; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i >= 1; i--) map[by][i] = map[by][i - 1];

        // 청소기 현위치
        map[ty][0] = map[by][0] = -1;
    }

    private static void offerDustPlace(){
        for(int i=0; i<R; ++i)
            for(int j=0; j<C; ++j)
                if(map[i][j] > 0)
                    q.offer(new Point(j, i));
    }

    private static int remainDust(){
        int sum = 0;

        while(!q.isEmpty()){
            Point cur = q.poll();
            sum += map[cur.y][cur.x];
        }
        
        return sum;
    }

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
