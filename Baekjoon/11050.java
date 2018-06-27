import java.util.Scanner;

public class Main {
    public static void main(String[] argc){
        Scanner sc = new Scanner(System.in);
        int N, K, result = 1;

        N = sc.nextInt();
        K = sc.nextInt();

        for(int i = 0; i < K; ++i)
            result *= (N - i);

        for(int i = K; i >= 1; --i)
            result /= i;

        System.out.println(result);

        sc.close();
    }
}
