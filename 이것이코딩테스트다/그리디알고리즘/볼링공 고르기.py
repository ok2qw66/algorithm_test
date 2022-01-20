N, M = list(map(int, input().split()))
ballList = list(map(int, input().split())) #입력2번째줄
answer = 0
ballCnt = [0 for _ in range(M+1)]  #ballCnt[x]=공번호x의 개수
ballUniqueList = set() #unique한 공번호 집합

for ball in ballList: #공번호를 개수+1, 집합에 추가
    ballCnt[ball] += 1
    ballUniqueList.add(ball)

ballUniqueList = list(ballUniqueList) #idx사용하기 위해 list로 변환

# 조합
for start_idx in range(1,len(ballUniqueList)):
    startBall = ballCnt[start_idx] #공번호 start_idx의 개수
    for end_idx in range(start_idx+1, len(ballUniqueList)+1):
        endBall = ballCnt[end_idx] #공번호 end_idx의 개수
        answer += startBall * endBall

print(answer)