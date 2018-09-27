#include <iostream>
#include <queue>
#include <vector>
using namespace std;

const int INF = 987654321;
int n, m, start, dest;

int main() {
	scanf("%d %d", &n, &m);

	vector < vector<pair<int, int>>> v(n + 1);
	vector<int> dist(n + 1);

	for (int i = 1; i <= n; i++)
		dist[i] = INF;
	

	for (int i = 0; i < m; i++) {
		int a, b, c;
		scanf("%d %d %d", &a, &b, &c);
		v[a].push_back({ b, c });
	}

	scanf("%d %d", &start, &dest);

	priority_queue<pair<int, int>> pq;
	pq.push({ start, 0 });
	dist[start] = 0;

	while (!pq.empty()) {
		int now = pq.top().first;
		int cost = -pq.top().second;
		pq.pop();

		if (dist[now] < cost) continue;
		
		for (int i = 0; i < v[now].size(); i++) {
			int next = v[now][i].first;
			int w = v[now][i].second;

			if (dist[now] != INF && dist[next] > dist[now] + w) {
				dist[next] = dist[now] + w;
				pq.push({ next, -dist[next] });
			}
		}

	}
	printf("%d\n", dist[dest]);

	return 0;
}
