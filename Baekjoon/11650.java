import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main{
    static int[][] point;
    static int n;
    
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        point = new int[n][2];
        
        for(int i=0; i<n; i++){
            point[i][0] = sc.nextInt();
            point[i][1] = sc.nextInt();
        }
        
        Arrays.sort(point, new Comparator<int []>(){
           public int compare(int a[], int b[]){
               if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
               else return Integer.compare(a[0],b[0]);
           } 
        });
        for(int i=0; i<n; i++) System.out.println(point[i][0]+" "+point[i][1]);
        sc.close();
    } 
}
