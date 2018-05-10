import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] argc) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken(" ");
			int result;
			if(op.equals("push")) {
				int opcode = Integer.parseInt(st.nextToken());
				stack.push(opcode);
			} else if (op.equals("pop")){
				try {
					result = stack.pop();
					System.out.println(result);
				} catch(Exception e) {
					System.out.println("-1");
				}
			} else if (op.equals("size")) {
				result = stack.size();
				System.out.println(result);
			} else if (op.equals("empty")) {
				if(stack.isEmpty()) 
					System.out.println("1");
				else 
					System.out.println("0");
				
			} else {// if (op.equals("top")) {
				try {
					result = stack.peek();
					System.out.println(result);
				} catch(Exception e) {
					System.out.println("-1");
				}
			}
		}
		
		br.close();
	}
}
