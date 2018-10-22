import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static Edge[] edges;
    static int m, n;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        while(m != 0 && n != 0){
            int allCost = 0;
            parent = new int[m];
            edges = new Edge[n];

            for(int i=0; i<m; ++i) parent[i] = i;

            for(int i=0; i<n; ++i){
                int x, y, z;
                st = new StringTokenizer(br.readLine());

                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                z = Integer.parseInt(st.nextToken());

                edges[i] = new Edge(x, y, z);
                allCost += z;
            }

            Arrays.sort(edges, new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o1.cost - o2.cost;
                }
            });

            for(int i=0; i<n; ++i){
                int x = findRoot(edges[i].v1);
                int y = findRoot(edges[i].v2);

                if(x == y) continue;

                parent[x] = y;
                allCost -= edges[i].cost;
            }

            sb.append(allCost).append("\n");

            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int findRoot(int x){
        if(x == parent[x]) return x;

        return parent[x] = findRoot(parent[x]);
    }

    static class Edge {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }
}
