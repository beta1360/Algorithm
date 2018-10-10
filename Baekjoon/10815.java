import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb;
    static int[] A;
    static int[] B;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i) A[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; ++i) B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        for(int i=0; i<M; ++i) {
            if (binarySearch(B[i])) sb.append(1+" ");
            else sb.append(0+" ");
        }
        
        bw.write(sb.toString()+"\n");
        bw.flush();
        
        br.close();
        bw.close();
    }

    private static boolean binarySearch(int n){
        int start = 0 ;
        int end = N-1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(A[mid] == n) return true;

            else {
                if(A[mid] < n) start = mid + 1;
                else end = mid - 1;
            }
        }

        return false;
    }
}
