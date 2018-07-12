import java.io.*;

public class Main {
    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int index = 0;
        boolean isAvaible = true;

        while(index < S.length() && isAvaible){
            if(index + 1 < S.length())
                if(S.substring(index, index+2).equals("pi")) {
                    index += 2;
                    continue;
                }
            if(index + 1 < S.length())
                if(S.substring(index, index+2).equals("ka")) {
                    index += 2;
                    continue;
                }


            if(index + 2 < S.length())
                if(S.substring(index, index+3).equals("chu")) {
                    index += 3;
                    continue;
                }

            isAvaible = false;
        }

        if(isAvaible) bw.write("YES\n");
        else bw.write("NO\n");

        br.close();
        bw.close();
    }
}
