import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    static int N;
    static int arr[][];
    static int result[][];
    static boolean visit[];
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        result = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){ 
            visit = new boolean[N];
            q.offer(i);
            
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int j = 0; j < N; j++)
                    if(arr[cur][j] == 1 && !visit[j]){
                        q.offer(j);
                        visit[j] = true;
                        result[i][j] = 1;
                    }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                System.out.print(result[i][j] + " ");
            System.out.println();
        }
        
        br.close();
    }
}
