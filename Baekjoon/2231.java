import java.util.Scanner;

public class Main {
    static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();
        
        for(int i = 1; i<=1000000; ++i){
            if(sol(i) == n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
    
    private static int sol(int i){
        int sum = i;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
