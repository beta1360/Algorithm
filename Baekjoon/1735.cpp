#include <stdio.h>

int gcd(int temp[]) {
	
	int result;
	int t[2];

	t[0] = temp[0];
	t[1] = temp[1];

	if (t[1] > t[0]) {
		while (t[1] % t[0] != 0) {
			result = t[1] % t[0];
			t[1] = t[0];
			t[0] = result;
		}
	} else if (t[1] < t[0]) {
		while (t[0] % t[1] != 0) {
			result = t[0] % t[1];
			t[0] = t[1];
			t[1] = result;
		}
	}
	else {
		return t[1];
	}

	return result;
}

void FractionSum(int a[], int b[], int c[]) {

	int temp[2];
	int g;

	temp[1] = a[1] * b[1];
	temp[0] = a[0] * b[1] + a[1] * b[0];

	g = gcd(temp);

	c[0] = temp[0] / g;
	c[1] = temp[1] / g;
	
}

int main(void) {

	int a[2];
	int b[2];
	int c[2];

	scanf("%d %d", &a[0], &a[1]);
	scanf("%d %d", &b[0], &b[1]);

	FractionSum(a, b, c);

	printf("%d %d", c[0], c[1]);

	return 0;
}
