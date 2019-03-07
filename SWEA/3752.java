import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    private static StringBuilder sb = new StringBuilder();
    private static int[] p;
    private static boolean[] sumP;

    public static void main(String[] argv) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; ++t){
            int N = Integer.parseInt(br.readLine());
            String line = br.readLine();

            int result = solution(N, line);
            sb.append("#").append(t+1)
                    .append(" ").append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static int solution(int N, String line){
        int max = 0;
        p = new int[N];
        sumP = new boolean[10001];

        StringTokenizer st = new StringTokenizer(line);
        for(int i=0; i<N; ++i)
            p[i] = Integer.parseInt(st.nextToken());

        sumP[0] = true;

        for(int i=0; i<N; ++i){
            max += p[i];
            for(int j=max; j>=0; j--)
                if(sumP[j])
                    sumP[j + p[i]] = true;

            sumP[p[i]] = true;
        }

        return checkNum(max);
    }

    private static int checkNum(int max){
        int num = 0;

        for(int i=0; i<=max; ++i){
            if(sumP[i]) num++;
        }

        return num;
    }
}
