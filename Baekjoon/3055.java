import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static boolean hVisit[][];
    static boolean wVisit[][];
    static int hog[][];
    static Point dest;
    static String map[];
    static Queue<Point> hq;
    static Queue<Point> htq;
    static Queue<Point> wq;
    static Queue<Point> wtq;
    static final int MAX_DIRECTION = 4;
    static final int dx[] = {0, 1, 0, -1};
    static final int dy[] = {1, 0, -1, 0};
    static boolean isExit;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R];
        hog = new int[R][C];
        hVisit = new boolean[R][C];
        wVisit = new boolean[R][C];
        hq = new LinkedList<Point>();
        htq = new LinkedList<Point>();
        wq = new LinkedList<Point>();
        wtq = new LinkedList<Point>();

        for(int i=0; i<R; ++i)
            map[i] = br.readLine();

        for(int i=0; i<R; ++i){
            for(int j=0; j<C; ++j){
                if(map[i].charAt(j) == 'D')
                    dest = new Point(j, i);
                else if(map[i].charAt(j) == 'S')
                    hq.offer(new Point(j, i));
                else if(map[i].charAt(j) == '*')
                    wtq.offer(new Point(j, i));
            }
        }

        while(!hq.isEmpty()) {
            while(!wq.isEmpty()) wtq.offer(wq.poll());

            while(!wtq.isEmpty()){
                Point wCur = wtq.poll();
                for(int i=0; i<MAX_DIRECTION; ++i){
                    int nx = wCur.x + dx[i];
                    int ny = wCur.y + dy[i];

                    if((nx >= 0) && (nx < C) && (ny >= 0) && (ny < R)){
                        if(!wVisit[ny][nx]
                                && (map[ny].charAt(nx) != 'X')
                                && (map[ny].charAt(nx) != 'D')){
                            wVisit[ny][nx] = true;
                            wq.offer(new Point(nx, ny));
                        } // end condition
                    } // end if
                } // end for
            } // end water phase

            while(!hq.isEmpty()) htq.offer(hq.poll());

            while(!htq.isEmpty()) {
                Point hCur = htq.poll();
                for (int i = 0; i < MAX_DIRECTION; ++i) {
                    int nx = hCur.x + dx[i];
                    int ny = hCur.y + dy[i];

                    if ((nx >= 0) && (nx < C) && (ny >= 0) && (ny < R)) {
                        if (!hVisit[ny][nx] && !wVisit[ny][nx]
                                && (map[ny].charAt(nx) != 'X')
                                && (map[ny].charAt(nx) != '*')) {
                            hVisit[ny][nx] = true;
                            hog[ny][nx] = hog[hCur.y][hCur.x] + 1;
                            hq.offer(new Point(nx, ny));
                        } // end condition
                    } // end if
                } // end for
            }

            if (hog[dest.y][dest.x] != 0) {
                isExit = true;
                break;
            }
        }

        if(isExit) System.out.println(hog[dest.y][dest.x]);
        else System.out.println("KAKTUS");

        br.close();
    }

    public static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
