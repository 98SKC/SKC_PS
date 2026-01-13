//js 연습

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split(/\s+/);

let idx = 0;

// 첫 줄: 입력 받기 연습
const T = parseInt(input[idx++], 10);
const X = parseInt(input[idx++], 10);

// 두 번째 줄: 실제 조원 수 N
const N = parseInt(input[idx++], 10);

let canAttendAll = true;

for (let i = 0; i < N; i++) {
  // 첫 번째 줄: 조원이 참석 가능한 교시 개수 K
  const K = parseInt(input[idx++], 10);

  // 다음 줄: 참석 가능한 교시 리스트
  const times = input.slice(idx, idx + K).map(Number);
  idx += K;

  if (!times.includes(X)) {
    canAttendAll = false;
  }
}

console.log(canAttendAll ? "YES" : "NO");
