import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static boolean cup[];

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        M = Integer.parseInt(br.readLine());
        cup = new boolean[4];
        cup[1] = true;

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(cup[x]){
                cup[x] = false;
                cup[y] = true;
            } else if(cup[y]){
                cup[x] = true;
                cup[y] = false;
            }
        }

        for(int i=1 ;i<=3; i++){
            if(cup[i])
                bw.write(i+"\n");
        }

        br.close();
        bw.close();
    }
}
