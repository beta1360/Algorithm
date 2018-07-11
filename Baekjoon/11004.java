import java.io.*;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    static int N, K;
    static Vector<Integer> v = new Vector<Integer>();

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i) v.add(Integer.parseInt(st.nextToken()));

        Collections.sort(v);
        bw.write(v.get(K-1)+"\n");

        bw.close();
        br.close();
    }
}
