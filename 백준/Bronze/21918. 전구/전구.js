//아주 간단한 백준 문제를 풀며 문법 적응

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split(/\s+/);


let one=((i,x)=>{

    arr[i]=x;

});

let two=((l,r)=>{
    for(let i=l;i<=r;i++){
        arr[i]=(arr[i]+1)%2;
    }
});

let three=((l,r)=>{
    for(let i=l;i<=r;i++){
        arr[i]=0;
    }
});

let four=((l,r)=>{
    for(let i=l;i<=r;i++){
        arr[i]=1;
    }
});

let idx=0;

// 첫 줄: 입력 받기 연습
const N = parseInt(input[idx++], 10); //전구 개수
const M = parseInt(input[idx++], 10); //명령어 개수

//N개의 전구가 켜져있다. 인덱스는 1부터 시작.
//전구의 상태는 두개

//명령어가 4가지
//1. i번째 전구의 상태를 x로 변경한다.
//2. l~r의 전구 상태를 바꾼다.
//3. l~r을 모두 끈다.
//4. l~r을 모두 킨다.

//주어진 명령을 모두 실행 후 상태 (0이 꺼짐, 1이켜짐)

let arr=[];
 arr.push(-1);
for(let i=1;i<=N;i++){
    arr.push(parseInt(input[idx++], 10));
}
let a,b,c;
for(let i=1;i<=M;i++){
    a=parseInt(input[idx++], 10);
    b=parseInt(input[idx++], 10);
    c=parseInt(input[idx++], 10);

    if(a==1) one(b,c);
    else if(a==2) two(b,c);
    else if(a==3) three(b,c);
    else  four(b,c);
        
}

console.log(arr.slice(1).join(" "));
