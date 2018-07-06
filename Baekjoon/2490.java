import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<3; ++i) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<4; ++j)
                count += Integer.parseInt(st.nextToken());

            if(count == 3) System.out.println("A");
            else if(count == 2) System.out.println("B");
            else if(count == 1) System.out.println("C");
            else if(count == 0) System.out.println("D");
            else System.out.println("E");
        }

        br.close();
    }
}
