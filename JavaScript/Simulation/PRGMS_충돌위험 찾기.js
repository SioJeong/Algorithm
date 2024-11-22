function solution(points, routes) {
    // 운송 포인트의 수
    const FINISH_STANDARD = routes[0].length - 1;
    // 현재 몇 번째 운송 지점인가
    const taskCount = new Array(routes.length).fill(0);
    // 현재 어느 좌표에 있는가
    const currPosition = Array.from({length: routes.length}, () => [0, 0]);
    // 운송이 끝난 로봇인가
    const isFinished = new Array(routes.length).fill(false);
    
    // 초기 좌표 설정
    for(let i = 0; i < routes.length; i++) {
        currPosition[i] = points[routes[i][0] - 1].map((el) => el - 1);
    }
    
    // 운송이 전부 끝났는지 확인하는 함수
    const isAllFinished = () => {
        for(const count of taskCount) {
            if(count < FINISH_STANDARD) return false;
        }
        return true;
    }
    
    // 충돌 확인 함수
    const checkCrash = () => {
        const set = new Set();
        const crashPointSet = new Set();
        
        for(let i = 0; i < currPosition.length; i++) {
            if(!isFinished[i]) {
                const position = `${currPosition[i][0]}, ${currPosition[i][1]}`;
                
                if(set.has(position)) {
                    crashPointSet.add(position);           
                } else {
                    set.add(position);
                }
                
                if(taskCount[i] === FINISH_STANDARD) isFinished[i] = true;
            }
            
        }
        return crashPointSet.size;
    }
    
    // 초기 값으로 최초 충돌 확인 
    let answer = checkCrash();
    
    // 운송 시작
    while(!isAllFinished()) {
        for(let i = 0; i < routes.length; i++) {
            if(taskCount[i] === FINISH_STANDARD) continue;
            
            const currR = currPosition[i][0];
            const currC = currPosition[i][1];
            const nextR = points[routes[i][taskCount[i] + 1] - 1][0] - 1;
            const nextC = points[routes[i][taskCount[i] + 1] - 1][1] - 1;
            
            if(currR !== nextR) {
                if(currR > nextR) currPosition[i][0]--;
                else currPosition[i][0]++;
            } else {
                if(currC > nextC) currPosition[i][1]--;
                else currPosition[i][1]++;
            }
            
            if(currPosition[i][0] === nextR && currPosition[i][1] === nextC) taskCount[i]++;
        }
        
        answer += checkCrash();
    }
    
    return answer;
}
