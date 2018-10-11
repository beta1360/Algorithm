import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String gear[];
    static StringBuilder sb;
    static int K;

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        gear = new String[5];
        sb = new StringBuilder();
        for(int i=1; i<=4; ++i) gear[i] = br.readLine();

        K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            setGears(index, d);
        }

        bw.write(getScore()+"\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static void rotateGear(int index, int d){
        String tmp;
        char last;

        if(d == 1){
            tmp = gear[index].substring(0, 7);
            last = gear[index].charAt(7);
            gear[index] = last + tmp;
        } else {
            tmp = gear[index].substring(1, 8);
            last = gear[index].charAt(0);
            gear[index] = tmp + last;
        }
    }

    private static void setGears(int index, int d){
        boolean diff[] = new boolean[3];

        for(int i=0; i<3; ++i)
            if(gear[i+1].charAt(2) != gear[i+2].charAt(6))
                diff[i] = true;

        rotateGear(index, d);

        switch (index){
            case 1:
                for(int i=0; i<3; ++i){
                    if(diff[i]) rotateGear(i+2, (int)Math.pow(-1, i+1) * d);
                    else break;
                }
                break;

            case 2:
                if(diff[0]) rotateGear(1, -1 * d);

                if(diff[1]) {
                    rotateGear(3, -1 * d);
                    if(diff[2]) rotateGear(4, d);
                }
                break;

            case 3:
                if(diff[2]) rotateGear(4, -1 * d);

                if(diff[1]) {
                    rotateGear(2, -1 * d);
                    if(diff[0]) rotateGear(1, d);
                }
                break;

            default:
                for(int i=2; i>=0; --i){
                    if(diff[i]) rotateGear(i+1, (int)Math.pow(-1, i+1) * d);
                    else break;
                }
                break;
        }
    }

    private static int getScore(){
        int p = 0;

        for(int i=1; i<=4; ++i)
            if(gear[i].charAt(0) == '1')
                p += Math.pow(2, i - 1);

        return p;
    }
}
