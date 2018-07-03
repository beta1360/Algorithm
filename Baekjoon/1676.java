import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int result;
        int n2 = 0, n5 = 0;
        
        for (int i = 2; i <= N; i++) { 
            result = i;

            while (result % 2 == 0 || result % 5 == 0) {
                if (result % 2 == 0) {
                    result /= 2;
                    n2++;
                }
                if (result % 5 == 0) {
                    result /= 5;
                    n5++;
                }
            }
        }
        if(n2 < n5) System.out.println(n2);
        else System.out.println(n5);
        
        sc.close();
    }
}
