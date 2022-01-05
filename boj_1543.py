content = input()
search = input()
count = 0
start = 0

while content.find(search,start) != -1:
    count += 1
    start = content.find(search,start) + len(search)
    # print(start)

print(count)