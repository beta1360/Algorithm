N = int(input())

for i in range(0,N):
    ox = input()
    point = 0
    isO = 0

    for j in range(0, len(ox)):
        if ox[j] == "O":
            isO = isO + 1
            point = point + isO

        else: #if ox[j] == "X":
            isO = 0

    print(point)
