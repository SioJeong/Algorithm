const fs = require('fs');
const input = fs.readFileSync('input.txt', 'utf8').trim().split(/\n+/);
const n = Number(input[0]);
const rocks = input[1].split(' ').map(Number);

const dp = Array(n).fill(1);

for (let i = 0; i < n; i++) {
  for (let j = 0; j < i; j++) {
    if (rocks[j] < rocks[i]) {
      dp[i] = Math.max(dp[i], dp[j] + 1);
    }
  }
}

console.log(Math.max(...dp));
