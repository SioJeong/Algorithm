function solution(maps) {
    const n = maps.length;
    const m = maps[0].length;
    
    const dr = [-1, 0, 1, 0];
    const dc = [0, 1, 0, -1];
    
    let startR = -1, startC = -1, endR = -1, endC = -1, leverR = -1, leverC = -1;
    
    for(let r = 0; r < n; r++) {
        for(let c = 0; c < m; c++) {
            const curr = maps[r][c];
            if(curr === "S") [startR, startC] = [r, c];
            else if(curr === "E") [endR, endC] = [r, c];
            else if(curr === "L") [leverR, leverC] = [r, c];
        }
    }    
    
    const isValid = (r, c) => r >= 0 && r < n && c >= 0 && c < m && maps[r][c] !== "X";
    
    const bfs = (startR, startC, endR, endC) => {
        const queue = [[startR, startC, 0]];
        let queueIndex = 0;
        const visited = Array.from({length: n}, () => Array.from({length: m}).fill(false));
        visited[startR][startC] = true;
        
        while(queueIndex < queue.length) {
            const [currR, currC, currDist] = queue[queueIndex++];
            
            if(currR === endR && currC === endC) {
                return currDist;
            }
            
            for(let d = 0; d < 4; d++) {
                const nr = currR + dr[d];
                const nc = currC + dc[d];
                
                if(isValid(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.push([nr, nc, currDist + 1]);
                }
            }
        }
    }
    
    let dist = 0;
    dist += bfs(startR, startC, leverR, leverC);
    dist += bfs(leverR, leverC, endR, endC);
    
    return dist ? dist : -1;
}
