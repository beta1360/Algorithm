import java.util.Scanner;

public class Main {
    static int N;
    static int n1;
    static int n2;
    static int cnt = 0;
    
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        
        while(n1 != n2){
            n1 = n1/2 + n1%2;
            n2 = n2/2 + n2%2;
            cnt++;
        }
        System.out.println(cnt);
        
        sc.close();
    }
}
