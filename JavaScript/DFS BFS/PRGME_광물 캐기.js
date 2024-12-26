function solution(picks, minerals) {
    let min = Infinity;
    
    // 곡괭이 종류별, 광물 종류별 피로도 표
    const fatigueCosts = {
        diaPick:   { diamond: 1, iron: 1, stone: 1 },
        ironPick:  { diamond: 5, iron: 1, stone: 1 },
        stonePick: { diamond: 25, iron: 5, stone: 1 },
    };
    
    const dfs = (dia, iron, stone, idx, currPick, cnt, fatigue) => {
        // basecase 광물을 다 캤음        
        if(idx === minerals.length) {
            min = Math.min(min, fatigue);
            return;
        }
        
        // recursive
        const currMineral = minerals[idx];
        
        // 곡괭이 바꿔야할 때
        if(cnt === 5) {
            // basecase 남은 곡괭이가 없음
            if(!dia && !iron && !stone) {
                min = Math.min(min, fatigue);
                return;
            }
            
            // 곡괭이 바꾸기
            if(dia) dfs(dia - 1, iron, stone, idx + 1, "diaPick", 1, fatigue + 1);
                
            if(iron) {
                if(currMineral === "diamond") dfs(dia, iron - 1, stone, idx + 1, "ironPick", 1, fatigue + 5);
                else dfs(dia, iron - 1, stone, idx + 1, "ironPick", 1, fatigue + 1);
            }
            
            if(stone) {
                if(currMineral === "diamond") dfs(dia, iron, stone - 1, idx + 1, "stonePick", 1, fatigue + 25);
                else if(currMineral === "iron") dfs(dia, iron, stone - 1, idx + 1, "stonePick", 1, fatigue + 5);
                else if(currMineral === "stone") dfs(dia, iron, stone - 1, idx + 1, "stonePick", 1, fatigue + 1);
            }
            
        // 곡괭이 아직 쓸 수 있음
        } else dfs(dia, iron, stone, idx + 1, currPick, cnt + 1, fatigue + fatigueCosts[currPick][currMineral]);
    }
    
    if(picks[0]) dfs(picks[0] - 1, picks[1], picks[2], 0, "diaPick", 0, 0);
    if(picks[1]) dfs(picks[0], picks[1] - 1, picks[2], 0, "ironPick", 0, 0);
    if(picks[2]) dfs(picks[0], picks[1], picks[2] - 1, 0, "stonePick", 0, 0);
    
    return min;
}
