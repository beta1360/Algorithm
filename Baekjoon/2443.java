import java.util.Scanner;

public class Main {
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<N; ++i){
            int size = 2*(N-i) - 1;

            // 공백 출력
            for(int j=0; j<i; ++j)
                System.out.print(" ");

            // 별 가로 사이즈만큼 출력
            for(int j=i; j< i + size; ++j)
                System.out.print("*");
            System.out.println();
        }

        sc.close();
    }
}
