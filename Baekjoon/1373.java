import java.util.Scanner;

public class Main {
    static String N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        N = sc.next();

        int len_2 = N.length();
        int first = len_2%3;

        twoToEight(N.substring(0, first));

        for(int i=first; i<len_2; i+=3)
            twoToEight(N.substring(i, i + 3));

        System.out.println(sb.toString());
        sc.close();
    }

    private static void twoToEight(String s){
        if(s.equals("000") || s.equals("0")) sb.append('0');
        else if(s.equals("001") || s.equals("1")) sb.append('1');
        else if(s.equals("010") || s.equals("10")) sb.append('2');
        else if(s.equals("011") || s.equals("11")) sb.append('3');
        else if(s.equals("100")) sb.append('4');
        else if(s.equals("101")) sb.append('5');
        else if(s.equals("110")) sb.append('6');
        else if(s.equals("111")) sb.append('7');
    }
}
