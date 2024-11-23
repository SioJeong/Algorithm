function solution(diffs, times, limit) {
    const puzzleLen = diffs.length;
    
    // 퍼즐을 풀 수 있는가 확인하는 함수
    const isPossibleSolvePuzzle = (level) => {
        let currTime = 0;
        
        for(let i = 0; i < puzzleLen; i++) {
            // 퍼즐 난이도가 숙련도 보다 같거나 낮은 경우
            if(level >= diffs[i]) {
                currTime += times[i];
            
            // 퍼즐 난이도가 숙련도 보다 높은 경우
            } else {
                const trialCount = diffs[i] - level;
                currTime += trialCount * (times[i - 1] + times[i]) + times[i];
            }
            
            if(currTime > limit) return false;
        }
        
        return true;
    }
    
    let left = 1;
    
    // 30만 사이즈 배열은 스프레드 연산자 사용 시 호출 스택 초과
    // let right = Math.max(...diffs);
    
    let right = -123456789;
    for(diff of diffs) {
        right = Math.max(diff, right);
    }

    let answer = right;
    
    // 이분탐색
    while(left <= right) {
        const mid = Math.floor((left + right) / 2);
        
        if(isPossibleSolvePuzzle(mid)) {
            answer = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    
    return answer;
}

// 시간초과 코드
// function solution(diffs, times, limit) {
//     const puzzleLen = diffs.length;
    
//     let level = 1;
//     let currPuzzle = 0;
//     let currTime = 0;
    
//     // 마지막 퍼즐이 될 때 까지
//     while(currPuzzle < puzzleLen) {
//         for(let i = 0; i < puzzleLen; i++) {
//             // 내 숙련도보다 낮은 퍼즐
//             if(level >= diffs[i]) {
//                 currTime += times[i];
            
//             // 내 숙련도보다 높은 퍼즐
//             } else {
//                 const trialCount = diffs[i] - level;
//                 currTime += trialCount * (times[i - 1] + times[i]) + times[i];
//             }
//             // 다음 퍼즐로
//             currPuzzle++;
            
//             // 만약 현재의 시간이 limit을 넘어버리면
//             // 숙련도 증가해서 처음부터
//             if(currTime > limit) {
//                 currPuzzle = 0;
//                 currTime = 0;
//                 level++;
//                 break;
//             }
//         }
//     }
    
//     return level;
// }
