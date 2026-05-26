# GitHub Contribution 미반영 확인 기록

## 1. 확인 목적

GitHub 저장소에는 커밋이 정상적으로 올라가 있지만, 프로필 contribution graph에는 해당 날짜의 잔디가 찍히지 않는 문제가 있었다.

확인하려던 내용은 다음과 같다.

- 커밋이 로컬 저장소에 존재하는지
- 커밋이 원격 저장소 `origin/main`에 반영되어 있는지
- 커밋 작성자 정보가 GitHub 계정과 연결된 이메일인지
- AuthorDate와 CommitDate가 다른지
- GitHub 커밋 목록에서는 해당 날짜 커밋이 조회되는지
- 그럼에도 contribution graph에는 반영되지 않는지

---

## 2. 최근 커밋 목록 확인

### 사용 명령어

```bash
git log --oneline -10
```

### 확인 결과

최근 커밋 목록에 아래 커밋들이 존재했다.

```text
[COMMIT_HASH] (HEAD -> main, origin/main, origin/HEAD) [level 0] Title: n의 배수 고르기, Time: 0.04 ms, Memory: 60.6 MB -BaekjoonHub
[COMMIT_HASH] [level 0] Title: 배열의 유사도, Time: 0.02 ms, Memory: 60.4 MB -BaekjoonHub
[COMMIT_HASH] [level 0] Title: 가장 큰 수 찾기, Time: 0.01 ms, Memory: 62.5 MB -BaekjoonHub
[COMMIT_HASH] [level 0] Title: 편지, Time: 0.01 ms, Memory: 61.8 MB -BaekjoonHub
[COMMIT_HASH] [level 0] Title: 대문자와 소문자, Time: 8.66 ms, Memory: 65.6 MB -BaekjoonHub
[COMMIT_HASH] [level 0] Title: 삼각형의 완성조건 (1), Time: 0.36 ms, Memory: 60 MB -BaekjoonHub
[COMMIT_HASH] [level 3] Title: 여행경로, Time: 0.08 ms, Memory: 62.5 MB -BaekjoonHub
[COMMIT_HASH] [level 1] Title: 음양 더하기, Time: 0.05 ms, Memory: 64.1 MB -BaekjoonHub
[COMMIT_HASH] test: git test
[COMMIT_HASH] [level 1] Title: 문자열 내 p와 y의 개수, Time: 0.04 ms, Memory: 62.5 MB -BaekjoonHub
```

### 해석

가장 최근 커밋 `[COMMIT_HASH]`은 현재 브랜치 `main`의 HEAD이며, 동시에 `origin/main`, `origin/HEAD`에도 위치해 있었다.

즉, 해당 커밋은 로컬에만 있는 것이 아니라 원격 저장소에도 push된 상태로 확인되었다.

---

## 3. 특정 커밋의 상세 정보 확인

### 사용 명령어

```bash
git show [COMMIT_HASH] --pretty=fuller --no-patch
```

또는 현재 HEAD 기준으로는 다음 명령어도 가능하다.

```bash
git show HEAD --pretty=fuller --no-patch
```

### 확인 결과

```text
commit [FULL_COMMIT_HASH_MASKED] (HEAD -> main, origin/main, origin/HEAD)
Author:     98SKC <***+98SKC@users.noreply.github.com>
AuthorDate: Tue May 19 22:45:32 2026 +0900
Commit:     98SKC <***+98SKC@users.noreply.github.com>
CommitDate: Tue May 19 22:45:32 2026 +0900

    [level 0] Title: n의 배수 고르기, Time: 0.04 ms, Memory: 60.6 MB -BaekjoonHub
```

### 해석

확인된 내용은 다음과 같다.

- 커밋 해시: `[FULL_COMMIT_HASH_MASKED]`
- 작성자: `98SKC`
- 작성자 이메일: `***+98SKC@users.noreply.github.com`
- AuthorDate: `2026-05-19 22:45:32 +0900`
- CommitDate: `2026-05-19 22:45:32 +0900`
- 브랜치 상태: `HEAD -> main, origin/main, origin/HEAD`

AuthorDate와 CommitDate가 동일했고, 작성자 이메일도 GitHub noreply 이메일 형식이었다.

따라서 날짜 불일치나 작성자 정보 불일치 문제는 아닌 것으로 보인다.

---

## 4. 최근 커밋들의 작성자/날짜 일괄 확인

### 사용 명령어

```bash
git log -10 --pretty=format:"%h | %an | %ae | author:%ad | commit:%cd | %s" --date=iso
```

### 확인 결과

```text
[COMMIT_HASH] | 98SKC | ***+98SKC@users.noreply.github.com | author:2026-05-19 22:45:32 +0900 | commit:2026-05-19 22:45:32 +0900 | [level 0] Title: n의 배수 고르기, Time: 0.04 ms, Memory: 60.6 MB -BaekjoonHub
[COMMIT_HASH] | 98SKC | ***+98SKC@users.noreply.github.com | author:2026-05-19 22:41:49 +0900 | commit:2026-05-19 22:41:49 +0900 | [level 0] Title: 배열의 유사도, Time: 0.02 ms, Memory: 60.4 MB -BaekjoonHub
[COMMIT_HASH] | 98SKC | ***+98SKC@users.noreply.github.com | author:2026-05-18 21:41:48 +0900 | commit:2026-05-18 21:41:48 +0900 | [level 0] Title: 가장 큰 수 찾기, Time: 0.01 ms, Memory: 62.5 MB -BaekjoonHub
[COMMIT_HASH] | 98SKC | ***+98SKC@users.noreply.github.com | author:2026-05-17 21:49:50 +0900 | commit:2026-05-17 21:49:50 +0900 | [level 0] Title: 편지, Time: 0.01 ms, Memory: 61.8 MB -BaekjoonHub
[COMMIT_HASH] | 98SKC | ***+98SKC@users.noreply.github.com | author:2026-05-16 22:44:32 +0900 | commit:2026-05-16 22:44:32 +0900 | [level 0] Title: 대문자와 소문자, Time: 8.66 ms, Memory: 65.6 MB -BaekjoonHub
[COMMIT_HASH] | 98SKC | ***+98SKC@users.noreply.github.com | author:2026-05-15 23:40:15 +0900 | commit:2026-05-15 23:40:15 +0900 | [level 0] Title: 삼각형의 완성조건 (1), Time: 0.36 ms, Memory: 60 MB -BaekjoonHub
[COMMIT_HASH] | 98SKC | ***+98SKC@users.noreply.github.com | author:2026-05-14 17:40:08 +0900 | commit:2026-05-14 17:40:08 +0900 | [level 3] Title: 여행경로, Time: 0.08 ms, Memory: 62.5 MB -BaekjoonHub
[COMMIT_HASH] | 98SKC | ***+98SKC@users.noreply.github.com | author:2026-05-13 21:00:43 +0900 | commit:2026-05-13 21:00:43 +0900 | [level 1] Title: 음양 더하기, Time: 0.05 ms, Memory: 64.1 MB -BaekjoonHub
[COMMIT_HASH] | kyuchul5243 | ***@gmail.com | author:2026-05-12 23:16:20 +0900 | commit:2026-05-12 23:16:20 +0900 | test: git test
[COMMIT_HASH] | 98SKC | ***+98SKC@users.noreply.github.com | author:2026-05-12 22:33:41 +0900 | commit:2026-05-12 22:33:41 +0900 | [level 1] Title: 문자열 내 p와 y의 개수, Time: 0.04 ms, Memory: 62.5 MB -BaekjoonHub
```

### 해석

대부분의 BaekjoonHub 커밋은 동일한 작성자와 동일한 이메일을 사용하고 있었다.

```text
98SKC <***+98SKC@users.noreply.github.com>
```

또한 각 커밋의 AuthorDate와 CommitDate도 동일했다.

따라서 특정 날짜만 잔디가 반영되지 않는 원인을 로컬 커밋 메타데이터만으로 설명하기는 어렵다.

---

## 5. GitHub 커밋 페이지에서 날짜별 커밋 조회

### 확인 URL

한국 시간 기준 2026-05-19 하루를 UTC 기준으로 변환하여 아래 URL로 확인했다.

```text
https://github.com/98SKC/SKC_PS/commits/main/?author=98SKC&since=2026-05-18T15:00:00Z&until=2026-05-19T14:59:59Z
```

### 확인 결과

GitHub 커밋 페이지에서 2026년 5월 19일 커밋 2개가 정상적으로 조회되었다.

```text
[COMMIT_HASH] [level 0] Title: n의 배수 고르기
[COMMIT_HASH] [level 0] Title: 배열의 유사도
```

### 해석

커밋은 GitHub 원격 저장소의 `main` 브랜치에 정상적으로 존재한다.

따라서 커밋이 push되지 않았거나, 날짜 범위 조회에 실패한 문제는 아니다.

---

## 6. GitHub contribution graph 확인

### 확인 내용

GitHub 프로필의 contribution graph에서 2026년 5월 19일 칸을 확인했다.

### 확인 결과

프로필에는 다음과 같이 표시되었다.

```text
No contributions on May 19th.
```

### 해석

GitHub 저장소의 커밋 목록에는 2026년 5월 19일 커밋이 존재하지만, 프로필 contribution graph에는 해당 날짜의 contribution으로 계산되지 않고 있다.

즉, 현재 상태는 다음과 같다.

```text
GitHub 저장소 커밋 목록에는 존재함
GitHub 프로필 잔디에는 미반영됨
```

---

## 7. 현재까지의 결론

현재까지 확인한 내용 기준으로는 다음 문제들은 가능성이 낮다.

- 로컬에만 커밋이 있고 push되지 않은 문제
- AuthorDate와 CommitDate가 달라서 날짜가 어긋난 문제
- 작성자 이메일이 매번 달라지는 문제
- 커밋이 `main` 브랜치가 아닌 다른 브랜치에 있는 문제

# 문제 원인 가능성 높은 추측

원인은 모르겠는데, 특정 시간의 백준 허브를 통한 commit이 잔디로 등록이 안되는 듯 하다.
현 시각 11시 25분 내외의 커밋이 잔디가 등록이 안되었다.
생각해보니 그동안 커밋이 올라갔으나 잔디가 안된 커밋이 10시 넘어 있던 커밋으로 기억한다.
무슨 트리거가 있는거지?

# 증상이 추가되었다.

백준 허브로 잔디가 안심어질 때 데스크탑에서 commit을 추가하면 잔디가 채워졌었는데
오늘은 이것도 잔디가 안심어진다. 원인이 뭔지 감도 안잡힌다.
