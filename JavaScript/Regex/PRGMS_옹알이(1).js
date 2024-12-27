// function solution(babbling) {
//     let answer = 0;
    
//     outer: for(let i = 0; i < babbling.length; i++) {
//         let isPossible = false;
//         let idx = 0;
        
//         while(idx < babbling[i].length) {
//             const curr = babbling[i][idx];
//             const lastLength = babbling[i].length - idx;
            
//             if(curr === "a" && lastLength >= 3 && babbling[i][idx + 1] === "y" && babbling[i][idx + 2] === "a") {
//                 isPossible = true;
//                 idx += 3;
//             } else if(curr === "y" && lastLength >= 2 && babbling[i][idx + 1] === "e") {
//                 isPossible = true;
//                 idx += 2;
//             } else if(curr === "w" && lastLength >= 3 && babbling[i][idx + 1] === "o" && babbling[i][idx + 2] === "o") {
//                 isPossible = true;
//                 idx += 3;
//             } else if(curr === "m" && lastLength >= 2 && babbling[i][idx + 1] === "a") {
//                 isPossible = true;
//                 idx += 2;
//             } else {
//                 continue outer;
//             }
//         }
        
//         if(isPossible) answer++;
//     }
    
//     return answer;
// }

// 배열 고차함수
// function solution(babbling) {
//   const word = ['aya', 'ye', 'woo', 'ma'];

//   return babbling.map((str) => {
//       for (const w of word) {
//         if (str.includes(w)) {
//           str = str.replace(w, ' ');
//         }
//       }
//       return str;
//     }).filter((str) => !str.trim()).length;
// }

// 정규표현식
function solution(babbling) {
  const pattern = /^(?:aya|ye|woo|ma)+$/;
  let answer = 0;
  
  for (const word of babbling) {
    if (pattern.test(word)) {
      answer++;
    }
  }
  return answer;
}
