S = input()
answer = int(S[0])

for n in S[1:]:
    n = int(n)
    if answer+n > answer*n:
        answer = answer+n
    else:
        answer = answer*n

print(answer)