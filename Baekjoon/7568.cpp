#include <stdio.h>
using namespace std;

#define MAX_N 50

typedef struct people {
	int weight;
	int height;
} people;

int main(void) {

	people p[MAX_N];
	int N;
	int result[MAX_N];

	scanf("%d", &N);

	for (int i = 0; i < N; i++) 
		scanf("%d %d", &p[i].weight, &p[i].height);

	for (int i = 0; i < N; i++)
		result[i] = 1;
	
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if ((p[i].weight > p[j].weight) && (p[i].height > p[j].height)) {
				result[j]++;
			}
		}
	}

	for (int i = 0; i < N; i++)
		printf("%d ", result[i]);
	
	return 0;
}
