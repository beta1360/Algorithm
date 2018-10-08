import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int H;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H+2][N+1];

        for(int i=0; i<M; ++i){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = x+1;
            map[y][x+1] = x;
        }

        if(isEqualWithDest(map))
            System.out.println(0);

        else {
            solution(1, map);
            if(min == Integer.MAX_VALUE) System.out.println(-1);
             else System.out.println(min);
        }

        br.close();
    }

    private static void solution(int n, int[][] prevMap){
        if(n > 3) return;

        int[][] map = new int[H+2][N+1];

        for(int i=0; i<=H+1; ++i)
            map[i] = Arrays.copyOf(prevMap[i], N+1);

        for(int i=1; i<=H; ++i){
            for(int j=1; j<N; ++j){
                if(map[i][j] == 0 && map[i][j+1] == 0) {
                    map[i][j] = j+1;
                    map[i][j+1] = j;

                    if (!isEqualWithDest(map)) solution(n + 1, map);
                    else min = Math.min(min, n);

                    map[i][j+1] = map[i][j] = 0;
                }
            }
        }
    }

    private static boolean isEqualWithDest(int[][] map){
        int dest[] = new int[N];
        int cnt = 0;

        for(int i=0; i<N; ++i) {
            dest[i] = getDest(i+1, map);
            if(dest[i] == i+1) cnt++;
        }

        return cnt == N;
    }

    private static int getDest(int start, int[][] map){
        int x = start;

        for(int i=1; i<=H+1; ++i)
            if(map[i][x] != 0) x = map[i][x];

        return x;
    }
}
