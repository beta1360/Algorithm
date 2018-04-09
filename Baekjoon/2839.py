kilo = int(input())
min = 5000

n5 = 0
n3 = 0
n = 0

for i in range(0, int(kilo/5) + 1) :
    n5 = 0
    temp = kilo - i*5
    n5 = n5 + i
    if temp % 3 == 0 :
        n3 = int(temp/3)
        n = n3 + n5
        if n < min:
            min = n


if min == 5000:
    print(-1)
else :
    print(n)
