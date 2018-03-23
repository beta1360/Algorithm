def quick_sort_worst(list):
    n = len(list)
    if n <= 1:
        return list

    pivot = list[-1]
    g1 = []
    g2 = []
    for i in range(0, n - 1):
        if list[i] < pivot:
            g1.append(list[i])
        else:
            g2.append(list[i])

    return quick_sort_worst(g1) + [pivot] + quick_sort_worst(g2)
