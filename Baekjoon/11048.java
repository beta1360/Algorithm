import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] comp;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        comp = new int[N][M];
 
        for(int i =0; i<N; i++)
            for(int j =0; j<M; j++)
                map[i][j] = sc.nextInt();

        for(int i=0; i<N; i++){
            for(int j =0; j<M; j++){
                if(i==0&&j==0)
                    comp[i][j]=map[i][j];
                else if(j==0)
                    comp[i][j]=map[i][j]+comp[i-1][j];
                else if(i==0)
                    comp[i][j]=map[i][j]+comp[i][j-1];
                else{
                    int candy1 = comp[i-1][j];
                    int candy2 = comp[i][j-1];
                    comp[i][j] = candy1>candy2 ? map[i][j]+candy1 : map[i][j]+candy2;                    
                }
            }
        }
        System.out.println(comp[N-1][M-1]);
        sc.close();
    }
}
 
