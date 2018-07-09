#include <stdio.h>

int main(){
    int key[5];
    int sum = 0;
    int total = 0;
    
    for(int i = 0; i < 5; i++) 
        scanf("%d", &key[i]);

    for(int i = 0; i < 5; i++){  
        sum = key[i] * key[i];
        total = total + sum;
    }
    
    printf("%d", total % 10);
}
