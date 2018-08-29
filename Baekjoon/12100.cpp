#include <stdio.h>
#include <iostream>
#include <queue>
#define MAX_SIZE 25
using namespace std;
 
int n;
int map[MAX_SIZE][MAX_SIZE];
int ret;

void merge(int d) {
    queue<int> q;
    int cnt = 0;

    switch (d){
    case 0:
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[j][i] != 0) q.push(map[j][i]);
                map[j][i] = 0;
            }
 
            int idx = 0;
            int pop_data;
 
            while (!q.empty()){
                pop_data = q.front();
                q.pop();
 
                if (map[idx][i] == 0) map[idx][i] = pop_data;
                else if (map[idx][i] == pop_data){
                    map[idx][i] *= 2;
                    idx++;
                }
                else map[++idx][i] = pop_data;
            }
 
        }
        break;
    case 1:
        for (int i = 0; i < n; i++){
            for (int j = n - 1; j >= 0; j--){
                if (map[j][i] != 0) q.push(map[j][i]);
                map[j][i] = 0;
            }
 
            int idx = n - 1;
            int pop_data;
 
            while (!q.empty()){
                pop_data = q.front();
                q.pop();
 
                if (map[idx][i] == 0) map[idx][i] = pop_data;
                else if (map[idx][i] == pop_data){
                    map[idx][i] *= 2;
                    idx--;
                }
                else map[--idx][i] = pop_data;
            }
        }
        break;
        
    case 2:
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] != 0) q.push(map[i][j]);
                map[i][j] = 0;
            }
 
            int idx = 0;
            int pop_data;
 
            while (!q.empty()){
                pop_data = q.front();
                q.pop();
 
                if (map[i][idx] == 0) map[i][idx] = pop_data;
                else if (map[i][idx] == pop_data){
                    map[i][idx] *= 2;
                    idx++;
                }
                else map[i][++idx] = pop_data;
            }
        }
        break;
 
    case 3:
        for (int i = 0; i < n; i++){
            for (int j = n - 1; j >= 0; j--){
                if (map[i][j] != 0) q.push(map[i][j]);
                map[i][j] = 0;
            }
 
            int idx = n - 1;
            int pop_data;
 
            while (!q.empty()){
                pop_data = q.front();
                q.pop();
 
                if (map[i][idx] == 0) 
                    map[i][idx] = pop_data;
                else if (map[i][idx] == pop_data){
                    map[i][idx] *= 2;
                    idx--;
                }
                else map[i][--idx] = pop_data;
            }
        }
        break;
    }
}
 
void copy(int(*arr)[MAX_SIZE], int(*arr2)[MAX_SIZE]){
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            arr[i][j] = arr2[i][j];
}
 
void dfs(int d) {
    if (d == 5){
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (map[i][j] > ret) ret = map[i][j];
        return;
    }
 
    int copymap[MAX_SIZE][MAX_SIZE];
    copy(copymap, map);
 
    for (int i = 0; i < 4; i++){
        merge(i);
        dfs(d + 1);
        copy(map, copymap);
    }
}

int main(){
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &map[i][j]);

    dfs(0);
    printf("%d\n", ret);
    
    return 0;
}
