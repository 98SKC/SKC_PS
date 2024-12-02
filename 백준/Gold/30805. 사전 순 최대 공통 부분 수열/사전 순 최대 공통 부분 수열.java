import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 처리
        int n = Integer.parseInt(br.readLine());
        List<Pair> a = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            a.add(new Pair(value, i));
        }

        int m = Integer.parseInt(br.readLine());
        List<Pair> b = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int value = Integer.parseInt(st.nextToken());
            b.add(new Pair(value, i));
        }

        // 내림차순 정렬, 값이 같으면 인덱스 기준 오름차순으로 정렬
        Collections.sort(a, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.value == p2.value) {
                    // 값이 같으면 인덱스 오름차순
                    return Integer.compare(p1.index, p2.index);
                }
                // 값이 다르면 값 기준 내림차순
                return Integer.compare(p2.value, p1.value);
            }
        });

        Collections.sort(b, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.value == p2.value) {
                    // 값이 같으면 인덱스 오름차순
                    return Integer.compare(p1.index, p2.index);
                }
                // 값이 다르면 값 기준 내림차순
                return Integer.compare(p2.value, p1.value);
            }
        });

        // 공통 부분 수열을 저장할 리스트
        List<Integer> ans = new ArrayList<>();

        // 인덱스 및 제한 설정
        int idxA = 0, idxB = 0; // a와 b의 현재 인덱스
        int limitA = 0, limitB = 0; // 각각 a와 b에서 이전 값의 위치 제한

        // 공통 부분 수열 찾기
        while (idxA < n && idxB < m) {
            // 값이 같은 경우
            if (a.get(idxA).value == b.get(idxB).value) {
                // A의 값이 이전 위치 제한을 초과했는지 확인
                if (limitA > a.get(idxA).index) {
                    idxA++;
                }
                // B의 값이 이전 위치 제한을 초과했는지 확인
                else if (limitB > b.get(idxB).index) {
                    idxB++;
                }
                // 제한을 만족하는 경우 값 추가
                else {
                    limitA = a.get(idxA).index;
                    limitB = b.get(idxB).index;
                    ans.add(a.get(idxA).value);
                    idxA++;
                    idxB++;
                }
            }
            // A의 값이 더 크면 A의 인덱스를 증가
            else if (a.get(idxA).value > b.get(idxB).value) {
                idxA++;
            }
            // B의 값이 더 크면 B의 인덱스를 증가
            else {
                idxB++;
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append("\n"); // 공통 부분 수열 크기 출력
        for (int num : ans) {
            sb.append(num).append(" "); // 공통 부분 수열 값 출력
        }
        System.out.println(sb.toString().trim());
    }

    // Pair 클래스 정의
    static class Pair {
        int value; // 배열의 값
        int index; // 해당 값의 인덱스

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}