import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    static int N, M;
    static Vector<Point> list;
    static int cctvLen;
    static int min = Integer.MAX_VALUE;
    static final int[] direction = {0, 4, 2, 4, 4, 1};

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new Vector<Point>();
        int emptyPlace = 0;
        int [][] map = new int[N+1][M+1];

        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6)
                    list.add(new Point(j, i));
                else if(map[i][j] == 0) emptyPlace++;
            }
        }

        cctvLen = list.size();
        if(cctvLen != 0) {
            solution(0, map);
            System.out.println(min);
        } else
            System.out.println(emptyPlace);
        br.close();
    }

    private static void solution(int index, int[][] prevMap){
        Point cur = list.get(index);
        int cur_x = cur.x;
        int cur_y = cur.y;
        int type = prevMap[cur_y][cur_x];
        for(int i=0; i< direction[type]; ++i) {
            int[][] map = new int[N+1][M+1];
            for (int k = 0; k < N; ++k) map[k] = Arrays.copyOf(prevMap[k], M+1);

            if (map[cur_y][cur_x] == 1) {
                if (i == 0) { // right
                    for (int x = cur_x + 1; x < M; ++x) {
                        if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                        else if (map[cur_y][x] == 6) break;
                    }
                } else if (i == 1) { // up
                    for (int y = cur_y - 1; y >= 0; --y) {
                        if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                        else if (map[y][cur_x] == 6) break;
                    }
                } else if (i == 2) {
                    for (int x = cur_x - 1; x >= 0; --x) {
                        if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                        else if (map[cur_y][x] == 6) break;
                    }
                } else {
                    for (int y = cur_y + 1; y < N; ++y) {
                        if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                        else if (map[y][cur_x] == 6) break;
                    }
                }
            } else if (map[cur_y][cur_x] == 2) {
                if (i == 0) {
                    for (int x = cur_x + 1; x < M; ++x) {
                        if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                        else if (map[cur_y][x] == 6) break;
                    }
                    for (int x = cur_x - 1; x >= 0; --x) {
                        if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                        else if (map[cur_y][x] == 6) break;
                    }
                } else {
                    for (int y = cur_y - 1; y >= 0; --y) {
                        if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                        else if (map[y][cur_x] == 6) break;
                    }
                    for (int y = cur_y + 1; y < N; ++y) {
                        if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                        else if (map[y][cur_x] == 6) break;
                    }
                }
            } else if(map[cur_y][cur_x] == 3) {
                if( i == 0 ) {
                    for (int x = cur_x + 1; x < M; ++x) {
                        if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                        else if (map[cur_y][x] == 6) break;
                    }
                    for (int y = cur_y - 1; y >= 0; --y) {
                        if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                        else if (map[y][cur_x] == 6) break;
                    }
                } else if ( i == 1 ) {
                    for (int x = cur_x - 1; x >= 0; --x) {
                        if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                        else if (map[cur_y][x] == 6) break;
                    }
                    for (int y = cur_y - 1; y >= 0; --y) {
                        if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                        else if (map[y][cur_x] == 6) break;
                    }
                } else if( i == 2 ) {
                    for (int x = cur_x - 1; x >= 0; --x) {
                        if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                        else if (map[cur_y][x] == 6) break;
                    }
                    for (int y = cur_y + 1; y < N; ++y) {
                        if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                        else if (map[y][cur_x] == 6) break;
                    }
                } else {
                    for (int x = cur_x + 1; x < M; ++x) {
                        if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                        else if (map[cur_y][x] == 6) break;
                    }
                    for (int y = cur_y + 1; y < N; ++y) {
                        if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                        else if (map[y][cur_x] == 6) break;
                    }
                }
            } else if(map[cur_y][cur_x] == 4) {
                if( i == 0 ) {
                    for (int x = cur_x + 1; x < M; ++x) {
                        if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                        else if (map[cur_y][x] == 6) break;
                    }
                    for (int y = cur_y - 1; y >= 0; --y) {
                        if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                        else if (map[y][cur_x] == 6) break;
                    }
                    for (int x = cur_x - 1; x >= 0; --x) {
                        if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                        else if (map[cur_y][x] == 6) break;
                    }
                } else if( i == 1 ) {
                    for (int y = cur_y - 1; y >= 0; --y) {
                        if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                        else if (map[y][cur_x] == 6) break;
                    }
                    for (int x = cur_x - 1; x >= 0; --x) {
                        if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                        else if (map[cur_y][x] == 6) break;
                    }
                    for (int y = cur_y + 1; y < N; ++y) {
                        if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                        else if (map[y][cur_x] == 6) break;
                    }
                } else if( i == 2 ) {
                    for (int x = cur_x + 1; x < M; ++x) {
                        if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                        else if (map[cur_y][x] == 6) break;
                    }
                    for (int y = cur_y + 1; y < N; ++y) {
                        if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                        else if (map[y][cur_x] == 6) break;
                    }
                    for (int x = cur_x - 1; x >= 0; --x) {
                        if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                        else if (map[cur_y][x] == 6) break;
                    }
                } else {
                    for (int y = cur_y - 1; y >= 0; --y) {
                        if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                        else if (map[y][cur_x] == 6) break;
                    }
                    for (int x = cur_x + 1; x < M; ++x) {
                        if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                        else if (map[cur_y][x] == 6) break;
                    }
                    for (int y = cur_y + 1; y < N; ++y) {
                        if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                        else if (map[y][cur_x] == 6) break;
                    }
                }
            } else {
                for(int x = cur_x + 1; x < M; ++x) {
                    if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                    else if(map[cur_y][x] == 6) break;
                }
                for(int y = cur_y + 1; y < N; ++y) {
                    if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                    else if(map[y][cur_x] == 6) break;
                }
                for(int x = cur_x - 1; x >= 0; --x) {
                    if (map[cur_y][x] == 0) map[cur_y][x] = 9;
                    else if(map[cur_y][x] == 6) break;
                }
                for(int y = cur_y - 1; y >= 0; --y) {
                    if (map[y][cur_x] == 0) map[y][cur_x] = 9;
                    else if(map[y][cur_x] == 6) break;
                }
            }

            if(index >= cctvLen - 1) min = Math.min(min, totalRemainSize(map));
            else solution(index + 1, map);
        }
    }

    private static int totalRemainSize(int[][] map) {
        int remainSize = 0;
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < M; ++j)
                if (map[i][j] == 0) remainSize++;

        return remainSize;
    }

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
