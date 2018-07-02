import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] tree = new int[26][2];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int x = (int)(st.nextToken().charAt(0) - 'A');
            char y = st.nextToken().charAt(0);
            char z = st.nextToken().charAt(0);
            if (y == '.') tree[x][0] = -1;
            else tree[x][0] = y-'A';

            if (z == '.') tree[x][1] = -1;
            else tree[x][1] = z-'A';

        }

        preorder(tree,0);
        System.out.println();
        inorder(tree,0);
        System.out.println();
        postorder(tree,0);
        System.out.println();

        br.close();
    }


    private static void preorder(int[][] a, int x) {
        if(x == -1)return;
        System.out.print((char)(x+'A'));
        preorder(a, a[x][0]); // Left
        preorder(a, a[x][1]); // Right

    }

    private static void inorder(int[][] a, int x) {
        if(x == -1)return;
        inorder(a, a[x][0]); // Left
        System.out.print((char)(x+'A'));
        inorder(a, a[x][1]); // Right

    }

    private static void postorder(int[][] a, int x) {
        if(x == -1)return;
        postorder(a, a[x][0]); // Left
        postorder(a, a[x][1]); // Right
        System.out.print((char)(x+'A'));

    }
}
