#include <iostream>
#include <vector>
#include <string.h>
using namespace std;

int V, d = 0, startNode = 0;
vector<pair<int, int>> node[100001];
bool visit[100001];

void dfs(int start, int cost){
	if (visit[start]) return;

	if (d < cost){
		d = cost;
		startNode = start;
	}

	visit[start] = true;

	for (int i = 0; i < node[start].size(); ++i)
		if (!visit[node[start].at(i).first])
			dfs(node[start].at(i).first, cost + node[start].at(i).second);
	
}

int main(){
	cin >> V;
	for (int v = 1; v <= V; ++v){
		int dest, src;
		cin >> src;
		cin >> dest;
		while (dest != -1){
			int w;
			cin >> w;
			node[src].push_back(pair<int, int>(dest, w));
			node[dest].push_back(pair<int, int>(src, w));

			cin >> dest;
		}
	}

	memset(visit, false, sizeof(visit));
	dfs(1, 0);

	memset(visit, false, sizeof(visit));
	d = 0;
	dfs(startNode, 0);

	cout << d << endl;

	return 0;
}
