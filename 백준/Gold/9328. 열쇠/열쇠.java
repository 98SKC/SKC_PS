import java.io.*;
import java.util.*;

public class Main {
	
	
	public static char[][] map;
	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0};
	public static boolean[][] v;
	public static int H,W;
	public static HashMap <Character,ArrayList<Integer>> keyPoint;
	public static HashSet<Character> key;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		ArrayDeque<Integer> q;
		StringBuilder sb=new StringBuilder();
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			H=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			map=new char[H+2][W+2];
			v=new boolean[H+2][W+2];
			q=new ArrayDeque<>();
			String str;
			int answer=0;
			key=new HashSet<>();
			keyPoint=new HashMap<>();

			for (int i = 0; i < H+2; i++) {
			    Arrays.fill(map[i], '.');
			}

			for(int i=1;i<=H;i++) {
				str=br.readLine();
				for(int j=1;j<=W;j++) {
					map[i][j]=str.charAt(j-1);
				}
			}
			
			str=br.readLine();
			if(!str.equals("0")) {
			    for(int i = 0; i < str.length(); i++) {
			        key.add(str.charAt(i));
			    }
			}
			
			int ni,nj;
			int pi,pj;
			int p;

			q.add(0);
			v[0][0]=true;
//			System.out.println("패딩을 준 맵 현황");
//			for(int i=0;i<H+2;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
			W=W+2;
			H=H+2;
			while(!q.isEmpty()) {
				
				p=q.poll();
				pi=p/W;
				pj=p%W;
				for(int a=0;a<4;a++) {
					ni=pi+di[a];
					nj=pj+dj[a];
					if(ni>=0&&ni<H&&nj>=0&&nj<W&&map[ni][nj]!='*'&&!v[ni][nj]) {
						if(map[ni][nj]=='.'||map[ni][nj]=='$'){//그냥 길이면 이동
							if(map[ni][nj]=='$') answer++;
							q.add(ni*W+nj);
							v[ni][nj]=true;//혹여나 다른 입구로 들어올 때를 생각하여 미리 방문 처리
						}else{//벽은 아니고, 방문한 적은 없으며, 길도 아니다.
							if(map[ni][nj]>'Z') {//소문자
								key.add(map[ni][nj]);//키는 찾고 이동도 가능함
								q.add(ni*W+nj);
								v[ni][nj]=true;
								if(keyPoint.containsKey(map[ni][nj])) {
									for(int point:keyPoint.get(map[ni][nj])) {//해당 키로 갈 수 있는 문을 이미 찾았다면
										if(v[point/W][point%W]) continue;
										q.add(point);
										v[point/W][point%W]=true;
									}
								}
							}else{//대문자
								//키를 가지고 있는지 확인
								if(key.contains((char)(map[ni][nj] + 32))) {
									q.add(ni*W+nj);
									v[ni][nj]=true;
								}else{//키가 없으면 나중에 키가 있을 때 다시 오기위해 저장
									char key2 = (char)(map[ni][nj]+32);
									ArrayList<Integer> list = keyPoint.getOrDefault(key2, new ArrayList<>());
									list.add(ni * W + nj);
									keyPoint.put(key2, list);
								}
							}
						}
					}
				}
			}
			
//			System.out.println("키 현황: "+key.size());
//			for(int i=0;i<H;i++) {
//				System.out.println(Arrays.toString(v[i]));
//			}
//			System.out.println();
			sb.append(answer+"\n");
		}
		System.out.println(sb);
		
		
	}

}