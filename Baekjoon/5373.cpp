#include <iostream>
#include <string>
#include <map>
 
using namespace std;
 
string Up[12] = { "f2", "f1", "f0", "l2", "l1", "l0", "b2", "b1", "b0", "r2", "r1", "r0" };
string Down[12] = { "f6", "f5", "f4", "r6", "r5", "r4", "b6", "b5", "b4", "l6", "l5", "l4" };
string Front[12] = { "u6", "u5", "u4", "r0", "r7", "r6", "d2", "d1", "d0", "l4", "l3", "l2" };
string Back[12] = { "u2", "u1", "u0", "l0", "l7", "l6", "d6", "d5", "d4", "r4", "r3", "r2" };
string Left[12] = { "u0", "u7", "u6", "f0", "f7", "f6", "d0", "d7", "d6", "b4", "b3", "b2" };
string Right[12] = { "u4", "u3", "u2", "b0", "b7", "b6", "d4", "d3", "d2", "f4", "f3", "f2" };
 
map<string, char> cube;
 
string order_sort[12];
string s_top[12];
 
string so = "ulfrbd";
string num = "012345678";
string color = "wgrboy";
 
void init() {
    for (int i = 0; i < so.size(); i++) {
        for (int j = 0; j < num.size(); j++) {
            string temp = "";
            temp += so[i];
            temp += num[j];
            cube[temp] = color[i];
        }
    }
}
 
void sort_init(char s) {
    for (int i = 0; i < 12; i++) {
        s_top[i] = "";
    }
    if (s == 'U') {
        for (int i = 0; i < 12; i++) {
            order_sort[i] = Up[i];
            string n = to_string(i);
            s_top[i] += 'u';
            s_top[i] += n;
        }
    }
    else if (s == 'D') {
        for (int i = 0; i < 12; i++) {
            order_sort[i] = Down[i];
            string n = to_string(i);
            s_top[i] += 'd';
            s_top[i] += n;
        }
    }
    else if (s == 'L') {
        for (int i = 0; i < 12; i++) {
            order_sort[i] = Left[i];
            string n = to_string(i);
            s_top[i] += 'l';
            s_top[i] += n;
        }
    }
    else if (s == 'R') {
        for (int i = 0; i < 12; i++) {
            order_sort[i] = Right[i];
            string n = to_string(i);
            s_top[i] += 'r';
            s_top[i] += n;
        }
    }
    else if (s == 'F') {
        for (int i = 0; i < 12; i++) {
            order_sort[i] = Front[i];
            string n = to_string(i);
            s_top[i] += 'f';
            s_top[i] += n;
        }
    }
    else if (s == 'B') {
        for (int i = 0; i < 12; i++) {
            order_sort[i] = Back[i];
            string n = to_string(i);
            s_top[i] += 'b';
            s_top[i] += n;
        }
    }
}
 
void rotate(char s) {
    sort_init(s);
    
    string col = "";
 
    for (int i = 0; i < 8; i++) {
        col += cube[s_top[i]];
    }
    
    int index = 0;
 
    for (int i = 2; i < 8; i++) {
        cube[s_top[i]] = col[index];
        index++;
    }
 
    cube[s_top[0]] = col[6];
    cube[s_top[1]] = col[7];
 
    index = 0;
 
    string temp = "";
    for (int i = 0; i < 12; i++) {
        temp += cube[order_sort[i]];
    }
 
    for (int i = 3; i < 12; i++) {
        cube[order_sort[i]] = temp[index];
        index++;
    }
 
    cube[order_sort[0]] = temp[9];
    cube[order_sort[1]] = temp[10];
    cube[order_sort[2]] = temp[11];
}
 
void rotate_back(char s) {
    sort_init(s);
 
    string col = "";
 
    for (int i = 0; i < 8; i++) {
        col += cube[s_top[i]];
    }
 
    int index = 2;
 
    for (int i = 0; i < 6; i++) {
        cube[s_top[i]] = col[index];
        index++;
    }
 
    cube[s_top[6]] = col[0];
    cube[s_top[7]] = col[1];
 
    string temp = "";
    for (int i = 0; i < 12; i++) {
        temp += cube[order_sort[i]];
    }
 
    index = 3;
 
    for (int i = 0; i < 9; i++) {
        cube[order_sort[i]] = temp[index];
        index++;
    }
 
    cube[order_sort[9]] = temp[0];
    cube[order_sort[10]] = temp[1];
    cube[order_sort[11]] = temp[2];
}
 
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int t;
    cin >> t;
 
    while (t--) {
        cube.clear();
        int n;
        cin >> n;
 
        init();
 
        for (int i = 0; i < n; i++) {
            string order;
            cin >> order;
 
            if (order[1] == '+') {
                rotate(order[0]);
            }
            else {
                rotate_back(order[0]);
            }
        }
        cout << cube["u0"] << cube["u1"] << cube["u2"] << '\n';
        cout << cube["u7"] << 'w' << cube["u3"] << '\n';
        cout << cube["u6"] << cube["u5"] << cube["u4"] << '\n';
    }
 
    return 0;
}
