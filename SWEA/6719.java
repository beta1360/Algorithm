import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; ++t){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double sum = 0;
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; ++i)
                arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);
            
            for(int i= N - K; i<N; ++i)
                sum = (sum + arr[i])/2;

            sb.append("#").append(t+1).append(" ").append(sum).append("\n");
        }

        System.out.print(sb.toString());

        br.close();
    }
}
