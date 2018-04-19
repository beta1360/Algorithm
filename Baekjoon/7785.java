import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class Main {
    static int N;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
         
        String name, status;
         
        Set<String> set = new HashSet<>(); 
         
        for(int i=0;i<N;i++){
            name=sc.next();
            status=sc.next();
            if(status.equals("enter")) set.add(name);
            else set.remove(name);
        }

        String[] arr = set.toArray(new String[set.size()]);
        Arrays.sort(arr);
         
        for(int i=arr.length-1; i>=0; i--)
            System.out.println(arr[i]);
    }
}
