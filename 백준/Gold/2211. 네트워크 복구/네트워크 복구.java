import java.util.*;
import java.io.*;

public class Main {
 
    static class Computer implements Comparable<Computer>{
        int num; // 지금 노드번호
        int time; // 현재 노드까지의 최소 시간

        public Computer(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Computer o) {
            return this.time - o.time;
        }
    }
    
    static int N, M;
    static List<Computer>[] list;
    static Computer[] arr;
    static boolean[] v;
    static int[] parent; // 부모 노드 저장을 위한 배열 추가. 출력 시 부모노드와 인덱스를 출력

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        arr = new Computer[N + 1];
        v = new boolean[N + 1];
        parent = new int[N + 1]; // 부모 노드 초기화

        for (int i = 1; i <= N; i++) { // 0번 인덱스 사용 안 함
            list[i] = new ArrayList<>();
            arr[i] = new Computer(i, Integer.MAX_VALUE);
            parent[i] = -1; // 부모 노드 없음으로 초기화
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int subNum = Integer.parseInt(st.nextToken());
            int subNext = Integer.parseInt(st.nextToken());
            int subTime = Integer.parseInt(st.nextToken());
            list[subNum].add(new Computer(subNext, subTime));
            list[subNext].add(new Computer(subNum, subTime));
        }
        
        dijkstra();
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 2; i <= N; i++) { // 1번 컴퓨터는 슈퍼컴퓨터이므로 제외
            if (parent[i] != -1) { // 부모 노드가 있으면 경로가 존재
                count++;
                sb.append(parent[i]).append(" ").append(i).append("\n");
            }
        }
        
        System.out.println(count);
        System.out.print(sb.toString());
    }
    
    static void dijkstra() {
        PriorityQueue<Computer> q = new PriorityQueue<>();
        q.add(new Computer(1, 0)); // 시작 노드를 큐에 삽입
        arr[1].time = 0; // 시작 노드의 시간은 0

        while (!q.isEmpty()) {
            Computer c = q.poll();
            int num = c.num;

            if (v[num]) continue; // 이미 방문한 노드는 건너뜀
            v[num] = true;

            for (Computer next : list[num]) {
                if (arr[next.num].time > arr[num].time + next.time) {
                    arr[next.num].time = arr[num].time + next.time;
                    parent[next.num] = num; // 부모 노드를 현재 노드로 설정
                    q.add(new Computer(next.num, arr[next.num].time));
                }
            }
        }
    }
}