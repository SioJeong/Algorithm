function solution(people, limit) {
    people.sort((a, b) => a - b);
    
    let cnt = 0;
    let left = 0, right = people.length - 1;
    
    while (left <= right) {
        // 가장 가벼운 사람과 가장 무거운 사람을 함께 태울 수 있다면
        if (people[left] + people[right] <= limit) {
            left++;
        }
        // 가장 무거운 사람을 태움
        right--;
        cnt++;
    }
    
    return cnt;
}
