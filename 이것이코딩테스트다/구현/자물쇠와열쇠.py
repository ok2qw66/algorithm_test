# 회전
# 0,0 -> 1,2
# 0,0 -> 2,-1
# 0,0 -> -1,-2  
# 0,0 -> -2,1

def solution(key, lock):
    def findAnswer(r, c, N):
        for keyLoc in keyLocList:
            change = [[] for _ in range(4)]
            for x,y in keyLoc:
                change[0].append([r+x,c+y])   
                change[1].append([r+y,c-x])   
                change[2].append([r-x,c-y])   
                change[3].append([r-y,c+x])   
            
            for c_row in change:
                # print(c_row)
                fullCnt = 0
                for cr in c_row:
                    if cr[0] < 0 or cr[0] >= N or cr[1] < 0 or cr[1] >= N : continue
                    # print(idx, c, lock[c[0]][c[1]])
                    if lock[cr[0]][cr[1]] == 0:
                        fullCnt += 1
                    else :
                        break
                # print(fullCnt)
                if fullCnt + currentSum == total:
                    return True
            
        return False


    
    currentSum = sum([sum(row) for row in lock])
    total = len(lock)*len(lock)
    
    if total == currentSum : return True
    
    keySet = []
    
    for r, row in enumerate(key):
        for c, hole in enumerate(row):
            if hole == 1:
                keySet.append([r,c])
    
    if len(keySet) + currentSum < total : return False
    
    keyLocList = [[] for _ in range(len(keySet))]
    # print(keyLocList)
    for idx in range(len(keySet)) :
        baseKey = keySet[idx]
        for key in keySet:
            keyLocList[idx].append([key[0]-baseKey[0],key[1]-baseKey[1]])
    
    for r, row in enumerate(lock):
        for c, hole in enumerate(row):
            if hole == 0 :
                if findAnswer(r,c, len(lock)) == True:
                    return True
    
    return False