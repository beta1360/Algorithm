import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    static int N;
    static StringTokenizer st;
    static boolean map[][];
    static Vector<Integer>[] curveList;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[101][101];
        curveList = new Vector[N];

        for(int n=0; n<N; ++n){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            curveList[n] = new Vector<Integer>();
            setDragonCurve(n, x, y, d, g);
        }

        System.out.println(checkSquare());
        br.close();
    }

    private static void setDragonCurve(int index, int sx, int sy, int d, int g){
        getDragonList(index, d, g);
        map[sy][sx] = true;

        int listLen = curveList[index].size();
        for(int i=0; i< listLen; ++i){
            int direction = curveList[index].get(i);
            sx = sx + dx[direction];
            sy = sy + dy[direction];
            map[sy][sx] = true;
        }
    }

    private static void getDragonList(int index, int d, int g){
        curveList[index].add(d);

        for(int i=1; i<=g; ++i){
            int len = (int)Math.pow(2, i-1);
            for(int j=0; j < len; ++j){
                int cur = curveList[index].get((len-1)-j);
                curveList[index].add((cur+1) % 4);
            }
        }
    }

    private static int checkSquare(){
        int numOfSquare = 0;
        int checkX[] = {0, 1, 1};
        int checkY[] = {1, 0, 1};

        for(int i=0; i<100; ++i){
            for(int j=0; j<100; ++j){
                if(map[i][j]) {
                    int counter = 0;
                    for (int dr = 0; dr < 3; ++dr)
                        if (map[i + checkY[dr]][j + checkX[dr]]) counter++;

                    if (counter == 3) numOfSquare++;
                }
            }
        }

        return numOfSquare;
    }
}
