function solution(board) {
    const n = board.length;
    const m = board[0].length;
    const dr = [-1, 0, 1, 0];
    const dc = [0, 1, 0, -1];
    
    const visited = Array.from({length: n}, () => Array.from({length: m}).fill(false));
    
    const queue = [];
    const end = [];
    
    for(let r = 0; r < n; r++) {
        for(let c = 0; c < m; c++) {
            if(board[r][c] === "R") {
                queue.push([r, c, 0]);
                visited[r][c] = true;
                
            } else if(board[r][c] === "G") {
                end.push(r);
                end.push(c);
                
                // 목적지 주위 4방향에 멈출 수 있는 곳이 없으면 불가능임
                let isPossible = false;
                
                for(let d = 0; d < 4; d++) {
                    const nr = r + dr[d];
                    const nc = c + dc[d];
                    
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                        if(board[nr][nc] === "D") isPossible = true;
                    } else isPossible = true;
                }
                
                if(!isPossible) return -1;
            }
        }
    }
    
    let answer = 0;
    
    while(queue.length) {
        const [currR, currC, currCount] = queue.shift();
        
        // 목적지에 도달하면
        if(currR === end[0] && currC === end[1]) {
            answer = currCount;
            break;
        }
        
        for(let d = 0; d < 4; d++) {
            let nr = currR + dr[d];
            let nc = currC + dc[d];
            
            // 멈출 때까지 굴리기
            while(nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] !== "D") {
                nr += dr[d];
                nc += dc[d];
            }
            
            // 한 칸 더 간 상태라서 빼주기
            nr -= dr[d];
            nc -= dc[d];
            
            // 방문체크
            if(!visited[nr][nc]) {
                visited[nr][nc] = true;
                queue.push([nr, nc, currCount + 1]);
            }
        }
    }
    
    // 그래도 도달 불가능한지 체크
    return answer === 0 ? -1 : answer;
}
