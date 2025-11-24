
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        //1~N의 서로 다른 숫자가 쓰여 있는 N개의 카드를 가지고 있다.
        //섞어서 늘어 놓은 후, 왼쪽에서부터 탐색하여 1을 발견하면 그 카드를 빼낸다.
        //1이 있던 위치부터 시작하여 2가 적힌 카드를 발견할 때까지 오른쪽 이동.
        //이를 계속 반복. 오른쪽 도달 시 박수치고 왼쪽으로 돌아옴.
        //박수를 몇번 쳤는지 계산하라.
        
        // 각 카드별 위치를 기억하고, n+1의 위치가 n보다 왼쪽이면 박수를 친다.
        HashMap<Integer, Integer> pos=new HashMap<>();
        
        int N=Integer.parseInt(br.readLine());
        
        for(int i=1;i<=N;i++) {
        	//pos.put(i, Integer.parseInt(br.readLine()));
        	pos.put(Integer.parseInt(br.readLine()),i);
        	
        }
        
        int answer=0;

        
        
        for(int i=2;i<=N;i++) {
        	if(pos.get(i)<pos.get(i-1)) {
        		answer++;
        	} 
        }
        
        //if(pos.get(N)==N) answer++; //엣지 케이스라 생각했는데, 주어진 테케를 보니 이 경우 박수를 안치는데 
        
        System.out.println(answer);
        
    }
        
}


