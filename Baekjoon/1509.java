import java.util.Scanner;

public class Main {
    static boolean[][] check;
    static int dp[];
	  static String s;
    static int len;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine().trim();
        len = s.length();
		
        s = " " + s;
        check = new boolean[len+1][len+1];
        
        for(int i = 1; i <= len; i++) check[i][i] = true;			
        
        for(int i = 1; i < len; i++) 
            if(s.charAt(i) == s.charAt(i+1))
                check[i][i+1] = check[i+1][i] = true;
                
        solve();
		
        dp = new int[len+1];
        for(int i = 1; i <= len; i++) 
            for(int j = 1; j <= i; j++) 
                if(check[j][i]) 
                    if((dp[i] == 0) || (dp[i] > dp[j-1] + 1)) 
                        dp[i] = dp[j-1] + 1;
                        
        System.out.println(dp[len]);
        sc.close();
    }
    
    public static void solve() {
        for(int i = 2; i < len; i++) 
            for(int j = 1; j <= len - i; j++) 
                if((s.charAt(j) == s.charAt(j+i)) 
                  && check[j+1][j+i-1]) 
                    check[j][j+i] = check[j+i][j] = true;
    }
}
