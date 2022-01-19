T = int(input())

for _ in range(T):
    a,b = list(map(int,input().split()))

    total = pow(a,b)

    total %= 10

    if total == 0:
        print('10')
    else:
        print(total)
