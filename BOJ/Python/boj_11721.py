N = input()

times = int(len(N)/10)
remains = len(N) - 10 * times

for x in range(times):
    print(N[x*10 : (x+1) * 10])

if remains !=0 :
    print(N[times * 10:])