#include <iostream>
using namespace std;

int main() {
    int num;
    cin >> num;
    if (num == 1) cout << '*';
    for (int i = 1; i < num; i++) {
        for (int t = 1; t <= num - i; t++)
            cout << " ";
        
        for (int j = 1; j <= i * 2 - 1; j++) {
            if (j == 1 || j == i * 2 - 1) {
                cout << "*";
                continue;
            }
            else {
                cout << " ";
                continue;
            }    
        }
        cout << '\n';
        if (i + 1 == num)
            for (int i = 1; i <= num * 2 -1; i++)
                cout << "*";
    }
    
    return 0;
}
