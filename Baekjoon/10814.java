import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
public class Main {
    static int N;
    static String[][] arr;
    
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        arr = new String[N][2];
        for(int i=0; i<N; i++){
            arr[i][0] = sc.next();
            arr[i][1] = sc.next();
        }
        
        Arrays.sort(arr,new Comparator<String[]>(){
            @Override
            public int compare(String[] p1, String[] p2)
                return Integer.compare(Integer.parseInt(p1[0]),Integer.parseInt(p2[0]));
        });
        
        for(int i=0; i<N; i++)
            System.out.println(arr[i][0] +" "+ arr[i][1]);
    }
}
