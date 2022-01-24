N = int(input())
answer = 1
for x in range(N,0, -1):
    answer *= x

print(answer)