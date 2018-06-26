import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new LinkedList<Integer>();
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; ++i){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int param;
            if(line.contains("push_front")){
                String token = st.nextToken();
                token = st.nextToken();
                param = Integer.parseInt(token);
                dq.addFirst(param);
            } else if (line.contains("push_back")){
                String token = st.nextToken();
                token = st.nextToken();
                param = Integer.parseInt(token);
                dq.addLast(param);
            } else if (line.contains("pop_front")){
                try{
                    param = dq.pollFirst();
                    System.out.println(param);
                } catch (Exception e) {
                    System.out.println("-1");
                }
            } else if (line.contains("pop_back")){
                try{
                    param = dq.pollLast();
                    System.out.println(param);
                } catch (Exception e) {
                    System.out.println("-1");
                }
            } else if (line.contains("size")){
                System.out.println(dq.size());
            } else if (line.contains("empty")){
                if(dq.isEmpty())
                    System.out.println("1");
                else
                    System.out.println("0");
            } else if (line.contains("front")){
                try{
                    param = dq.peekFirst();
                    System.out.println(param);
                } catch (Exception e) {
                    System.out.println("-1");
                }
            } else { // else if (line.contains("back))
                try{
                    param = dq.peekLast();
                    System.out.println(param);
                } catch (Exception e) {
                    System.out.println("-1");
                }
            }
        }

        br.close();
    }
}
