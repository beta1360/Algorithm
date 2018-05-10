import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class CompareString implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		if(o1.length() < o2.length()) {
			return -1;
		
		} else if (o1.length() > o2.length()) {
			return 1;
		
		} else { // o1.length() == o2.length()
			for(int i=0; i < o1.length(); i++) {
				if(o1.charAt(i) == o2.charAt(i)) { 
					continue;
				} else if(o1.charAt(i) < o2.charAt(i)) {
					return -1;
				} else
					return 1;
			}
			return 0;
		}
	}
	
}

public class Main {
	public static void main(String[] argc) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> arr = new ArrayList<String>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			if(!arr.contains(temp)) arr.add(temp);
		}
		
		Collections.sort(arr, new CompareString());
		
		for(int i=0; i<arr.size(); i++)
			System.out.println(arr.get(i));
		
		br.close();
	}
}
