#include <bits/stdc++.h>
using namespace std;

void topological(int vertex, int edges){
    vector<int> adj[vertex];
    vector<int> indegree(vertex, 0);
    while(edges--){
        int s, e;
        scanf("%d %d", &s, &e);
        adj[s-1].push_back(e-1);
        indegree[e-1] += 1;
    }
     
    priority_queue<int, vector<int>, greater<int>> q;
    
    for(int i=0; i<vertex; ++i){
        if(indegree[i] == 0)
            q.push(i);
    }
     
    while(!q.empty()){
        int node = q.top();
        q.pop();
        printf("%d ", node+1);
        for(int i=0; i<adj[node].size(); ++i){
            int nextNode = adj[node][i];
            indegree[nextNode] -= 1;
            if(indegree[nextNode] == 0) q.push(nextNode);
        }
    }
}

int main(){
    int n, m;
    scanf("%d %d", &n, &m);
    
    topological(n, m);
    return 0;
}
