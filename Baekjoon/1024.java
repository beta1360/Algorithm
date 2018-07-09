import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int x;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        while(L <= 100) {
            if (((x = (N - L * (L - 1) / 2)) % L == 0) && (x >= 0)) {
                x /= L;
                for(int i=0; i<L; i++)
                    System.out.print((x++) + " ");
                return;
            }
            L++;
        }

        System.out.println(-1);
        br.close();
    }
}
