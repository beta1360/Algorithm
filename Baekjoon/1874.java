import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] argc) {
		Scanner sc = new Scanner(System.in);
		boolean error_flag = false;
		ArrayList<Character> array = new ArrayList<Character>();
		Stack<Integer> stack = new Stack<Integer>();
		int T = sc.nextInt();
		int cnt = 1;
		
		for(int t=0; t<T; t++){
			int n = sc.nextInt();
			
			try {
				if(!error_flag) {
					// initialize 
					if(stack.isEmpty() && cnt==1) {
						for(int i=1; i<=n; i++) {
							array.add('+');
							stack.push(i);
						}
						cnt = n+1;
						array.add('-');
						stack.pop();
					} else if ((stack.isEmpty()) && (cnt <= T)) {
						for(int i=cnt; i<=n && i <= T; i++) {
							array.add('+');
							stack.push(i);
							cnt++;
						}
						stack.pop();
						array.add('-');
					} else if ((stack.peek() < n) && (cnt <= T)) {
						for(int i=cnt; i<=n && i <= T; i++) {
							array.add('+');
							stack.push(i);
							cnt++;
						}
						stack.pop();
						array.add('-');
					} else if (stack.peek() > n) {
						while(true) {
							int tmp = stack.pop();
							array.add('-');
							if(tmp == n) break;
						}
					} else if((stack.peek() < n) && (cnt > T)) {
						while(true) {
							int tmp = stack.pop();
							array.add('-');
							if(tmp == n) break;
						}
					} else if (stack.peek() == n) {
						stack.pop();
						array.add('-');
					}
				}
			} catch(Exception e) {
				error_flag = true;
			}

		}
		
		if(error_flag) System.out.println("NO");
		else {
			for(int i=0; i<array.size(); i++)
				System.out.println(array.get(i));
		}
		
		sc.close();
	}
}
