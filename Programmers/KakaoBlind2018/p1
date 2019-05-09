def solution(record):
    answer = []
    user = dict()
    log = []
    
    for r in record:
        info = r.split(' ')
        
        if info[0] == 'Enter':
            if info[1] not in user.keys():
                user[info[1]] = info[2]
            else: 
                user[info[1]] = info[2]
            log.append(['님이 들어왔습니다.',info[1]])
            
        elif info[0] == 'Leave':
            log.append(['님이 나갔습니다.',info[1]])
            
        elif info[0] == 'Change':
            user[info[1]] = info[2]
    for line in log:
        answer.append(user[line[1]] + line[0])
        
    return answer
