import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int check = 0;
    static boolean flag = false;
    static int before;
    static int count = 0;
    static int M, N;
    static int map[][];
    static int day = 0;
    static boolean visit[][];
    static Queue<Point> q;
    static Queue<Point> day_q;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {-1, 0, 1, 0};

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        q = new LinkedList<Point>();
        day_q = new LinkedList<Point>();

        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    count++;
                    visit[i][j] = true;
                    q.offer(new Point(j, i));
                } else if(map[i][j] == -1)
                    check--;
            }
        }

        check += N*M;

        while(!q.isEmpty()){
            before = count;
            while(!q.isEmpty())
                day_q.offer(q.poll());

            while(!day_q.isEmpty())
                set_tomato(day_q.poll());
            
            if(!q.isEmpty()) day++;
            if((count == before) && (count != check)) {
                flag = true;
                break;
            }
        }

        if(flag) System.out.println(-1);
        else System.out.println(day);
        br.close();
    }

    public static void set_tomato(Point p){
        for(int i=0; i<4; i++){
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];

            if((nx >=0) && (nx < M) && (ny >=0) && (ny < N)
                    && !visit[ny][nx] && map[ny][nx] == 0){
                visit[ny][nx] = true;
                map[ny][nx] = 1;
                q.offer(new Point(nx,ny));
                count++;
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
