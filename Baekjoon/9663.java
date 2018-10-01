import java.util.Scanner;

public class Main {
    static int N;
    static int cnt = 0;
    static int col[] = new int[15];

    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        N_Queen(0);
        System.out.println(cnt);
        sc.close();
    }

    private static void N_Queen(int i){
        if(i == N)
            cnt++;
        else
            for(int j=0; j<N; ++j){
                col[i] = j;
                if(promising(i)) N_Queen(i+1);
            }
    }

    private static boolean promising(int i) {
        for(int j=0; j<i ; ++j)
            if(col[j] == col[i] || Math.abs(col[i]-col[j]) == (i-j))
                return false;

        return true;
    }
}
