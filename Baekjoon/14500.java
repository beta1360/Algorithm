import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static int N, M;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int n=0; n<N; ++n){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; ++m)
                map[n][m] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());

        br.close();
    }

    private static int solution(){
        int max = tetromino_I();

        max = Math.max(max, tetromino_O());
        max = Math.max(max, tetromino_L());
        max = Math.max(max, tetromino_Z());

        return Math.max(max, tetromino_T());
    }

    private static int tetromino_I(){
        int max = 0;

        // type 1 :ㅣ
        for(int i=0; i<N-3; ++i)
            for(int j=0; j<M; ++j)
                max = Math.max(max, map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j]);

        // type 2 : ㅡ
        for(int i=0; i<N; ++i)
            for(int j=0; j<M-3; ++j)
                max = Math.max(max, map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3]);

        return max;
    }

    private static int tetromino_O(){
        int max = 0;

        for(int i=0; i<N-1; ++i)
            for(int j=0; j<M-1; ++j)
                max = Math.max(max, map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1]);

        return max;
    }

    private static int tetromino_L(){
        int max = 0;
        // 기본 L
        for(int i=0; i<N-2; ++i)
            for(int j=0; j<M-1; ++j)
                max = Math.max(max, map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1]);

        for(int i=0; i<N-1; ++i)
            for(int j=0; j<M-2; ++j)
                max = Math.max(max, map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+2]);

        for(int i=0; i<N-2; ++i)
            for(int j=0; j<M-1; ++j)
                max = Math.max(max, map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1]);

        for(int i=0; i<N-1; ++i)
            for(int j=0; j<M-2; ++j)
                max = Math.max(max, map[i+1][j] + map[i][j] + map[i][j+1] + map[i][j+2]);

        // 대칭된 L
        for(int i=0; i<N-2; ++i)
            for(int j=0; j<M-1; ++j)
                max = Math.max(max, map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+2][j]);

        for(int i=0; i<N-1; ++i)
            for(int j=0; j<M-2; ++j)
                max = Math.max(max, map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2]);

        for(int i=0; i<N-2; ++i)
            for(int j=0; j<M-1; ++j)
                max = Math.max(max, map[i+2][j] + map[i+1][j] + map[i][j] + map[i][j+1]);

        for(int i=0; i<N-1; ++i)
            for(int j=0; j<M-2; ++j)
                max = Math.max(max, map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2]);

        return max;
    }

    private static int tetromino_Z(){
        int max = 0;
        // 기본 Z
        for(int i=0; i<N-2; ++i)
            for(int j=0; j<M-1; ++j)
                max = Math.max(max, map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1]);

        for(int i=0; i<N-1; ++i)
            for(int j=0; j<M-2; ++j)
                max = Math.max(max, map[i+1][j] + map[i+1][j+1] + map[i][j+1] + map[i][j+2]);

        // 대칭된 Z
        for(int i=0; i<N-2; ++i)
            for(int j=0; j<M-1; ++j)
                max = Math.max(max, map[i][j+1] + map[i+1][j+1] + map[i+1][j] + map[i+2][j]);

        for(int i=0; i<N-1; ++i)
            for(int j=0; j<M-2; ++j)
                max = Math.max(max, map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2]);

        return max;
    }

    private static int tetromino_T(){
        int max = 0;

        for(int i=0; i<N-1; ++i)
            for(int j=0; j<M-2; ++j)
                max = Math.max(max, map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+1]);

        for(int i=0; i<N-2; ++i)
            for(int j=0; j<M-1; ++j)
                max = Math.max(max, map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+1][j]);

        for(int i=0; i<N-1; ++i)
            for(int j=0; j<M-2; ++j)
                max = Math.max(max, map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1]);

        for(int i=0; i<N-2; ++i)
            for(int j=0; j<M-1; ++j)
                max = Math.max(max, map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1]);

        return max;
    }
}
