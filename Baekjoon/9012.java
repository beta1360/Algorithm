import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] argc) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			Stack<Character> stack = new Stack<Character>();
			String test = br.readLine();
			
			try {
				for(int i=0; i<test.length(); i++) {
					if(test.charAt(i) == '(')
						stack.push('(');
					else
						stack.pop();
				}
				
				if(stack.isEmpty())
					System.out.println("YES");
				else 
					System.out.println("NO");
			} catch(Exception e) {
				System.out.println("NO");
			}
		}
		
		br.close();
	}
}
