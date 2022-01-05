import sys
input = lambda : sys.stdin.readline().rstrip()

queue = []

times = int(input())

for _ in range(times):
    oper, *num = input().split(" ")
    
    if oper == "push":
        queue.append(num[0])
    elif oper == "pop":
        if len(queue) == 0:
            print("-1")
        else:
            print(queue.pop())
    elif oper == "top":
        if len(queue) == 0:
            print("-1")
        else:
            print(queue[-1])
    elif oper == "size":
            print(len(queue))
    else : #empty
        if len(queue) == 0:
            print("1")
        else:
            print("0")
