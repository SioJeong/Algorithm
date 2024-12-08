// 이분탐색 풀이
function solution(stones, k) {
    let answer = 0;
    let left = 0;
    let right = 200000000;
    
    while(left <= right) {
        let mid = Math.floor((left + right) / 2);
        let cnt = 0;
        
        for(const stone of stones) {
            if(stone < mid) cnt++; // 못건너면
            else cnt = 0; // 건널 수 있으면 초기화
            
            if(cnt >= k) break;// 불가능
        }
        
        if(cnt >= k) {
            right = mid - 1;
            
        } else {
            answer = mid;
            left = mid + 1;
        }
    }
    
    return answer;
}

// 효율성 테스트 통과 X
// function solution(stones, k) {
//     let answer = 200000001;
    
//     outer: for(let i = 0; i <= stones.length - k; i++) {
//         let curr = 0;
        
//         for(let j = i; j < i + k; j++) {
//             // 이미 더 높은 수가 나오면 k만큼 돌 필요 없음
//             if(stones[j] > answer) continue outer;
            
//             curr = Math.max(curr, stones[j]);
//         }
        
//         answer = Math.min(answer, curr);
//     }
    
//     return answer;
// }
