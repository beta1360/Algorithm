import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long a,b,x;
    static int T;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; ++t){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());

            while(a != 0){
                x = (b-1)/a + 1;
                a = a*x - b;
                b *= x;
            }
            System.out.println(x);
        }

        br.close();
    }
}
