import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 탈옥 : BFS
 * https://www.acmicpc.net/problem/9376
 */

class Point {
    public int y;
    public int x;

    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
	private static final int INIT = -1;
    private static final int BLANK = 0;
    private static final int WALL = -1;
    private static final int PRISONER = 1;
    private static final int DOOR = 2;
    private static final int NONE = -5;

    private static final int[] dY = {0, -1, 0, 1};
    private static final int[] dX = {-1, 0, 1, 0};

    private static int[][] map = new int[105][105];
    private static int h, w;
    
    private static int[] result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int T;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        result = new int[T];
        
        for(int t = 0; t < T; t++) {
            Point helper = new Point(0, 0);
            Point prisoner1 = new Point(NONE, NONE);
            Point prisoner2 = new Point(NONE, NONE);

            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken()) + 2;
            w = Integer.parseInt(st.nextToken()) + 2;

            for (int i = 1; i < h - 1; i++) {
                String s = "." + br.readLine() + ".";
                for (int j = 0; j < w; j++) {

                    char c = s.charAt(j);
                    switch (c) {
                        case '.':
                            map[i][j] = BLANK;
                            break;
                        case '*':
                            map[i][j] = WALL;
                            break;
                        case '#':
                            map[i][j] = DOOR;
                            break;
                        case '$':
                            map[i][j] = PRISONER;
                            if (prisoner1.y == NONE) prisoner1 = new Point(i, j);
                            else prisoner2 = new Point(i, j);
                            break;
                    }
                }
            }
            for (int j = 0; j < w; j++) {
                map[0][j] = map[h - 1][j] = BLANK;

            }
                
            int[][] visit_helper = bfs(helper);
            int[][] visit_prisoner1 = bfs(prisoner1);
            int[][] visit_prisoner2 = bfs(prisoner2);

            int answer = h * w;
            int temp = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == WALL) continue;

                    temp = visit_helper[i][j] + visit_prisoner1[i][j] + visit_prisoner2[i][j];
                    if (map[i][j] == DOOR) temp -= 2;

                    if (answer > temp)
                    	answer = temp;
                }
            }
            result[t] = answer;

        }
        
        for(int i = 0; i < T; i++)
        	System.out.println(result[i]);
    } 

    public static int[][] bfs(Point start) {
        int[][] visit = new int[h][w];
        for (int i = 0; i < h; i++) 
            Arrays.fill(visit[i], INIT);
        
        Queue<Point> queue = new LinkedList<Point>();

        queue.add(start);
        visit[start.y][start.x] = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = cur.y + dY[i];
                int nextX = cur.x + dX[i];
                
                // out of range
                if (nextY < 0 || nextY >= h || nextX < 0 || nextX >= w) continue;
                
                // the WALL of range
                if (map[nextY][nextX] == WALL) continue;

                // If BLANK or PRISONER (no cost)
                if (map[nextY][nextX] == BLANK || map[nextY][nextX] == PRISONER) {
                    if (visit[nextY][nextX] == INIT || visit[nextY][nextX] > visit[cur.y][cur.x]) {
                    	visit[nextY][nextX] = visit[cur.y][cur.x];
                        queue.add(new Point(nextY, nextX));
                    }
                } 
                else if (map[nextY][nextX] == DOOR) {
                    if (visit[nextY][nextX] == INIT || visit[nextY][nextX] > visit[cur.y][cur.x] + 1) {
                    	visit[nextY][nextX] = visit[cur.y][cur.x] + 1;
                        queue.add(new Point(nextY, nextX));
                    }
                }
            }
        }
        return visit;
    }
}
