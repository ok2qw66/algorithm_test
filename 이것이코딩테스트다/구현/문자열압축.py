def solution(s):
    answer = len(s)
    
    for base_count in range(int(len(s)/2) + 1, 0, -1):
        temp_answer = 0
        idx = 0
        while idx < len(s) :
            count_idx = [0,0]
            word = s[:base_count]
            
            while word == s[count_idx[1] : count_idx[1]+base_count]:
                count_idx[1] += base_count
                count_idx[0] += 1
                print(count_idx)
            
            if count_idx[0] > 1:
                temp_answer += len(str(count_idx[0])) + len(word)
            else : 
                temp_answer += len(s[idx:])
                break
            idx = count_idx[1]
            print("idx ", idx)
        print(base_count, temp_answer)
        if temp_answer < answer : return temp_answer
           
    return answer


print(solution("aabbaccc"))