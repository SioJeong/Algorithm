function solution(board) {
    const game = board.map(str => str.split(""));
    
    let oCnt = 0;
    let xCnt = 0;
    
    for(let r = 0; r < 3; r++) {
        for(let c = 0; c < 3; c++) {
            if(game[r][c] === "O") oCnt++;
            if(game[r][c] === "X") xCnt++;
        }
    }
    
    // X 개수가 더 많으면 불가능
    if(xCnt > oCnt) return 0;
    
    // O와 X 개수가 다를 때, 하나 이상 차이나면 불가능
    if(oCnt !== xCnt && oCnt !== xCnt + 1) return 0;
    
    let winCnt = 0;
    let oWin = false;
    let xWin = false;
    
    // 행 검사
    for(let r = 0; r < 3; r++) {
        if(game[r][0] === ".") continue;
        let cnt = 1;
        const start = game[r][0];
        
        for(let c = 1; c < 3; c++) {
            if(game[r][c] === start) cnt++;
        }
        
        if(cnt === 3) {
            winCnt++;
            if(start === "O") oWin = true;
            else xWin = true;
        }
    }
    
    // 열 검사
    for(let c = 0; c < 3; c++) {
        if(game[0][c] === ".") continue;
        let cnt = 1;
        const start = game[0][c];
        
        for(let r = 1; r < 3; r++) {
            if(game[r][c] === start) cnt++;
        }
        
        if(cnt === 3) {
            winCnt++;
            if(start === "O") oWin = true;
            else xWin = true;
        }
    }
    
    // 대각선 검사
    if(game[1][1] !== ".") {
        if(game[0][0] === game[1][1] && game[1][1] === game[2][2]) {
            winCnt++;
            if(game[1][1] === "O") oWin = true;
            else xWin = true;
        }
        if(game[0][2] === game[1][1] && game[1][1] === game[2][0]) {
            winCnt++;
            if(game[1][1] === "O") oWin = true;
            else xWin = true;
        }
    }
    
    // O와 X가 동시에 이길 때
    if(oWin && xWin) return 0
    
    // O가 이겼을 땐 반드시 xCnt 보다 1개 많아야 함
    if(oWin) {
        if(oCnt !== xCnt + 1) return 0;
        
    // X가 이겼을 땐 수가 같아야 함
    } else if(xWin) {
        if(xCnt !== oCnt) return 0;
    }
    
    return 1
}
