import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static int N;
    static boolean map[][];
    public static void main(String[] argv) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = sc.nextInt();
        map = new boolean[N][N];
        
        if(N == 1) 
            bw.write('*');
        else {
            printStar(0, 0, N);

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (map[i][j])
                        bw.write('*');
                    else bw.write(' ');
                }
                bw.write('\n');
            }
        }
        sc.close();
        bw.close();
    }

    private static void printStar(int x, int y, int size){
        if(size == 3){
            map[y][x] = true;    map[y][x+1] = true;  map[y][x+2] = true;
            map[y+1][x] = true;  map[y+1][x+1] = false;map[y+1][x+2] = true;
            map[y+2][x] = true;  map[y+2][x+1] = true;map[y+2][x+2] = true;

        } else {
            size /= 3;
            printStar(x, y, size);
            printStar(x+size, y, size);
            printStar(x+size*2, y, size);
            printStar(x, y+size, size);
            printStar(x+size*2, y+size, size);
            printStar(x, y+size*2, size);
            printStar(x+size, y+size*2, size);
            printStar(x+size*2, y+size*2, size);
        }
    }
}
