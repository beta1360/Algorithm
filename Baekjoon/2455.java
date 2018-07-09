import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;
    static int status = 0;
    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<4; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            status = status + in - out;
            max = Math.max(status, max);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(max + "\n");

        br.close();
        bw.close();
    }
}
