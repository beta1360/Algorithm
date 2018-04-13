import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
	private static int maxSum;
	private static ArrayList<Integer> list;
	private static int n;
	
    public static void main(String[] args) {
    	maxSum = Integer.MIN_VALUE;
    	
        Scanner sc = new Scanner(System.in);
         
        n = sc.nextInt();
        list = new ArrayList<Integer>();
         
        for(int i = 0; i < n; i++)   
            list.add(sc.nextInt());
         
        continuous_sum();
        System.out.println(maxSum);
        sc.close();
    }

    public static void continuous_sum()   {
        ArrayList<Integer> sum = new ArrayList<Integer>();
         
        for(int i = 0; i < n; i++)   {
            int a;
            
            if(i < 1) a = 0;
            else a = sum.get(i-1);
            
            int b = list.get(i);
            
            if(a+b > b) sum.add(a+b);
            else sum.add(b);
            
            if(maxSum < sum.get(i)) 
                maxSum = sum.get(i);
        }
    }
}
