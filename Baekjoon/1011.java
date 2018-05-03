import java.util.Scanner;

public class Main { 
    public static void main(String[] argv) {  
        int T;  
        long x,y;    
        Scanner sc = new Scanner(System.in);   
        T = sc.nextInt();  
  
        for(int i=0; i<T; i++) {   
            x = sc.nextLong();   
            y = sc.nextLong();   
            long dist = y - x;       
    
            if(dist == 1)     
                System.out.println("1");      
            else {    
                int k = 0, cnt=1, result;    
                while(true) {     
                    long temp;     
                    if(cnt % 2 == 0) {      
                        temp = (long)Math.pow(k, 2.0);      
                        if(temp >= dist) {       
                            result = 2*k - 1;       
                            System.out.println(result);       
                            break;      
                        }     
                    } else {      
                        temp = (long)(Math.pow(k, 2.0) + k);      
                        if(temp >= dist) {       
                            result = 2*k;       
                            System.out.println(result);       
                            break;      
                        }      
                        k++;     
                    }     
                    cnt++;    
                }   
            }  
        }   
        sc.close(); 
    }
}
