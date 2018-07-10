import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int map[][];
    static int r[] = new int[3];

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; ++j)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        divideMatrix(0, 0, N);

        for(int i=0; i<3; ++i)
            System.out.println(r[i]);

        br.close();
    }

    private static void divideMatrix(int start_x, int start_y, int size){
        int first = map[start_y][start_x];
        boolean flag = true;

        for(int i=start_y; i< start_y + size; ++i)
            for(int j=start_x; j< start_x + size; ++j)
                if(first != map[i][j]) {
                    flag = false;
                    break;
                }


        if(flag)
            r[map[start_y][start_x]+1]++;

        else {
            size /= 3;

            divideMatrix(start_x, start_y, size);
            divideMatrix(start_x + size, start_y, size);
            divideMatrix(start_x + size*2, start_y, size);

            divideMatrix(start_x, start_y + size, size);
            divideMatrix(start_x + size, start_y + size, size);
            divideMatrix(start_x + size*2, start_y + size, size);

            divideMatrix(start_x, start_y + size*2, size);
            divideMatrix(start_x + size, start_y + size*2, size);
            divideMatrix(start_x + size*2, start_y + size*2, size);
        }
    }
}
