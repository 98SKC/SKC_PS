# [Silver II] Gratitude - 21208 

[문제 링크](https://www.acmicpc.net/problem/21208) 

### 성능 요약

메모리: 132884 KB, 시간: 980 ms

### 분류

자료 구조, 문자열, 정렬, 집합과 맵, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵

### 제출 일자

2026년 2월 13일 09:00:18

### 문제 설명

<p>Ben heard about studies by Emmons and McCullough that suggest that intentionally practicing gratitude has a lasting effect on people's happiness. Since he wants to be happy too, he decided that at the end of each day he will think back over the past day and write down three things he is thankful for, one thing per line. At the end of $N$ days in which he practiced this exercise, he was curious to know which things appear the most on his list. Help Ben get the $K$ things he was grateful for most frequently.</p>

### 입력 

 <p>The input begins with one line containing two space-separated integers, $N$ and $K$, in that order. Then follow $3N$ lines containing Ben's notes from $N$ days. You may assume that the three lines that correspond to the same day contain no repetitions. That is, if you partition the input into $N$ chunks of $3$ consecutive lines, no chunk contains two identical lines.</p>

### 출력 

 <p>The output should represent the list of things that Ben is grateful for, ordered by frequency of appearance in Ben's list (with the most frequent item first). In case of two items with equal frequency, the most recent item should appear first. That is, in case of a tie in the number of appearances, the item whose last appearance is later in the input should appear earlier in the output. Finally, if there are more than $K$ different items in Ben's list, your output should contain only the $K$ first items (according to the required order).</p>

