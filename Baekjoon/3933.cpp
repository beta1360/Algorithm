#include <iostream>
#include <algorithm>

int cnt;

void sub_sol(int N, int i, int icnt){
    int r = N - i*i;
    if((r == 0) && (icnt <= 4)) cnt++;
    else if((r > 0)&&(icnt <= 4))
        for(int j=i; j*j<=N; ++j)
            sub_sol(r, j, icnt+1);
              
    else return;
}

void solution(int N){
    int cnt = 0;
    for(int i=1; i*i<=N; ++i)
        sub_sol(N, i, 1);  
}

int main(){
    int N;
    std::cin >> N;

    while(N > 0){
        cnt = 0;
        solution(N);
        std::cout << cnt << "\n";
        std::cin >> N;
    }

    return 0;
}
