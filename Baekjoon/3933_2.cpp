#include <iostream>
#include <algorithm>

int main(void){
	int N;
	std::cin >> N;
	while (N > 0){
		int cnt = 0;

		for (int i = 1; i*i <= N; ++i){
			int r = N - i*i;
			if (r == 0) cnt++;
			for (int j = i; j*j <= r; ++j){
				int s = r - j*j;
				if (s == 0) cnt++;
				for (int k = j; k*k <= s; ++k){
					int t = s - k*k;
					if (t == 0) cnt++;
					for (int l = k; l*l <= t; ++l){
						int u = t - l*l;
						if (u == 0) cnt++;
					}
				}
			}
		}

		std::cout << cnt << '\n';
		std::cin >> N;
	}

	return 0;
}
