function solution(tickets) {
    console.log(tickets.sort())
    // tickets.sort((a, b) => a[1].localeCompare(b[1]));
    let isDone = false;
    const visited = new Array(tickets.length).fill(false);
    let answer = [];
    
    const dfs = (start, arr, idx) => {
        if(isDone) return;
        
        // basecase
        if(arr.length === tickets.length) {
            isDone = true;
            answer = [...arr, tickets[idx][1]];
            
            return;
        }
        
        //recursive
        for(let i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0] === start) {
                visited[i] = true;
                dfs(tickets[i][1], [...arr, tickets[i][0]], i);
                visited[i] = false;
            }
        }
        
    }
    
    dfs("ICN", [], 0);
    
    return answer;
}
