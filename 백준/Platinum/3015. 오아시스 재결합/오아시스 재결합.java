import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // N명이 한줄로 서있다.
        // A와 B가 서로 보려면 그 사이에 둘보다 큰 사람이 없어야한다.
        // 서로 볼 수 있는 쌍의 수를 구하라.
        
        Stack<Integer> stack = new Stack<>();
        
        int p;
        long cnt = 0;

        // 같은 키를 그룹화하여 몇 명인지 저장
        HashMap<Integer, Integer> save = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            p = Integer.parseInt(br.readLine());
            
            // 비교 대상이 비어있지 않다면 비교를 한다.
            if (!stack.isEmpty()) {
                
                if (stack.peek() < p) { // 가장 위의 사람이 현사람보다 작다면
                	
                    // 지금 사람보다 작은 사람들은 나 이후의 사람하고 쌍을 못맺는다.
                    // 단 같은 사람이 나온다면 pop과 동시에 같은사람이 몇명 중첩되어있는지 누적한다.
                    // 현 사람보다 이 크기의 사람이 작은 경우, 그만큼 cnt
                    while (!stack.isEmpty() && stack.peek() < p) {
                        if (save.containsKey(stack.peek())) {//중복된 이력이 있는 키라면
                            cnt += save.get(stack.peek()); //중복된 사람 수만큼 증가
                            save.remove(stack.peek()); //이후 p보다 작은키이기에 다시 쌍이 될 여지가 없으니 삭제
                        } else {// 아니라면 한쌍만 증가
                            cnt++;
                        }
                        stack.pop();
                    }
                    
                    //작은키를 모두 제거한 다음 맨 위를 비교해야함.
                    if (!stack.isEmpty() && stack.peek() == p) { //가장 위가 같은 키라면
                        // 같은 키 그룹 개수를 꺼내오고(없으면 1),
                        // 그 개수만큼 cnt에 더해 줘야 한다
                        int before = save.getOrDefault(p, 1);
                        cnt += before;
                        // 그룹 개수 1 증가시켜서 저장
                        save.put(p, before + 1);
                        stack.pop();
                    }
                    
                    // pop 후에도 스택에 남아 있는 큰 사람 한 명과도 볼 수 있음
                    // else if가 아닌 것을 인지
                    if (!stack.isEmpty()) {
                        cnt++;
                    }
                    
                } else if (stack.peek() == p) { //같은 사람이 직전이라면
                    // 같은 키 그룹 개수를 꺼내오고(없으면 1),
                    // 그 개수만큼 cnt에 더해 줘야 한다
                    int before = save.getOrDefault(p, 1);
                    cnt += before;
                    // 그룹 개수 1 증가시켜서 저장
                    save.put(p, before + 1);
                    stack.pop();
                    // pop 후에도 스택에 남아 있는 큰 사람 한 명과도 볼 수 있음
                    if (!stack.isEmpty()) {
                        cnt++;
                    }
                    
                } else {
                    // 현재 사람보다 큰 사람이 바로 앞에 있으면 한 쌍
                    cnt++;
                }
            }
            
            stack.push(p);
        }
        
        System.out.println(cnt);
    }

}
