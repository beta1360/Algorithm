import java.io.*;
import java.util.Stack;

public class Solution {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; ++t){
            int num = getNum(br.readLine());

            sb.append("#").append(t+1)
                    .append(" ").append(num).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static int getNum(String str){
        Stack[] stack = new Stack[5];
        for(int i=0; i<5; ++i)
            stack[i] = new Stack<Character>();

        for(int i=0; i<str.length(); ++i){
            char cur = str.charAt(i);

            if(cur == 'c') {
                if(stack[4].empty())
                    stack[0].push('c');
                else{
                    stack[0].push(stack[4].pop());
                }
            }
            else if(cur == 'r' && !stack[0].empty())
                stack[1].push(stack[0].pop());
            else if(cur == 'o' && !stack[1].empty())
                stack[2].push(stack[1].pop());
            else if(cur == 'a' && !stack[2].empty())
                stack[3].push(stack[2].pop());
            else if(cur == 'k' && !stack[3].empty())
                stack[4].push(stack[3].pop());
            else
                return -1;
        }

        if(stack[0].empty() && stack[1].empty() && stack[2].empty() && stack[3].empty())
            return stack[4].size();
        else return -1;
    }
}
