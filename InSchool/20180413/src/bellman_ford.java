import java.util.Arrays;

class bellman_ford {
    static int V, E;
    static boolean error = false;
    static int[] d;
    public static Edge[] edge;
    
    public bellman_ford(int V, int E) {
    	this.V = V;
    	this.E = E;
    	this.d = new int[V + 1];
    	this.edge = new Edge[E+1];
    	
    	for(int i=0; i<E+1; i++)
    		this.d[i] = Integer.MAX_VALUE;
    }
    
    public void run(){
        d[1] = 0;
 
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= E; j++) {
                if (d[edge[j].src] != Integer.MAX_VALUE
                		&& d[edge[j].dest] > d[edge[j].src] + edge[j].weight) {
                    d[edge[j].dest] = d[edge[j].src] + edge[j].weight;
                    
                    if (i == V)
                    	error = true;
                }
            }
        }
    }
    
    public void print_bellman_ford() {
        if (error)
            System.out.println(-1);
        
        else { // not error
            for (int i = 2; i <= V; i++) 
                System.out.println(d[i] == Integer.MAX_VALUE ? -1 : d[i]);
        }
    }
}
 
class Edge {
    int src;
    int dest;
    int weight;
 
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
