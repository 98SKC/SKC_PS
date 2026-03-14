# [Silver I] Leap Frog - 7655 

[문제 링크](https://www.acmicpc.net/problem/7655) 

### 성능 요약

메모리: 92292 KB, 시간: 776 ms

### 분류

그리디 알고리즘

### 제출 일자

2026년 3월 14일 23:20:29

### 문제 설명

<p>Jack and Jill play a game called “Leap Frog” in which they alternate turns jumping over each other. Both Jack and Jill can jump a maximum horizontal distance of 10 units in any single jump. You are given a list of valid positions x<sub>1</sub>, x<sub>2</sub>, . . . , x<sub>n</sub> where Jack or Jill may stand. Jill initially starts at position x<sub>1</sub>, Jack initially starts at position x<sub>2</sub>, and their goal is to reach position x<sub>n</sub>.</p>

<p>Determine the minimum number of jumps needed until either Jack or Jill reaches the goal. The two players are never allowed to stand at the same position at the same time, and for each jump, the player in the rear must hop over the player in the front.</p>

### 입력 

 <p>The input file will contain multiple test cases. Each test case will begin with a single line containing a single integer n (where 2 ≤ n ≤ 100000). The next line will contain a list of integers x<sub>1</sub> x<sub>2</sub> . . . x<sub>n</sub> where 0 ≤ x<sub>1</sub> < x<sub>2</sub> . . . < x<sub>n</sub> ≤ 1000000. The end-of-file is denoted by a single line containing “0”.</p>

### 출력 

 <p>For each input test case, print the minimum total number of jumps needed for both players such that either Jack or Jill reaches the destination, or -1 if neither can reach the destination.</p>

