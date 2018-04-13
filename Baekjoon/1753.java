package p1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1753 {
	static int V; 
	static int E; 
	static int start; 

	static int[] dist; 
	static boolean[] visit; 
	static HashMap<Integer, LinkedList<Edge>> maps;
	
	public static void main(String[] argv) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dist = new int[V+1];
		visit = new boolean[V+1];
		maps = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= V; i++)
			dist[i] = Integer.MAX_VALUE -1;

		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int src, dest, w;
			
			src = Integer.parseInt(st.nextToken());
			dest = Integer.parseInt(st.nextToken());	
			w = Integer.parseInt(st.nextToken());
			
			if (!maps.containsKey(src))
				maps.put(src, new LinkedList<>());
			
			maps.get(src).add(new Edge(src,dest,w));
		}
		
		dist[start] = 0;
		
		for (int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int src = -1;
			
			for (int k = 1; k < dist.length; k++) {
				if (!visit[k] && dist[i] != Integer.MAX_VALUE 
                		&& (min > dist[k])) {
					min = dist[k];
					src = k;
				}
			}

			visit[src] = true;

			if (maps.containsKey(src)) {
				for (Edge next : maps.get(src)) {
					int dest = next.v;
					int w = next.w;

					if (dist[src] != Integer.MAX_VALUE - 1 && w != 0
		                	&& dist[dest] > dist[src] + w) {
						dist[dest] = dist[src] + w;
					}
				}
			}
		}

		for (int i = 1; i < dist.length; i++) {
			System.out.println(dist[i] == Integer.MAX_VALUE - 1 ? "INF" : dist[i]);
		}
	}
}

class Edge {
	public int u;
	public int v;
	public int w;

	public Edge(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
}
