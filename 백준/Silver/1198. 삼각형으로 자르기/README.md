# [Silver II] 삼각형으로 자르기 - 1198 

[문제 링크](https://www.acmicpc.net/problem/1198) 

### 성능 요약

메모리: 11760 KB, 시간: 68 ms

### 분류

수학, 브루트포스 알고리즘, 기하학

### 제출 일자

2025년 6월 23일 11:22:48

### 문제 설명

<p>볼록 다각형이 있고, 여기서 3개의 연속된 점을 선택해서 삼각형을 만든다. 그 다음, 만든 삼각형을 다각형에서 제외한다. 원래 다각형이 N개의 점이 있었다면, 이제 N-1개의 점으로 구성된 볼록 다각형이 된다. 위의 과정은 남은 다각형이 삼각형이 될 때까지 반복한다.</p>

<p>볼록 다각형의 점이 시계 방향순으로 주어진다. 마지막에 남은 삼각형은 여러 가지가 있을 수 있다. 이때, 가능한 넓이의 최댓값을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 볼록 다각형 점의 수 N (3 ≤ N ≤ 35)이 주어진다. 둘째 줄부터 N개의 줄에는 볼록 다각형을 이루고 있는 점이 시계 방향 순서로 주어진다. 좌표는 10,000보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>첫째 줄에 문제의 정답을 출력한다. 절대/상대 오차는 10<sup>-9</sup>까지 허용한다.</p>

