#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

typedef pair<int, int> P;
int A, B, cnt;

int num[20];
vector<int> vt;

int func(P a, P b) {
	if (a.first == a.second && b.first == b.second) {
		if (a.first > b.first) return 0;
		else return 1;
    }

	else if (a.first == a.second && b.first != b.second) 
		return 0;
	

	else if (a.first != a.second && b.first == b.second) 
		return 1;
	

	else {
		if ((a.first + a.second) % 10 > (b.first + b.second) % 10) 
			return 0;
        
		else return 1;
	}
}

void dfs(int d) {

	if (d == 2) {
		if (func(P(A, B), P(vt[0], vt[1])) == 0) {
			cnt++;
		}
		return;
	}

	for (int i = 0; i < 20; i++) {
		if (num[i] == B) continue;

		vt.push_back(num[i]);
		dfs(d + 1);
		vt.pop_back();
	}
}

int main(void) {
	scanf("%d %d", &A, &B);

	for (int i = 0; i < 10; i++) 
		num[i] = i + 1;
	
	for (int i = 10; i < 20; i++) 
		num[i] = i - 9;
	
	cnt = 0;

	for (int i = 0; i < 20; i++) {
		if (num[i] == A) continue;

		vt.push_back(num[i]);
		dfs(1);
		vt.pop_back();
	}
	
	if (A == B) printf("%.3f\n", (double)(cnt / 2 - (A-1))/ 153.0);
	else printf("%.3f\n", (double)(cnt/2) / 153.0);

	return 0;
}
