package prim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int V, E;
    private static boolean[] visit;
    private static int[][] w;
    private static int[] d;
    private static int minCost = 0;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visit = new boolean[V+1];
        w = new int[V+1][V+1];
        d = new int[V+1];

        for(int i=0; i<=V; ++i){
            d[i] = Integer.MAX_VALUE;
            for(int j=0; j<=V; ++j) w[i][j] = Integer.MAX_VALUE;
        }

        for(int e=0; e<E; ++e){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            w[from][to] = w[to][from] = weight;
        }

        d[1] = 0;
        int numOfMST = 0;
        
        while(numOfMST < V){
            int min = Integer.MAX_VALUE;
            int u = -1;

            for(int i=0; i<= V; ++i){
                if(!visit[i] && d[i] < min){
                    min = d[i];
                    u = i;
                }
            }

            for(int i=1; i<=V; ++i){
                if(!visit[i] && w[u][i] != Integer.MAX_VALUE){
                    if(w[u][i] < d[i]) d[i] = w[u][i];
                }
            }

            numOfMST++;
            minCost += min;
            visit[u] = true;
        }
        System.out.println(minCost);
        br.close();
    }
}
