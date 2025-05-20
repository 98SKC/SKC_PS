
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        
        int a,b;
        ArrayList<Integer>[] up=new ArrayList[N+1];
        ArrayList<Integer>[] down=new ArrayList[N+1];
        
        for(int i=1;i<=N;i++) {
        	up[i]=new ArrayList<>();
        	down[i]=new ArrayList<>();
        	
        }
        
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	//a가 b보다 작다.
        	down[a].add(b);// a보다 작은 캐릭터들 
        	up[b].add(a);// b보다 큰 캐릭터들
        }
        
        //트리가 되질 않을 듯 친입 차수가 여러개가 되니까
        
        //완탐은 확실히 알 수 있지. 노드 위로, 아래로 탐색해서 n-1이 나오면 되잖아.
        //이게 그럼 최대 몇이야.  노드가 500개 ,간선이 499개라고 하면
        //될 것 같기도
        int answer=0;
        int sum=0;
        int p;
        boolean[] v;
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=1;i<=N;i++) {
        	sum=0;
        	v=new boolean[N+1];
        	//i보다 작은 자들
        	q.add(i);
        	while(!q.isEmpty()) {
        		p=q.poll();
        		if(v[p]) continue;
        		v[p]=true;
        		sum++;
        		for(int d: down[p]) {
        			if(v[d]) continue;
        			q.add(d);
        		}
        		
        	}
        	
        	q.add(i);
        	v[i]=false;
        	while(!q.isEmpty()) {
        		p=q.poll();
        		if(v[p]) continue;
        		v[p]=true;
        		sum++;
        		for(int u: up[p]) {
        			if(v[u]) continue;
        			q.add(u);
        		}
        	}
        	
        	//System.out.println(i+" 가 알수있는 수: "+sum);
        	if(sum-1==N) {
        		answer++;
        	}
        	//i보다 큰 자들
        	
        }
        System.out.println(answer);
    }
}
