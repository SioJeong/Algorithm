function solution(maze) {
    const n = maze.length;
    const m = maze[0].length;
    const map = Array.from(new Array(n), () => new Array(m).fill(0));
    const visitedRed = Array.from(new Array(n), () => new Array(m).fill(false));
    const visitedBlue = Array.from(new Array(n), () => new Array(m).fill(false));
    
    const dr = [-1, 0, 1, 0];
    const dc = [0, 1, 0, -1];
    
    const startRed = [];
    const startBlue = [];
    const endRed = [];
    const endBlue = [];
    
    for(let r = 0; r < n; r++) {
        for(let c = 0; c < m; c++) {
            switch(maze[r][c]) {
                case 1: startRed.push(r, c);
                        visitedRed[r][c] = true;
                        break;
                case 2: startBlue.push(r, c);
                        visitedBlue[r][c] = true;
                        break;
                case 3: endRed.push(r, c);
                        break;
                case 4: endBlue.push(r, c);
                        break;
                case 5: map[r][c] = -1;
            }
        }
    }
    
    let answer = 123456789;
    
    const dfs = (redR, redC, blueR, blueC, cnt, copyRed, copyBlue) => {
        // base case
        if(redR === endRed[0] && redC === endRed[1] && blueR === endBlue[0] && blueC === endBlue[1]) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        // recursive
        for(let d1 = 0; d1 < 4; d1++) {
            let redNR = redR + dr[d1];
            let redNC = redC + dc[d1];
            
            // 이미 도착했으면 고정
            if(redR === endRed[0] && redC === endRed[1]) {
                redNR = redR;
                redNC = redC;
                copyRed[redNR][redNC] = false;
            }
            
            // 경계 검사 & 방문한 곳이거나 벽이면 가지치기
            if(redNR < 0 || redNR >= n || redNC < 0 || redNC >= m || copyRed[redNR][redNC] || map[redNR][redNC] === -1) continue;
            
            for(let d2 = 0; d2 < 4; d2++) {
                let blueNR = blueR + dr[d2];
                let blueNC = blueC + dc[d2];
                
                // 이미 도착했으면 고정
                if(blueR === endBlue[0] && blueC === endBlue[1]) {
                    blueNR = blueR;
                    blueNC = blueC;
                    copyBlue[blueNR][blueNC] = false;
                }
                
                // 서로 맞바꾸는건 안됨
                if(redNR === blueR && redNC === blueC && blueNR === redR && blueNC === redC) continue;
                
                // 경계성 검사 & 방문한 곳이거나 벽이면 가지치기 & 같은 곳으로 이동 불가
                if(blueNR >= 0 && blueNR < n && blueNC >= 0 && blueNC < m && !copyBlue[blueNR][blueNC] && map[blueNR][blueNC] !== -1 && !(redNR === blueNR && redNC === blueNC)) {
                    copyRed[redNR][redNC] = true;
                    copyBlue[blueNR][blueNC] = true;
                    dfs(redNR, redNC, blueNR, blueNC, cnt + 1, copyRed, copyBlue);
                    copyRed[redNR][redNC] = false;
                    copyBlue[blueNR][blueNC] = false;
                }
            }
        }
    }
    
    dfs(startRed[0], startRed[1], startBlue[0], startBlue[1], 0, visitedRed, visitedBlue);
    
    return answer === 123456789 ? 0 : answer;
}
