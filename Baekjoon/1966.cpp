#include <iostream>
#include <cstdio>
#include <queue>
 
using namespace std;
 
typedef pair<int, int> pii;
 
int main()
{
    int T;
    scanf("%d", &T);
 
    while (T--)
    {
        int n, pos;
        
        scanf("%d %d", &n, &pos);
 
        deque<pii> dq; 
        priority_queue<int> pq;
 
        for (int i = 0; i < n; i++)
        {
            int val;
            scanf("%d", &val);
            dq.push_back({ val, i });
            pq.push(val);
        }
 
        int cnt = 1;
        while(!dq.empty())
        {
            if (pq.top() > dq.front().first)
            {
                dq.push_back(dq.front());
                dq.pop_front();
            }
 
            else
            {
                if (dq.front().second == pos)
                {
                    printf("%d\n", cnt);
                    break;
                }
                dq.pop_front();
                pq.pop();
                cnt++;
            }
            
        }
    }
    return 0;
}
