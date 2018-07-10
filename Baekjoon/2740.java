import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M[], N[];
    static int A[][];
    static int B[][];
    static int C[][];

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = new int[2]; N = new int[2];
        N[0] = Integer.parseInt(st.nextToken());
        M[0] = Integer.parseInt(st.nextToken());
        A = new int[N[0]][M[0]];

        for(int i=0; i<N[0]; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M[0]; ++j)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        N[1] = Integer.parseInt(st.nextToken());
        M[1] = Integer.parseInt(st.nextToken());
        B = new int[N[1]][M[1]];

        for(int i=0; i<N[1]; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M[1]; ++j)
                B[i][j] = Integer.parseInt(st.nextToken());
        }

        C = new int[N[0]][M[1]];
        mutiplyMatrix();

        br.close();
    }

    private static void mutiplyMatrix() {
        for (int i = 0; i < N[0]; ++i){
            for (int j = 0; j < M[1]; ++j) {
                for (int k = 0; k < M[0]; ++k)
                    C[i][j] += A[i][k] * B[k][j];
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

    }
}
