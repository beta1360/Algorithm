/*
 * This source code is based on the below reference.
 * http://rightbellboy.tistory.com/39
*/
import java.util.Scanner;

public class Main {
	static int N;
	static String map[];
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();
         
        map = new String[N];
        map[0] = "  *  ";
        map[1] = " * * ";
        map[2] = "*****";
         
        for (int k=1; 3*(int)Math.pow(2,k) <= N; k++) 
            get_star(k);
         
        print_map();
    }
     
    private static void get_star(int k) {
        int y = 3*(int)Math.pow(2,k);
        int center = y / 2;
         
        for (int i=center; i<y; i++) 
            map[i] = map[i-center] + " " + map[i-center];
        
        String temp = "";
        while (temp.length() < center) 
            temp += " ";
        
        for (int i=0; i<center; i++) 
            map[i] = temp + map[i] + temp;
    }
    
    private static void print_map() {
        for (int i=0; i<N; i++) 
            System.out.println(map[i]);
    }
}
