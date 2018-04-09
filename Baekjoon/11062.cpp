#include <cstdio>
#include <algorithm>
using namespace std;

int s[1001];
int n, t;

int main(void) {
    while (scanf("%d", &t)) {
        int dp[1001];
        scanf("%d", &n);
        
        for (int i = 1; i <= n; i++){ 
            scanf("%d", s + i);
            s[i] += s[i - 1];
        }
        for (int i = 1; i <= n; i++) 
            for (int j = n; j >= i; j--) 
                dp[j] = s[j] - s[j - i] - min(dp[j - 1], dp[j]);
        
        printf("%d\n", dp[n]);
        t--;
    }
    return 0;
}
