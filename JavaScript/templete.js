const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")

// 리눅스에서 입력: 줄바꿈 이스케이프(\n)만 제거
const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 윈도우에서 입력: 캐리지 리턴(\r) 추가로 제거해줘야 함
// const input = fs.readFileSync('test.txt').toString().trim().split('\n').map(line => line.trim());

// 풀이
function solution(arr) {
  const [a, b] = arr[0].split(' ');
  return Number(a) + Number(b);
}

console.log(solution(input));

// const fs = require('fs');
// // TODO: 제출 시 경로 변환 필수 ("/dev/stdin")

// 리눅스에서 입력: 줄바꿈 이스케이프(\n)만 제거
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

// 윈도우에서 입력: 캐리지 리턴(\r) 추가로 제거해줘야 함
// const input = fs.readFileSync('test.txt').toString().trim().split('\n').map(line => line.trim());

// // 정리
// /* ex.
// const x = Number(input[0]);
// const [y, z] = input[1].split(' ').map(v => Number(v));
// const arr = input[2].split(' '); 
// */
// // 풀이
// function solution(x, y, z, arr) {
//   const answer = [];
//   return answer.join('\n');
// }

// console.log(solution(x, y, z, arr));