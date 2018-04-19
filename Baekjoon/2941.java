import java.util.Scanner;

public class Main {
	static String s;
	static int index;
	static int cnt = 0;
	static int max;
	
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		max = s.length()-1;
		
		for(index =0; index<=max; index++) {
			index += is_croatia();
			cnt++;
		}
		
		System.out.println(cnt);
		
		sc.close();
	}
	
	private static int is_croatia(){
		if (!(max < index+2)) {
			if(s.charAt(index) == 'd') {
				if(s.charAt(index+1) == 'z' 
				&& s.charAt(index+2) == '=' ) 
					return 2;
			}
		}
		if (!(max < index+1)) {
			if(s.charAt(index) == 'c') {
				if(s.charAt(index+1) == '=' 
				|| s.charAt(index+1) == '-' &&!(max < index+1)) 
					return 1;
			} else if(s.charAt(index) == 'd') {
				if(s.charAt(index+1) == '-' &&!(max < index+1))
					return 1; 
			} else if(s.charAt(index) == 'l') {
				if(s.charAt(index+1) == 'j' &&!(max < index+1))
					return 1; 
			} else if(s.charAt(index) == 'n') {
				if(s.charAt(index+1) == 'j' &&!(max < index+1))
					return 1;
			} else if(s.charAt(index) == 's') {
				if(s.charAt(index+1) == '=' &&!(max < index+1))
					return 1; 
			} else if(s.charAt(index) == 'z') {
				if(s.charAt(index+1) == '=' &&!(max < index+1))
					return 1;
			}
		}
		return 0;
	}
}
		
