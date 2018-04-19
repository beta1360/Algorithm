import java.util.Scanner;

public class Main {
	static String in;
	static char[] ch = new char[] {
		'A','B','C','D','E','F','G','H','I','J','K','L','M','N'
		,'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	static int[] alpha = new int[26];
	static int max = -1, max_index = -1;
	static char max_ch;
	
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		in = sc.next();
		sc.close();
		
		in = in.toUpperCase();

		for(int i=0; i<26; i++) 
			alpha[i] = getCharNumber(in,ch[i]);
			
		for(int i=0; i<26; i++) {
			if(alpha[i] > max) {
				max = alpha[i];
				max_ch = ch[i];
			}
			else if(alpha[i] == max)
				max_ch = '?';
		}
		System.out.println(max_ch);
	}
	
	private static int getCharNumber(String str, char c) {
        int count = 0;
        for(int i=0;i<str.length();i++) 
            if(str.charAt(i) == c)
                count++;
        return count;
    }
}
