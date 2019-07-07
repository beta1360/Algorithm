#include <stdio.h>

int main(){
    int a,b;
    int n3, n4, n5;
    
    scanf("%d", &a);
    scanf("%d", &b);
    
    n5 = a * (b/100);
    n4 = a * ((b - (b/100)*100)/10);
    n3 = a * (b%10);
    
    printf("%d\n%d\n%d\n%d\n", n3, n4, n5, a*b);
    
    return 0;
}
