import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int map[][];
    static ArrayList<Point> list;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        list = new ArrayList<Point>();

        for(int i=1; i<=N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
                // 치킨집을 리스트에 모두 넣어준다.
                if(map[i][j] == 2) list.add(new Point(j, i));
            }
        }

        // 치킨집과 가정집의 거리를 위한 배열이며, 최대값으로 초기화
        int dist[][] = new int[N+1][N+1];
        for(int i=1; i<=N; ++i) Arrays.fill(dist[i], Integer.MAX_VALUE);

        // 탐색한다.
        search(0, 0 , dist);
        System.out.println(min);
        br.close();
    }

    // param::
    // next(int)     : 현재 탐색중인 치킨집
    // cnt(int)      : 최대 치킨집의 갯수를 세기 위한 카운터
    // prev(int[][]) : 이전 거리값을 저장한 배열
    private static void search(int next, int cnt, int[][] prev) {
        for (int i = next; i < list.size(); ++i) {
            // 현재 거리값을 저장할 dist
            int[][] dist = new int[N + 1][N + 1];

            // 거리 데이터를 복사 후
            for (int k = 1; k <= N; k++)
                dist[k] = Arrays.copyOf(prev[k], N + 1); // deep copy

            // 배열에서 현재 치킨집을 꺼내보고 전체 거리값을 계산해봄
            Point cur = list.get(i);
            int sum = totalDist(cur.x, cur.y, dist);

            // 만약 다음 카운터가 M이면 최소값을 찾고,
            // 아니면 다음 치킨집을 찾아본다.
            if (cnt + 1 == M) min = Math.min(sum, min);
            else search(i + 1, cnt + 1, dist);
        }
    }

    private static int totalDist(int x, int y, int dist[][]) {
        int sum = 0;

        // 전체 거리값은 구한 거리값에서 최소값이면 dist배열에 넣고 더해준다.
        for (int i = 1; i <= N; ++i)
            for (int j = 1; j <= N; ++j) {
                if (map[i][j] == 1) {
                    int d = Math.abs(y - i) + Math.abs(x - j);
                    dist[i][j] = Math.min(dist[i][j], d);
                    sum += dist[i][j];
                }
            }

        return sum;
    }

    static class Point {
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
