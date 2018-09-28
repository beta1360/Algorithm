package kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
* 1. Set V and E
* 2. Arrange edge(E) in ascending order.
* 3. Add small weights first. But check if there is a cycle.
*     - Cycle check can be checked with DFS.
* ** The implementation is done using the Union-Find algorithm.
*/


/*
 ** BOJ 1197 - 최소 스패닝 트리 (Kruskal Algorithm)
 ** https://www.acmicpc.net/problem/1197
*/
public class Main {
    private static int V, E;
    private static int minCost = 0;
    private static int[] parent;
    private static Edge[] edges;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        edges = new Edge[E];

        for(int v=1; v<=V; ++v) parent[v] = v;

        for(int e=0; e<E; ++e){
            st = new StringTokenizer(br.readLine());
            edges[e] = new Edge(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        br.close();

        Arrays.sort(edges, new Comparator<Edge>(){
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        for(int i=0; i<E; ++i){
            int rootX = findRoot(edges[i].v1);
            int rootY = findRoot(edges[i].v2);

            if(rootX == rootY) continue; // Cycle!!
            else {
                /* Union-Find's union */
                parent[rootX] = rootY;
                minCost = minCost + edges[i].cost;
            }
        }

        System.out.println(minCost);
    }

    /* Related to Union-Find
    * Find vertex; x's 'root vertex'.
     */
    private static int findRoot(int x){
        if(x == parent[x]) return x;
        else {
            parent[x] = findRoot(parent[x]);
            return parent[x];
        }
    }

    /* Edge Informations
    * v1 : Vertex 1
    * v2 : Vertex 2
    * cost : Edge's weight
    * */
    static class Edge {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }
}
