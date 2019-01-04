import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=1; i<=N; ++i){
            for(int j=0; j<2*N; ++j){
                if((j < i) || (j > 2*N - i - 1))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        for(int i=N-1; i>0; --i){
            for(int j=0; j<2*N; ++j){
                if((j < i) || (j > 2*N - i - 1))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();
    }
}
