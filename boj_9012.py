N = int(input())

for _ in range(N):
    line = list(list(input().split())[0])
    # print(line)
    
    answer = 0
    
    for x in line:
        if x == '(':
            answer += 1
        else:
            answer -= 1
            if answer < 0 :
                print('NO')
                break
    else:        
        if answer == 0:
            print('YES')
        else:
            print('NO')
               
