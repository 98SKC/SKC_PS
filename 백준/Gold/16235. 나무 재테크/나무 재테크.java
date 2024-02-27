import java.io.*;
import java.util.*;



public class Main {
	
	static class Tree {
		int i;
		int j;
		int age;
		
		Tree(int i,int j,int age){
			this.i=i;
			this.j=j;
			this.age=age;
		}

	}
	
	
	static int N,M,K;
	static int[][] robot, map;
	static int[] di=new int[] {-1,-1,-1,0,1,1,1,0};
	static int[] dj=new int[] {-1,0,1,1,1,0,-1,-1};
	static PriorityQueue<Tree> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.age, o2.age));
	static Queue<Tree> q=new ArrayDeque<>();//성장에 성공한 나무
	static Queue<Tree> die=new ArrayDeque<>();
	static Queue<Tree> five=new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		robot=new int[N][N];
		map=new int[N][N];
		
		//로봇이 겨울마다 각 땅에 추가할 양분의 양
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				robot[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		//가장 처음에 양분은 모든 땅에 5씩 들어있다.
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=5;
			}
		}
		//처음 나무들을 우선순위큐에 넣는다. 이 때 나이가 어린 나무들 부터 양분을 먹도록 나이에 맞추어 정렬한다.
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken());
			pq.add(new Tree(a,b,c));
		}
		


		for(int i=0;i<K;i++) {
			spring();
			summer();
			fall();
			winter();
		}
		
		System.out.println(pq.size());
	}
	
	//봄에는 자신의 나이만큼 양분을 먹고, 나이는 1만 증가
	static void spring() {
		
		int count=pq.size();
		Tree tree;
		while(count-- >0) {
			tree=pq.poll();
			if(map[tree.i][tree.j]>=tree.age) {
				map[tree.i][tree.j]-=tree.age;
				tree.age++;
				if(tree.age%5==0) five.offer(tree);
				q.offer(tree);
			}else {
				die.offer(tree);
			}
		}
		while(!q.isEmpty()) {
			pq.offer(q.poll());
		}// 성장한 나무는 다시 넣어줌.
	}
	
	//여름에는 죽은 나무가 양분으로 변한다
	static void summer() {
		int ni;
		int nj;
		Tree tree;
		while(!die.isEmpty()) {
			tree=die.poll();
			ni=tree.i;
			nj=tree.j;
			
			map[ni][nj]+=tree.age/2;
		}
	}
	
	//가을에는 나무가 번식한다. 
	static void fall() {
		int ni;
		int nj;
		Tree tree;
		
		while(!five.isEmpty()) {
			tree=five.poll();
			for(int a=0;a<8;a++) {
				ni=tree.i+di[a];
				nj=tree.j+dj[a];
				
				if(ni>=0&&ni<N&&nj>=0&&nj<N) {// 맵 안쪽이면
					pq.offer(new Tree(ni,nj,1));// 나무 큐에 추가함.
				}
				
			}

		}
	}
	
	
	//겨울에는 로봇이 땅에 양분을 뿌리고 다닌다.

	static void winter() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]+=robot[i][j];
			}
		}
	}
	
}