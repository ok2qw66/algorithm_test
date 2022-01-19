T = int(input())

for _ in range(T):
    a,b = list(map(int,input().split()))

    if a%10 == 0:
        print('10')
    else :
        caseList = []
        temp = a%10
        test = a%10
        count = 0

        while test not in caseList:
            caseList.append(test)
            # print(caseList)
            test = (test*temp)%10
            count += 1

        answer = caseList[b % len(caseList) -1]%10
        print(answer)
