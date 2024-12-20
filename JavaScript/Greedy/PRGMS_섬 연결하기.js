function solution(n, costs) {
    let answer = 0;
    costs.sort((a, b) => a[2] - b[2]);
    const parents = Array.from({length: n}).fill(null).map((_, i) => i);
    
    const getParent = (idx) => {
        if(parents[idx] === idx) return idx;
        parents[idx] = getParent(parents[idx]);
        return parents[idx]; 
    }
    
    const union = (start, end) => {
        const p1 = getParent(start);
        const p2 = getParent(end);
        
        if(p1 < p2) parents[p2] = p1;
        else parents[p1] = p2;
    }
    
    for(const c of costs) {
        const[start, end, cost] = c;
        
        if(getParent(start) !== getParent(end)) {
            answer += cost;
            union(start, end);
        }
    }
    
    return answer;
}
