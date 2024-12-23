function solution(priorities, location) {
    const queue = priorities.map((priority, index) => ({priority, index}));
    const sorted = priorities.sort((a, b) => b - a);
    let cnt = 0;
    
    while(queue.length) {
        const curr = queue.shift();
        
        if(curr.priority < sorted[cnt]) {
            queue.push(curr);
            
        } else {
            cnt++;
            if(curr.index === location) return cnt;
        }
    }
}
