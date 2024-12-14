function solution(n, m, hole) {
    const map = Array.from(new Array(m), () => new Array(n).fill(false));
    
    for(const [c, r] of hole) map[r - 1][c - 1] = true;

    const visited = Array.from(new Array(m), () => Array.from(new Array(n), () => [false, false]));

    const dr = [-1, 0, 1, 0];
    const dc = [0, 1, 0, -1];

    const queue = [];
    queue.push([0, 0, 0, 0]); // 시작점 (0,0), 점프 안씀(0), 거리0
    visited[0][0][0] = true;

    while(queue.length) {
        const [r, c, jumped, dist] = queue.shift();
        
        // 목적지 도달
        if (r === m - 1 && c === n - 1) {
            return dist;
        }

        // 일반 이동
        for (let d = 0; d < 4; d++) {
            const nr = r + dr[d];
            const nc = c + dc[d];
            
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
            
            if (!map[nr][nc] && !visited[nr][nc][jumped]) {
                visited[nr][nc][jumped] = true;
                queue.push([nr, nc, jumped, dist + 1]);
            }
        }

        // 점프 이동
        if (jumped === 0) {
            for (let d = 0; d < 4; d++) {
                const nr2 = r + dr[d] * 2;
                const nc2 = c + dc[d] * 2;
                const nr = r + dr[d];
                const nc = c + dc[d];
                
                if (nr2 >= 0 && nr2 < m && nc2 >= 0 && nc2 < n && map[nr][nc] === true && map[nr2][nc2] === false && !visited[nr2][nc2][1]) {
                    visited[nr2][nc2][1] = true;
                    queue.push([nr2, nc2, 1, dist + 1]);
                }
            }
        }
    }

    // 도달 불가능한 경우
    return -1;
}
