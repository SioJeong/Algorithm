function solution(n, times) {
    times.sort((a, b) => a - b);
    
    let left = 1;
    let right = times[times.length - 1] * n;
    let answer = right;
    
    while(left <= right) {
        const mid = Math.floor((left + right) / 2);
        let cnt = 0;
        
        for(time of times) {
            cnt += Math.floor(mid / time);
        }
        
        if(cnt >= n) {
            right = mid - 1;
            answer = Math.min(answer, mid);
        } else left = mid + 1;
    }
    
    return answer;
}
