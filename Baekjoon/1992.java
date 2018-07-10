import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String map[];
    static StringBuilder result;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N];
        for(int i=0; i<N; ++i)
            map[i] = br.readLine();
        result = new StringBuilder();

        quadTree(0,0,N);
        System.out.println(result.toString());
        br.close();
    }

    private static void quadTree(int start_x, int start_y, int size){
        char first = map[start_y].charAt(start_x);
        boolean flag = true;

        for(int i=start_y; i<start_y + size; ++i)
            for(int j=start_x; j<start_x + size; ++j)
                if(map[i].charAt(j) != first) {
                    flag = false;
                    break;
                }

        if(flag)
            result.append(first);
        else {
            result.append("(");
            quadTree(start_x, start_y, size/2);
            quadTree(start_x + size/2, start_y, size/2);
            quadTree(start_x, start_y + size/2, size/2);
            quadTree(start_x + size/2, start_y + size/2, size/2);
            result.append(")");
        }
    }
}
