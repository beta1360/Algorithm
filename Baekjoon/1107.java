import java.util.Scanner;
 
public class Main {
    static boolean[] broken = new boolean[10];
    public static int canMove(int channel) { 
        int length = 0;
 
        if ( channel == 0 ) 
            return broken[0] ? 0 : 1;
        
        while ( channel > 0 ) {
            if ( broken[channel % 10] ) return 0;
            length += 1;
            channel /= 10;
        }
        return length;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
 
        for (int i = 0; i < m; i++) 
            broken[scanner.nextInt()] = true;
        
        int answer = n - 100; 
        answer = Math.abs(answer);
        
        for (int i = 0; i <= 1000000; i++) { 
        int c = i;
        int length = canMove(c); 
        if (length > 0) {
            int press = c - n; 
            press = Math.abs(press);
            
            if (answer > length + press) 
                answer = length + press;
        }
    }
        System.out.println(answer);
    }
}
