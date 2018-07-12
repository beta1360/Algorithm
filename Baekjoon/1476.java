import java.util.Scanner;
 
public class Main {
    static int E, S, M;
    static int y = 0;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        E = sc.nextInt() -1;
        S = sc.nextInt() -1;
        M = sc.nextInt() -1;
 
        while (true) {
            if ( (y % 15 == E ) && ( y % 28 == S ) && ( y % 19 == M )) {
                System.out.println( y + 1 );
                break;
            }
            y++;
        }
        sc.close(); 
    }
}
