#include <iostream>
#include <string>
using namespace std;

int main() {
    string in;
    cin >> in;
    for (int i = 0; i < in.size(); i++)
        if (in[i] >= 65 && in[i] <= 90)
            cout << in[i];
    
    return 0;
}
