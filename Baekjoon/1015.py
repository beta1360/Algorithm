from bisect import *

n = int(raw_input())
a = map(int,raw_input().split())
b = list(a)
cnt = [0 for i in range(1002)]
a.sort()
ans = ''
for i in b:
    ans += str(bisect_left(a, i)+cnt[i])+' '
    cnt[i]+=1
 
print ans
