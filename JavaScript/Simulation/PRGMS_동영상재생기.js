function solution(video_len, pos, op_start, op_end, commands) {
    // 시간 문자열을 초로 바꾸는 함수
    const timeToSec = ((timeString) => {
        const [min, sec] = timeString.split(":").map(Number);
        
        return min * 60 + sec;
    })
    
    // 초를 시간 문자열로 바꾸는 함수
    const secToTime = ((second) => {
        const min = Math.floor(second / 60).toString().padStart(2, "0");
        const sec = (second % 60).toString().padStart(2, "0");
        
        return `${min}:${sec}`;
    })
    
    // 오프닝 시작 시간, 종료 시간
    const openingStart = timeToSec(op_start);
    const openingEnd = timeToSec(op_end);
    
    // 오프닝 범위 안에 있는지
    const isOpening = ((time) =>{
        if(openingStart <= time && time <= openingEnd) {
            return openingEnd;
        }
        
        return time;
    });
    
    // 동영상이 끝나는 시간
    const endPoint = timeToSec(video_len);
    
    // 커맨드 작동
    const opera = ((time, command) => {
        if(command === "prev") {
            time = Math.max(time - 10, 0);
            
        } else if(command === "next") {
            time = Math.min(time + 10, endPoint);
        }
        
        return isOpening(time);
    })
    
    let currentTime = isOpening(timeToSec(pos));
    
    for(const command of commands) {
        currentTime = opera(currentTime, command);
    }
    
    return secToTime(currentTime);
}
