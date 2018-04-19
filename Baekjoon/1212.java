import java.util.Scanner;

public class Main {
	static String M;
	
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		M = sc.next();
		
		int len = M.length();
		
		if(M.charAt(0) == '0' && len == 1)
			System.out.println("0");
		
		else {
			first();
			
			for(int i=1;i<len;i++)
				set_binary(i);
		}
		
		sc.close();
	}
	
	private static void first() {
		if(M.charAt(0)=='1') System.out.print("1");
		else if(M.charAt(0)=='2') System.out.print("10");
		else if(M.charAt(0)=='3') System.out.print("11");
		else if(M.charAt(0)=='4') System.out.print("100");
		else if(M.charAt(0)=='5') System.out.print("101");
		else if(M.charAt(0)=='6') System.out.print("110");
		else System.out.print("111");
	}
	
	private static void set_binary(int i) {
		if(M.charAt(i)=='0') System.out.print("000");
		else if(M.charAt(i)=='1') System.out.print("001");
		else if(M.charAt(i)=='2') System.out.print("010");
		else if(M.charAt(i)=='3') System.out.print("011");
		else if(M.charAt(i)=='4') System.out.print("100");
		else if(M.charAt(i)=='5') System.out.print("101");
		else if(M.charAt(i)=='6') System.out.print("110");
		else System.out.print("111");
	}
}
