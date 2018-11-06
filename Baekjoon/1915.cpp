#include <iostream>
#include <stdio.h>
using namespace std;

int b[1001][1001], dp[1001][1001];

int min(int a, int b, int c){
    a = a < b ? a : b;
    return a < c ? a : c;
}

int main(){
    int n, m, k = 0;
    cin >> n >> m;

    for (int i = 1; i <= n; ++i){
        string tmp;
        cin >> tmp;
        for (int j = 1; j <= m; ++j) b[i][j] = (int)tmp.at(j-1) - 48;
    }

    for (int i = 1; i <= n; ++i)
        for (int j = 1; j <= m; ++j)
            if (b[i][j] == 1){
                dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
                k = k > dp[i][j] ? k : dp[i][j];
            }

    cout << k*k << endl;
    return 0;
}
