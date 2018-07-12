import java.util.*;

class Main{
    static long a,b, end;
    static boolean eratos[];

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        a=sc.nextLong();
        b=sc.nextLong();
        eratos = new boolean[1000002];

        for(int i=0; i<1000002; ++i) eratos[i]=false;

        end = (long) Math.sqrt(b);

        for(long i=2; i<=end ;++i){
            long k = i*i;
            long start = ((a-1)/k+1)*k;
            for(long j=start; j<=b; j+=k)
                eratos[(int) (j-a)]=true;
        }

        int size =(int)(b-a+1);
        int answer=0;

        for(int i=0;i<size;++i)
            answer += (eratos[i]==true)?1:0;
        System.out.print(size-answer);

        sc.close();
    }
}
