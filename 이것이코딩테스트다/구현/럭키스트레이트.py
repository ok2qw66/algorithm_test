score = list(map(int, input()))
if sum(score[:int(len(score)/2)]) *2 == sum(score):
    print("LUCKY")
else:
    print("READY")