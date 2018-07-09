import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int H, W;
    static String grill[];

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());


        for(int t=0; t<T; ++t){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            grill = new String[H];

            for(int i=0; i<H; ++i){
                grill[i] = br.readLine();
                for (int j = W - 1; j >= 0; --j)
                    System.out.print(grill[i].charAt(j));
                System.out.println();
            }
        }
        br.close();
    }
}
