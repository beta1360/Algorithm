import java.io.*;

public class Main {
    static int M, N;
    static boolean check[];
    static int result = 0;
    static int min = 0;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        check = new boolean[N+1];

        checker();
        getSol();

        if(result == 0 || min == 0)
            bw.write("-1\n");
        else
            bw.write(result + "\n" + min + "\n");

        br.close();
        bw.close();
    }

    private static void checker(){
        for(int i=1; i<=N; ++i){
            int tmp = i*i;
            if(i*i <= N)
                if(!check[tmp])
                    check[tmp] = true;
        }
    }

    private static void getSol(){
        for(int i=M; i<=N; ++i) {
            if (check[i]) {
                if(min == 0) min = i;
                result += i;
            }
        }
    }
}
