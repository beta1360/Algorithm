import java.util.Scanner;

public class Main {
    public static void main(String[] argc){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=0; t<T; t++){
            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int lcm = LCM(M,N);
            while(x!=y && x < lcm){
                if(x < y) x+=M;
                else y+= N;
            }
            
            if(x != y) System.out.println("-1");
            else System.out.println(x);
        }
        sc.close();
    }

    private static int LCM(int M, int N){
        int A,B,r;
        if (M > N) {
            A = M;
            B = N;
        } else {
            A = N;
            B = M;
        }

        r = A%B;
        while( r !=0 ){
            A = B; B = r;
            r = A%B;
        }

        return (M/B)*N;
    }
}
