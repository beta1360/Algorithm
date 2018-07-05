import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, V;
    static int count = 0;
    static boolean visit[];
    static Queue<Integer> q;
    static boolean map[][];

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());

        visit = new boolean[N+1];
        map = new boolean[N+1][N+1];
        q = new LinkedList<Integer>();

        for(int i=0; i<V; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            map[src][dest] = map[dest][src] = true;
        }

        visit[1] = true;
        q.offer(1);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=1; i<=N; ++i){
                if(map[cur][i] && !visit[i]){
                    visit[i] = true;
                    count++;
                    q.offer(i);
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}
