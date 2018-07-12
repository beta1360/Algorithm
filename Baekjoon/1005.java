import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int D[];
    static int dp[];
    static int T;
    static int N, K, obj;
    static LinkedList<Integer> graph[];
    static int degree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            D = new int[N+1];
            dp = new int[N+1];
            degree = new int[N+1];
            graph = new LinkedList[N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                D[i] = Integer.parseInt(st.nextToken());
                graph[i] = new LinkedList<Integer>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int src, dest;
                src = Integer.parseInt(st.nextToken());
                dest = Integer.parseInt(st.nextToken());
                graph[src].add(dest);
                degree[dest]++;
            }
            obj = Integer.parseInt(br.readLine());
            solution();
            bw.write(dp[obj]+"\n");
        }

        br.close();
        bw.close();
    }

    private static void solution() {
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                q.offer(i);
                dp[i] = D[i];
            }
        }

        while (!q.isEmpty() && (degree[obj] != 0)) {
            int cur = q.poll();

            for (int i = 0; i < graph[cur].size(); ++i) {
                int next = graph[cur].get(i);

                if (dp[cur] + D[next] > dp[next])
                    dp[next] = D[cur] + D[next];

                degree[next]--;
                if (degree[next] == 0) {
                    q.offer(next);
                    D[next] = dp[next];
                }
            }
        }
    }
}
