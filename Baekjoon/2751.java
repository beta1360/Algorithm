import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++)
			arr.add(sc.nextInt());
		
        Collections.sort(arr, new Comparator<Integer>() {
    	    @Override
    	    public int compare(Integer o1, Integer o2) {
    	        return o1.compareTo(o2);
    	    }
        });
		
		for(int i=0; i<N; ) 
			System.out.println(arr.get(i++));
		
		sc.close();
	}
}
