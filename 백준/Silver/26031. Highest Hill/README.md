# [Silver III] Highest Hill - 26031 

[문제 링크](https://www.acmicpc.net/problem/26031) 

### 성능 요약

메모리: 50848 KB, 시간: 252 ms

### 분류

구현, 브루트포스 알고리즘

### 제출 일자

2026년 1월 29일 09:10:39

### 문제 설명

<p>Sweden may not have a particularly impressive mountain range compared to other NCPC countries such as Norway and Iceland, but at least it beats the flatlands of Denmark. The situation is not so clear when comparing other member countries though. For example, is Estonia more mountainous than Lithuania? To settle this question, you want to determine which of the two countries has the most impressive mountain peak.</p>

<p>A mountain range is defined by sampling the heights $h_i$ of $n$ equidistant points. Within a mountain range, we call a triple of indices $1 \le i < j < k \le n$ a <em>peak</em> if $h_i \leq \cdots \leq h_j \geq \cdots \geq h_k$. The <em>height</em> of a peak is defined as the smaller of $h_j - h_i$ and $h_j-h_k$.</p>

<p>Given a mountain range, can you find the height of its highest peak?</p>

### 입력 

 <p>The first line contains a single integer $N$ ($3 \le n \le 200\,000$), the number of sampled points of the mountain range.</p>

<p>The second and final line contains the heights $h_1, \dots, h_N$ ($0 \le h_i \le 318 \cdot 10^9$) of the sampled points, in nanometers above sea level.</p>

<p>It is guaranteed that the mountain range contains at least one peak.</p>

### 출력 

 <p>Output a single integer: the height of the highest peak.</p>

