#include <iostream>
#include <cstdio>
#include <map>
 
using namespace std;
 
int dp[12];
map<long long, long long> mp;
 
long long dy(long long n)
{
    if (n == 1 || mp[n]) return mp[n];
 
    if (n % 2 == 1)
        mp[n] = dy(n / 2) + dy(n / 2 + 1) + (n / 2) * (n / 2 + 1);
    else
        mp[n] = dy(n / 2) + dy(n / 2) + (n / 2) * (n / 2);
 
    return mp[n];
}
int main()
{
    long long n;
 
    scanf("%lld", &n);
    mp[1] = 0;
    mp[2] = 1;
 
    dy(n);
 
    printf("%lld",mp[n]);
    return 0;
}
