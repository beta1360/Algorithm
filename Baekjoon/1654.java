import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static long lan[];

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lan = new long[K];
        for(int i=0; i<K; ++i) lan[i] = Long.parseLong(br.readLine());

        bw.write(solution() + "\n");

        bw.close();
        br.close();
    }

    private static long solution(){
        long max = Long.MIN_VALUE;
        long start = 0;
        long end = Long.MAX_VALUE;

        while(start <= end){
            long cnt = 0;
            long mid = (start + end)/2;

            for(int i=0; i<K; ++i)
                cnt += (lan[i]/mid);

            if(cnt < N)
                end = mid - 1;

            else {
                start = mid +1;
                max = Math.max(mid, max);
            }
        }
        return max;
    }
}
