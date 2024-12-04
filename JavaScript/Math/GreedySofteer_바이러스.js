const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});


rl.on('line', (line) => {
    let answer = 0;
    const MOD = 1000000007n;
    let [k, p, n] = line.split(" ").map(BigInt);

    for(let i = 1; i <= n; i++) {
        k = k * p % MOD
    }

    answer = k;
    
    console.log(answer.toString());
});


