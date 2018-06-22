package p1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static int[][] bfs = new int[1001][1001];
    static int[][] dfs = new int[1001][1001];
    static boolean[] v_bfs = new boolean[1001];
    static boolean[] v_dfs = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            bfs[x][y] = bfs[y][x] = 1;
            dfs[x][y] = dfs[y][x] = 1;
        }
        get_dfs(V);
        System.out.println();
        get_bfs(V);
    }

    private static void get_bfs(int v) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(v);
        v_bfs[v] = true;
        System.out.print(v + " ");

        int temp;
        while (!q.isEmpty()) {
            temp = q.poll();
            for (int i = 0; i < N + 1; i++) {
                if ((bfs[temp][i] == 1) && (!v_bfs[i])) {
                    q.offer(i);
                    v_bfs[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    private static void get_dfs(int v) {
        v_dfs[v] = true;
        System.out.print(v + " ");

        for (int i = 1; i <= N; i++) {
            if (dfs[v][i] == 1 && !v_dfs[i])
                get_dfs(i);
        }
    }
}
