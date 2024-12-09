function solution(want, number, discount) {
    let answer = 0;
    const wish = {};
    
    for(let i = 0; i < want.length; i++) {
        wish[want[i]] = number[i];
    }
    
    for(let i = 0; i <= discount.length - 10; i++) {
        const count = {};
        
        for(let j = i; j < i + 10; j++) {
            count[discount[j]] = (count[discount[j]] || 0) + 1;
        }
        
        if(Object.keys(wish).every((item) => wish[item] === count[item])) answer++;
    }
    
    return answer;
}
