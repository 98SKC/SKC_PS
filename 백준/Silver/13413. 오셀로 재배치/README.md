# [Silver IV] 오셀로 재배치 - 13413 

[문제 링크](https://www.acmicpc.net/problem/13413) 

### 성능 요약

메모리: 90116 KB, 시간: 308 ms

### 분류

그리디 알고리즘, 문자열

### 제출 일자

2024년 11월 21일 23:43:24

### 문제 설명

<p>로봇을 좋아하는 세희는 로봇동아리에서 카메라와 센서, 라즈베리 파이, 집게발을 이용해 로봇을 완성하였다. 이 로봇을 통해서 오셀로 재배치라는 작업을 하려고 한다. 오셀로 말은 앞면이 검정, 뒷면이 흰색으로 된 말이다. 세희의 목표는 로봇을 이용하여 처음 배치된 오셀로 말을 주어진 형태로 바꾸는 일을 하는 것이다. 아래의 예시를 참고하자.</p>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>초기 상태</th>
			<th>목표 상태</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>○●●○○</td>
			<td>○●○●○</td>
		</tr>
	</tbody>
</table>

<p>세희는 로봇을 이용해 2가지 작업 중 하나를 골라 진행할 수 있다.</p>

<ol>
	<li>배치된 말 중 임의의 2개의 말을 골라 서로의 위치를 바꾼다.</li>
	<li>말 1개를 들어 뒤집어 놓아 색상을 변경한다.</li>
</ol>

<p>위의 예시에서, 3번째와 4번째 말을 2번 작업을 통해 각각 뒤집으면 2번의 작업으로 목표 상태를 만들 수 있다. 하지만 1번 작업을 통해 3번째와 4번째 말을 골라 서로의 위치를 바꾸어주면 1번 만에 목표 상태에 도달할 수 있다. 초기 상태의 말과 목표 상태의 말이 주어질 때, 목표 상태에 도달할 수 있는 최소 횟수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 구성된다. 각 입력의 첫 번째 줄에는 오셀로 말의 개수 N(1 ≤ N ≤ 100,000)이 주어진다. 각 입력의 두 번째 줄과 세 번째 줄에는 각각 오셀로 말의 초기 상태와 목표 상태가 주어진다. 초기 상태와 목표 상태의 말의 개수는 항상 N과 일치한다. 흰색 면이 보이는 경우에는 W, 검은색 면이 보이는 경우에는 B로 주어진다.</p>

### 출력 

 <p>출력은 표준 출력을 사용한다. 입력받은 데이터에 대해, 한 줄에 1개씩 초기 상태에서 목표 상태를 만들기 위한 작업의 최소 횟수를 구한다.</p>

