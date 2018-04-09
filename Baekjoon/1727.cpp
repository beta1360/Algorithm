#include <stdio.h>
#include <string.h>
using namespace std;

int main(void) {
	int number;
	int k = 10;
	char num[11];

	scanf("%d", &number);
	sprintf(num, "%d", number);

	int len = strlen(num);

	for (int i = 0; i < len; i++) {
		for (int j = i+1; j < len; j++) {
			if (num[i] < num[j]) {
				char temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			}
		}
	}

	printf("%s", num);

	return 0;
}
