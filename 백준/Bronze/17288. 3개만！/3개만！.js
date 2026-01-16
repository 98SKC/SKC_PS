//아주 간단한 백준 문제를 풀며 문법 적응

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split(/\s+/);

//입력을 1차원 배열로 받아서, idx만큼 요소가 있음.
let idx = 0;

//1234567이 들어왔을때 한자리로 나누어 배열을 만들려면?
let arr=input[idx++].split("").map(Number);

let length=arr.length;

let result=0;

let pos=0;

function search(pos){
    let answer=1; //연속된 숫자의 개수  
    for(let i=pos+1;i<length;i++){
        if(arr[i]-arr[i-1]==1) answer++;
        else break;
    }
    return answer;
}

for(let i=0;i<length;i++){
    let jump=search(i);
    if(jump==3){
        result++;
    }
    i+=jump-1;
    //
}

console.log(result);