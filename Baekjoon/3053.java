import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] argv){
        DecimalFormat df = new DecimalFormat("0.000000"); 
        Scanner sc = new Scanner(System.in); 
        
        int R = sc.nextInt(); 
        double pi = Math.PI; 
        
        System.out.println(df.format(R*R*pi)); 
        System.out.println(df.format(R*R*2));
        sc.close();
    }
}
