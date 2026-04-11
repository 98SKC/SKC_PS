# [Silver II] Fizz and Buzz - 23654 

[문제 링크](https://www.acmicpc.net/problem/23654) 

### 성능 요약

메모리: 13280 KB, 시간: 100 ms

### 분류

수학, 확률론

### 제출 일자

2026년 4월 11일 20:08:34

### 문제 설명

<p>Two dwarves, Fizz and Buzz, compose a sequence of $n$ integers. Each element is constructed as follows. First, the friends toss a fair coin to choose who will create the next number: with probability $\frac{1}{2}$ it will be Fizz, and with probability $\frac{1}{2}$ it will be Buzz. After that, if the toss was in favor of Fizz, he considers all integers from $1$ to $10\,000$ divisible by $3$ and selects one of them at random. All these integers have the same probability of being selected. If the toss was in favor of Buzz, he considers all integers from $1$ to $10\,000$ divisible by $5$ and selects one of them at random. All these integers also have the same probability of being selected. All coin tosses and all integer selections are independent events.</p>

<p>The dwarves composed a sequence of $n$ integers by the rules outlined above. Given the resulting sequence, guess who created which number, and do not make too many errors in the process.</p>

### 입력 

 <p>The first line contains an integer $n$, the length of the sequence ($1 \le n \le 10\,000$). The second line contains the sequence itself: the integers $a_1$, $a_2$, $\ldots$, $a_n$ ($1 \le a_i \le 10\,000$). It is guaranteed that the sequence was composed according to the problem statement using a random number generator.</p>

### 출력 

 <p>Print a single line with $n$ characters each of which is either "<code>F</code>" or "<code>B</code>". In the perfect answer, the character at position $i$ must be "<code>F</code>" if the number $a_i$ was created by Fizz, or "<code>B</code>" if the number $a_i$ was created by Buzz. Your answer can contain at most $1200$ errors. In other words, it can differ from the perfect answer at no more than $1200$ positions.</p>

