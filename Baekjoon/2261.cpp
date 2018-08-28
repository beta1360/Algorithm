#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>
#include <map>
#include <vector>
#define inf 100000000
using namespace std;
 
typedef pair<int, int> p;
map<p, int> mp;
 
double getDist(p a, p b) {
    int x = a.first - b.first;
    int y = a.second - b.second;
 
    return (double)(x*x + y*y);
}
 
int main() {
    int n;
    scanf("%d", &n);
 
    vector<p> vc;
 
    for (int i = 0; i < n; i++) {
        int x, y;
        scanf("%d %d", &x, &y);
 
        vc.push_back({ x,y });
    }
 
    sort(vc.begin(), vc.end());
 
    mp[{vc[0].second, vc[0].first}] = 1;
    mp[{vc[1].second, vc[1].first}] = 1;
 
    double ans = getDist(vc[0], vc[1]);
 
    int end = 0;
 
    for (int i = 2; i < n; i++) {
        while (end < i) {
            int dx = vc[i].first - vc[end].first;
            if (dx * dx <= ans) break;
            mp.erase({ vc[end].second, vc[end].first });
            end++;
        }
        int limit = sqrt(ans);
 
        auto lo = mp.lower_bound({ vc[i].second - limit, -inf });
        auto up = mp.upper_bound({ vc[i].second + limit,  inf });
 
        for (auto it = lo; it != up; it++)
            ans = min(ans, getDist({ it->first.second, it->first.first }, vc[i]));
 
        mp[{vc[i].second, vc[i].first}] = 1;
    }
 
    printf("%d", (int)ans);
    return 0;
}
