class floyd_warshall {
	static int[][] w;
	static int[][] dist;
    static int V;
    
    public floyd_warshall(int v) {
    	this.V = v;
    	dist = new int[V][V];
    	w = new int[V][V];
    	
    }
    
    public void input(int i,int j,int w){
        this.w[i][j] = w;
        this.w[j][i] = w;
    }
 
    public void run(int w[][]) {
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = w[i][j];
 
        for (int k = 0; k < V; k++) 
            for (int i = 0; i < V; i++) 
                for (int j = 0; j < V; j++) 
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        print_floyd_warshall();
    }
 
    public void print_floyd_warshall() {
        for (int i=0; i<V; ++i) {
            for (int j=0; j<V; ++j) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
