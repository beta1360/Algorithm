import sys
 
T = sys.stdin.readline()
 
for i in range(0, int(T)):
  num = sys.stdin.readline().split()
  n1 = int(num[0])
  n2 = int(num[1])
  print(n1 + n2)
