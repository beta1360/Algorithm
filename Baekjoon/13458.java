import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] argv) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long cnt = 0;
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; ++i){
            int cur = A[i];
            cur -= B;

            cnt++;

            if(cur > 0) {
                if (cur % C == 0)
                    cnt += cur / C;
                else
                    cnt += cur / C + 1;
            }
        }

        bw.write(cnt + "\n");
        br.close();
        bw.close();
    }
}
