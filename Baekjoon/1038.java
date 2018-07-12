import java.io.*;
import java.util.Collections;
import java.util.Vector;

public class Main {
    static int N;
    static Vector<Long> v;

    public static void main(String[] argv) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        v = new Vector<Long>();
        N = Integer.parseInt(br.readLine());

        for(int i=1; i<1024; ++i){
            long result = 0;
            int tmp = i;
            for(int j=9; j >= 0; --j){
                if(tmp%2 == 1) result = 10 * result + j;
                tmp /= 2;
            }
            v.add(result);
        }
        Collections.sort(v);

        if(N > 1022) bw.write("-1");
        else bw.write(v.get(N)+"\n");
        
        bw.close();
        br.close();
    }
}
