import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static int[] arr = new int[10001];
	public static void main(String[] argv) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++)
			arr[Integer.parseInt(br.readLine())]++;
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<10001; i++) 
			if(arr[i] != 0) {
				for(int j=0; j<arr[i]; j++)
					bw.write(Integer.toString(i)+"\n");
			}
				
		
		br.close();
		bw.close();
	}
}
