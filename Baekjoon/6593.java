import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L, R, C;
    static final int MAX_DIRECTION = 6;
    static int dx[] = {1, -1, 0, 0, 0, 0};
    static int dy[] = {0, 0, -1, 1, 0, 0};
    static int dz[] = {0, 0, 0, 0, 1, -1};

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        while(L != 0 && R != 0 && C != 0){
            Queue<Point> q = new LinkedList<>();
            Queue<Point> minQ = new LinkedList<>();
            char map[][][] = new char[L][R][C];
            int dp[][][] = new int[L][R][C];
            boolean visit[][][] = new boolean[L][R][C];
            int dst_x = 0, dst_y = 0, dst_z = 0;

            for(int i=0; i<L; ++i)
                for(int j=0; j<R; ++j)
                    Arrays.fill(dp[i][j], Integer.MAX_VALUE);

            for(int i=0; i<L; ++i){
                for(int j=0; j<R; ++j){
                    String line = br.readLine();

                    for(int k=0; k<C; ++k) {
                        map[i][j][k] = line.charAt(k);

                        if(map[i][j][k] == 'S') {
                            visit[i][j][k] = true;
                            dp[i][j][k] = 0;
                            q.offer(new Point(k, j, i));
                        } else if(map[i][j][k] == 'E'){
                            dst_x = k;
                            dst_y = j;
                            dst_z = i;
                        }
                    }
                }
                br.readLine();
            }

            while(!q.isEmpty()){
                while(!q.isEmpty())
                    minQ.offer(q.poll());

                while(!minQ.isEmpty()){
                    Point cur = minQ.poll();

                    for(int i=0; i<MAX_DIRECTION; ++i){
                        int nx = cur.x + dx[i];
                        int ny = cur.y + dy[i];
                        int nz = cur.z + dz[i];

                        if(nx >= 0 && nx < C && ny >=0 && ny < R && nz >=0 && nz < L){
                            if(!visit[nz][ny][nx] && (map[nz][ny][nx] == '.' || map[nz][ny][nx] == 'E')){
                                q.offer(new Point(nx, ny, nz));
                                visit[nz][ny][nx] = true;
                                dp[nz][ny][nx] = Math.min(dp[nz][ny][nx], dp[cur.z][cur.y][cur.x] + 1);
                            }
                        }
                    }
                }
            }

            if(dp[dst_z][dst_y][dst_x] == Integer.MAX_VALUE) System.out.println("Trapped!");
            else System.out.println("Escaped in " + dp[dst_z][dst_y][dst_x] + " minute(s).");

            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    static class Point{
        int x, y, z;

        Point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
