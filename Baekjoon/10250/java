import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            int x,y = 1;
            int H, W, N, room;
            H = sc.nextInt();
            W = sc.nextInt();
            N = sc.nextInt();

            if(N%H == 0) y = H;
            else y = N % H;

            if(N%H == 0) x= N/H;
            else x = N / H + 1;

            room = y*100 + x;
            System.out.println(room);
        }
    }
}
