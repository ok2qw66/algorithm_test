inputList = list(map(str, input()))

inputList.sort() # 숫자 -> 알파벳 순으로 정렬

#아스키코드는 1~9 ... A B C .... 이므로
#아스키코드가 9이하인 것만 numberList에 포함
number = [int(x) for x in inputList if x <= '9'] 
# 나머지 자리값들은 alphabet에 포함
alpabet = inputList[len(number):]

print(''.join(alpabet)+str(sum(number)))