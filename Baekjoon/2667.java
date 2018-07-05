import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static String[] map;
    static boolean visit[][];
    static int cnt = 0;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {-1, 0, 1, 0};
    static Queue<Point> q;
    static Vector<Integer> v;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = new LinkedList<Point>();
        v = new Vector<Integer>();
        N = Integer.parseInt(br.readLine());

        map = new String[N];
        visit = new boolean[N][N];

        for(int i=0; i<N; ++i) map[i] = br.readLine();

        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                if((map[i].charAt(j) == '1') && !visit[i][j]){
                    v.add(BFS(j, i));
                    ++cnt;
                }
            }
        }

        Collections.sort(v);
        System.out.println(cnt);
        for(int i=0; i<cnt; ++i) System.out.println(v.get(i));

        br.close();
    }

    private static int BFS(int start_x, int start_y){
        int count = 0;
        q.offer(new Point(start_x, start_y));
        visit[start_y][start_x] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();
            count++;

            for(int i=0; i<4; ++i){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if((nx >= 0) && (nx < N) && (ny >= 0) && (ny < N)){
                    if(!visit[ny][nx] && (map[ny].charAt(nx) == '1')){
                        visit[ny][nx] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }

        return count;
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
