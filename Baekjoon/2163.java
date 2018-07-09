import java.util.Scanner;

public class Main {
    static int N, M;
    
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = Integer.parseInt(sc.nextLine().trim());
        System.out.println((M*N)-1);
        sc.close();
    }
}
