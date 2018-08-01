import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int arr[] = new int[9];
    static int sum = 0;
    static boolean check;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int i=0; i < 9; i++) {
            arr[i] = Integer.parseInt(sc.nextLine().trim());
            sum += arr[i];
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i < 9; i++) {
            if(check) break;
            
            for(int j=0; j < 9; j++) {
                if(i == j) continue;
                
                int a = arr[i];
                int b = arr[j];
                if((sum - a - b) == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    check = true;
                    break;
                }
            }
        }
        
        for(int i=0; i < 9; i++) 
            if(arr[i] != 0) System.out.println(arr[i]);
        
        sc.close();
    }
}
