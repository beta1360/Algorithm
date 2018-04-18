import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt = 0;
	static String in;
	public static void main(String[] argv) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		in = br.readLine();
		
		String[] word = in.split(" ");
		for(int i=0; i<word.length; i++) 
			if(!word[i].equals("")) cnt++;
		
		System.out.println(cnt);
	}
}
