import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static boolean[] arr = new boolean[1001];
    public static void main(String[] argc){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<Integer>();
        int N, M;

        N = sc.nextInt();
        M = sc.nextInt();

        int counter = 0;
        int index = 1;
        while(q.size() != N){
            if(!arr[index]) counter++;

            if(counter == M) {
                arr[index] = true;
                q.add(index);
                counter = 0;
            }

            index++;
            if(index > N) index = 1;
        }

        System.out.print("<" + q.poll());
        while(q.size() != 0)
            System.out.print(", "+q.poll());
        System.out.println(">");

        sc.close();
    }
}
