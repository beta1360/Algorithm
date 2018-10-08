#include <iostream>
#include <stdio.h>
#include <cmath>
#include <algorithm>
using namespace std;

double f(double x, double y, double k){
    double A = sqrt(x*x - k*k);
    double B = sqrt(y*y - k*k);
    return A*B / (A + B);
}

int main(void){
    double x, y, c;
    cin >> x >> y >> c;

    double start = 0;
    double fin = min(x,y);
    double d;

    while (!((fin - start) < 0.0001)){
        d = (start + fin) / 2;

        if (f(x, y, d) > c) start = d;
        else fin = d;
    }

    printf("%.3f\n", d);
    return 0;
}
