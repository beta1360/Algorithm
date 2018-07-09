import java.util.Scanner;

public class Main {
    static int M, N, K;
    static int arr[];
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        M = 0;
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N+1];
        for(int i=1; i<N+1; ++i) arr[i] = sc.nextInt();
        
        for(int i=N; i>0; --i){
            M += K/arr[i];
            K %= arr[i];
        }
        System.out.println(M);
        sc.close();
    }
}
