#include<stdio.h>

int seg[15][15]={0, };
int main(void){
    int T; 
    scanf("%d",&T);
    for(int i=0; i<T; i++){
        int k,n; 
        scanf("%d %d",&k,&n);
        for(int x=1; x<=n; x++) 
            seg[0][x] = x;
        
        for(int y=1; y<=k; y++){
            seg[y][1] = 1;
            for(int x=2; x<=n; x++)
                seg[y][x] = seg[y][x-1] + seg[y-1][x];
        }
        printf("%d\n",seg[k][n]);
    }
    return 0;
}
