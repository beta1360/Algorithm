import java.util.Comparator;
import java.util.Vector;

class Solution {
    public int[] solution(int N, int[] stages) {
        int dp[][] = new int[501][2];
        Vector<Pair> v = new Vector<>();

        for(int i=1; i<501; ++i)
            dp[i][0] = dp[i][1] = 0;

        for (int stage : stages)
            dp[stage][0]++;


        dp[500][1] = dp[500][0];

        for(int i=499; i>0; --i)
            dp[i][1] = dp[i][0] + dp[i+1][1];

        for(int i=1; i<=N; ++i) {
            if(dp[i][1] != 0) 
                v.add(new Pair(i, (double) dp[i][0] / dp[i][1]));
             else 
                v.add(new Pair(i, 0));
        }

        v.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Double.compare(o2.fail, o1.fail);
            }
        });

        int answer[] = new int[N];
        int index = 0;

        for(Pair aV: v) 
            answer[index++] = aV.i;
        
        return answer;
    }
    
    class Pair {
        int i;
        double fail;

        Pair(int i, double fail){
            this.i =i;
            this.fail = fail;
        }
    }
}
