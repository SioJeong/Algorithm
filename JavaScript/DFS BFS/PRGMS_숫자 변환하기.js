function solution(x, y, n) {
    let answer = -1;
    
    const visited = Array.from({length: 1000001}).fill(false);
    const queue = [];
    queue.push([y, 0]);
    
    while(queue.length) {
        const [num, cnt] = queue.shift();
        
        if(num === x) {
            answer = cnt;
            break;
        }
        
        
        if(num - n >= x) {
            const next = num - n;
            
            if(!visited[next]) {
                visited[next] = true;
                queue.push([next, cnt + 1]);
            }
                
        }
        if(num % 2 === 0) {
            const next = Math.floor(num / 2);
            
            if(!visited[next]) {
                visited[next] = true;
                queue.push([next, cnt + 1]);
            }
        }
        if(num % 3 === 0) {
            const next = Math.floor(num / 3);
            
            if(!visited[next]) {
                visited[next] = true;
                queue.push([next, cnt + 1]);
            }
        }
    }
    
    return answer;
}
