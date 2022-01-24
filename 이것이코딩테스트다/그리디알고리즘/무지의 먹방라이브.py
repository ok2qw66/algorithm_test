######예진 코드 : 시 간 초 과######
def solution(food_times, k):
    timeMax = 0
    timeCnt = [0 for _ in range(100000001)]
    time = 0
    
    for food in food_times:
        timeCnt[food] += 1 #잔여시간 cnt 1증가
        timeMax = max(timeMax, food) #잔여시간 최대값 찾기
    
    lasFood = 0
    while k > time and timeMax > lasFood:
        lasFood += 1 #초
        time += timeCnt[lasFood] * lasFood
    
    k -= time + timeCnt[lasFood] * lasFood
    lasFood -= 1
    # print(lasFood,time, k)
    
    answer = 0
    while k > 0  :
        if food_times[answer] >= lasFood :
            k -= 1
        
    return answer+1