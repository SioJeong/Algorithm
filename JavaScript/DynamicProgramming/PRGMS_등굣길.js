function solution(m, n, puddles) {
    const map = Array.from(new Array(n), () => new Array(m).fill(false));
    
    for(const [c, r] of puddles) {
        map[r-1][c-1] = true;
    }
    
    const dist = Array.from(new Array(n), () => new Array(m).fill(Infinity));
    const cases = Array.from(new Array(n), () => new Array(m).fill(0));
    
    dist[0][0] = 0;
    cases[0][0] = 1;
    
    for(let r = 0; r < n; r++) {
        for(let c = 0; c < m; c++) {
            // 웅덩이면 pass
            if(map[r][c]) continue;
            
            const currDist = dist[r][c];
            
            // 위에서 오는 경로 확인
            if (r > 0 && dist[r-1][c] !== Infinity) {
                if (dist[r-1][c] + 1 < dist[r][c]) {
                    dist[r][c] = dist[r-1][c] + 1;
                    cases[r][c] = cases[r-1][c] % 1000000007;
                    
                } else if (dist[r-1][c] + 1 === dist[r][c]) {
                    cases[r][c] += cases[r-1][c] % 1000000007;
                }
            }

            // 왼쪽에서 오는 경로 확인
            if (c > 0 && dist[r][c-1] !== Infinity) {
                if (dist[r][c-1] + 1 < dist[r][c]) {
                    dist[r][c] = dist[r][c-1] + 1;
                    cases[r][c] = cases[r][c-1] % 1000000007;
                    
                } else if (dist[r][c-1] + 1 === dist[r][c]) {
                    cases[r][c] += cases[r][c-1] % 1000000007;
                }
            }
        }
    }
    
    return cases[n-1][m-1] % 1000000007;
}
