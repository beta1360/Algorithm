#include <stdio.h>
using namespace std;

int place[100];

int main(void) {
	int k[3];
	int result = 0;

	scanf("%d %d %d", &k[0], &k[1], &k[2]);

	while (!(((k[0] + 1) == k[1])&&((k[1] + 1) == k[2]))) {
		if ((k[1] - k[0]) > (k[2] - k[1])) {
			k[2] = k[1] - 1;
		}
		else {
			k[0] = k[1] + 1;
		}
		if (k[0] > k[1]) {
			int temp = k[0];
			k[0] = k[1];
			k[1] = temp;
		}
		if (k[1] > k[2]) {
			int temp = k[1];
			k[1] = k[2];
			k[2] = temp;
		}
		if (k[0] > k[2]) {
			int temp = k[0];
			k[0] = k[2];
			k[2] = temp;
		}
		result++;
	}

	printf("%d", result);

	return 0;
}
