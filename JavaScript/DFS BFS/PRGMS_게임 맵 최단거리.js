function solution(maps) {
    const dr = [-1, 0, 1, 0];
    const dc = [0, 1, 0, -1];
    const visited = Array.from(new Array(maps.length), () => new Array(maps[0].length).fill(false));
    const queue = [];
    
    visited[0][0] = true;
    queue.push([0, 0, 1]);
    let answer = -1;
    
    while(queue.length) {
        const [currR, currC, currDist] = queue.shift();
        
        if(currR == (maps.length - 1) && currC == (maps[0].length - 1)) {
            answer = currDist;
            break;
        }
        
        for(let d = 0; d < 4; d++) {
            const nr = currR + dr[d];
            const nc = currC + dc[d];
            
            if(nr >= 0 && nr < maps.length  && nc >= 0 && nc < maps[0].length && maps[nr][nc] && !visited[nr][nc]) {
                visited[nr][nc] = true;
                queue.push([nr, nc, currDist + 1]);
            }
        }
    }
    
    return answer;
}
