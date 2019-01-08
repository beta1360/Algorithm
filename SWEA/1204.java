import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; ++i){
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            setNumber(N, st);
        }

        System.out.print(sb.toString());
        br.close();
    }

    private static void setNumber(int N, StringTokenizer st){
        int numbers[] = new int[101];
        int max = Integer.MIN_VALUE;
        int nmax = 0;
        Arrays.fill(numbers, 0);

        while(st.hasMoreTokens()){
            int pn = Integer.parseInt(st.nextToken());
            numbers[pn]++;

            if(max < numbers[pn]){
                max = numbers[pn];
                nmax = pn;
            } else if(max == numbers[pn]){
                nmax = Math.max(nmax, pn);
            }
        }

        sb.append("#").append(N).append(" ").append(nmax).append("\n");
    }
}
