# 출처 : https://www.acmicpc.net/problem/1100
# 홀수/짝수 줄에 따라 시작점 지정하고
# 2칸씩 건너뛰면서 값 체크

N = [list(map(str, input().split())) for _ in range(8)]

answer = 0
#print(N)

for n,l in zip(range(8),N):
    # print(n," -> ",l[0])
    start = n%2
    for x in range(start,8,2):
        # print("x=",x," ",l[0][x])
        if l[0][x] == 'F':
            answer += 1
    # print(answer)        
# print("============")
print(answer)
