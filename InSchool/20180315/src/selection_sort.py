def selection_sort(a):
    n = len(a)
    for i in range(n-1):
        for j in range(i+1,n):
            if a[i] > a[j]:
                a[i],a[j] = a[j],a[i]
    return a


d = [6, 8, 3, 9, 10, 1, 2, 4, 7, 5]
print(selection_sort(d))
