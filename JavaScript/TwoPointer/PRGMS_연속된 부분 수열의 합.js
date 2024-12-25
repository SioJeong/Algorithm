function solution(sequence, k) {
    let answer = [];
    let left = 0;
    let right = 0;
    let sum = sequence[0];
    let minLength = Infinity;
    
    while(right < sequence.length) {
        // 합이 k와 같을 때
        if(sum === k) {
            const currLength = right - left + 1;
            
            // 현재 부분수열의 길이가 찾은 부분수열의 길이보다 짧다면 교체
            if(currLength < minLength) {
                minLength = currLength;
                answer = [left, right];
            }
            
            sum -= sequence[left];
            left++;
        
        // 합이 k랑 다를 때
        } else {
            // k보다 작다면 
            if(sum < k) {
                right++;
                sum += sequence[right];
                
            // k보다 크다면
            } else {
                sum -= sequence[left];
                left++;
            }
        }
    }
    
    return answer;
}
