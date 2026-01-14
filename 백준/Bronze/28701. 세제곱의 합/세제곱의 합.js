//아주 간단한 백준 문제를 풀며 문법 적응

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split(/\s+/);

let idx=0;

// 첫 줄: 입력 받기 연습
const N = parseInt(input[idx++], 10);

const answer1=function(N){
    let num=1;
    let answer=0;
    while(num<=N){
        answer+=num++;
    }
    return answer;
}

const answer2=function(N){
    let num=1;
    let answer=0;
    while(num<=N){
        answer+=num++;
    }
    return answer*answer;
}

const answer3=function(N){
    let num=1;
    let answer=0;
    while(num<=N){
        answer+=num*num*num;
        num++;
    }
    return answer;
}
console.log(answer1(N));
console.log(answer2(N));
console.log(answer3(N));
