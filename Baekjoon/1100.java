import java.util.Scanner;

public class Main {
    static String chess[];
    static int result = 0;
    
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        chess = new String[8];
        
        for(int i=0; i<8; ++i)
            chess[i] = sc.nextLine();
        
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                if((i%2==0) && (j%2==0) && (chess[i].charAt(j) == 'F')) result++;
                else if((i%2==1) && (j%2==1) && (chess[i].charAt(j) == 'F')) result++;
            }
        }
        System.out.println(result);
        sc.close();
    }
}
