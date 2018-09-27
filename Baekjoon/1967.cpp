#include <iostream>
#include <vector>
#include <string.h>
using namespace std;

int N, d = 0;
int startNode = 0; 
bool visit[10002];
vector<pair<int, int>> node[10002];

void dfs(int start, int weight){
	if (visit[start])
		return;

	visit[start] = true;
	if (d < weight){
		d = weight;
		startNode = start;
	}

	for (int i = 0; i < node[start].size(); ++i){
		dfs(node[start].at(i).first, weight+node[start].at(i).second);
	}
}

int main(){
	cin >> N;

	for (int t = 0; t < N; ++t){
		int src, dest, w;
		cin >> src >> dest >> w;
		node[src].push_back(pair<int ,int>(dest,w));
		node[dest].push_back(pair<int, int>(src, w));
	}

	memset(visit, false, sizeof(visit));
	dfs(1, 0);

	memset(visit, false, sizeof(visit));
	d = 0;
	dfs(startNode, d);

	cout << d << endl;
	return 0;
}
