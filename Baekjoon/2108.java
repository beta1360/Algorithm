import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Comp implements Comparator<Integer>{
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}
}

public class Main {
	private static final int CENTER = 4000;
	private static int[] arr = new int[8001];
	private static int sum = 0;
	private static int freq = Integer.MIN_VALUE;
	private static int freq_max = 0;
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;
	public static void main(String[] argv) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> freq_list = new ArrayList<Integer>();
				
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(br.readLine());
			arr[temp+CENTER]++; sum += temp;
			list.add(temp);
			
			if(temp < min) min = temp;
			if(temp > max) max = temp;
			
			if(arr[temp+CENTER] > freq) {
				freq_list.clear();
				freq_max = temp;
				freq = arr[temp+CENTER];
				freq_list.add(temp);
			} else if (arr[temp+CENTER] == freq)
				freq_list.add(temp);
		}
		
		Collections.sort(list, new Comp());
		Collections.sort(freq_list, new Comp());

		System.out.println(Math.round((double)sum/N));
		System.out.println(list.get((int)(N/2)));
		if(freq_list.size() == 1)
			System.out.println(freq_max);
		else 
			System.out.println(freq_list.get(1));
		System.out.println(max - min);
		
		br.close();
	}
}
