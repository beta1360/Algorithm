import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c;
    static int cnt = 0;
    static int x = 0, y = 0;
    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, N);
        getZ(0, 0,size);

        br.close();
    }

    private static void getZ(int start_x, int start_y, int size){
        if((start_x == r) && (start_y == c)) {
            System.out.println(cnt);
            return;
        }

        if((r < start_x + size) && (r >= start_x)
                && (c < start_y + size) && (c >= start_y)) {
            getZ(start_x, start_y, size/2);
            getZ(start_x, start_y +size/2, size/2);
            getZ(start_x + size/2, start_y, size/2);
            getZ(start_x + size/2, start_y + size/2, size/2);
        } else
            cnt += size*size;
    }
}
