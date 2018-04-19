import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] argv) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		Vector<Integer> v = new Vector<Integer>();
		
		for(int i=0; i<T; i++) 
			v.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(v);
		
		for(int i=0; i<T; i++) 
			wr.write(Integer.toString(v.get(i))+"\n");
		
		wr.close(); br.close();
	}
}
