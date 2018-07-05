import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int arr[];
    static int sum[];

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sum = new int[N];
        st = new StringTokenizer(br.readLine());
        sum[0] = arr[0] = Integer.parseInt(st.nextToken());

        for(int i=1; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        for(int m=0; m<M; ++m){
            int i, j, sol = 0;
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            sol = sum[j-1] - sum[i-1] + arr[i-1];

            System.out.println(sol);
        }

        br.close();
    }
}
