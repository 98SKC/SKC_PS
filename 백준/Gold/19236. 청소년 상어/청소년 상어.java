import java.util.*;
import java.io.*;


public class Main {

	
	static int[] di= {0,-1,-1,0,1,1,1,0,-1}; //0시 11시 9시 7시 6시 4시 3시 1시
	static int[] dj= {0,0,-1,-1,-1,0,1,1,1};
	static int fishI, fishJ,dir;
	//static int sharkI,sharkJ,sharkDir;
	static int cnt,ni,nj;
	static int subI, subJ,subFish;
	
	static int max=0;
	
	public static void main(String[] args) throws Exception{
		int sub=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		int[][] map=new int[4][4];
		ArrayList<int[]> list=new ArrayList<>();
	
		list.add(new int[] {0,0,0,0});// 0값에 그냥 빈 값 넣어주기
		for(int i=0;i<4;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());//맵에는 물고기 위치만 저장.
				list.add(new int[] {map[i][j],i,j,Integer.parseInt(st.nextToken())});// 리스트에 물고기 번호와 방향을 저장
			}
		}

		
		// list의 원소인 배열의 인덱스 0을 기준으로 오름차순 정렬
		 Collections.sort(list, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] a, int[] b) {
	                return Integer.compare(a[0], b[0]);
	            }
	      });

		 
		sub=map[0][0];
//		System.out.println("최초로 먹힌 물고기는"+sub);
		list.get(sub)[0]=0;// 0 0의 물고기는 먹고 시작.
		map[0][0]=0;// 
		helper(0,0,list.get(sub)[3],sub,map,list);
		
		System.out.println(max);
	}

	static void helper(int sharkI,int sharkJ,int sharkDir,int sum,int[][]originalMap,ArrayList<int[]> originalList) {
		int sub=0;
		int[][] map = new int[4][4];
	    for (int i = 0; i < 4; i++) {
	        System.arraycopy(originalMap[i], 0, map[i], 0, 4);
	    }

	    // 리스트 복사
	    ArrayList<int[]> list = new ArrayList<>();
	    for (int[] fish : originalList) {
	        list.add(fish.clone()); // 각 int[] 배열을 복사
	    }
		
		
		
		for (int i = 1; i <= 16; i++) {// 16마리의 물고기를 움직임.
			if (list.get(i)[0] != 0) {// 이 물고기가 안먹혔으면 이동
				
				fishI = list.get(i)[1];// 물고기의 위치와 방향을 가져옴.
				fishJ = list.get(i)[2];
				dir = list.get(i)[3];
				cnt = 0;
				//System.out.printf("%d, %d의 물고기의 번호는 %d, dir은 %d",fishI,fishJ,map[fishI][fishJ],dir);
				while (cnt < 8) {// 물고기를 이동시킴. 이동 못하면 반시계로 45도씩 이동.
					ni = fishI + di[dir];
					nj = fishJ + dj[dir];

					if (ni >= 0 && ni < 4 && nj >= 0 && nj < 4) {// 맵 안쪽일 때
						if (!(ni == sharkI && nj == sharkJ)) {// 이동 위치에 상어가 없으면
							// 물고기의 위치를 변경.
							subFish = map[ni][nj];//ni nj에 있던 물고기 번호
							//i번이 subFish번 위치로 움직일 때. i번의 방향을 변경.
							list.get(i)[3]=dir;

							list.get(subFish)[1]=fishI; //리스트의 subFish번 정보를 갱신. 지금 물고기의 위치정보로.
							list.get(subFish)[2]=fishJ;//map[ni][nj]는 아직 subFish

							map[ni][nj] = i;// ni nj에는 이제 i번 물고기가 있음.
				
							map[fishI][fishJ] = subFish;// fishI, fishJ에 6번 물고기가 있음.
							list.get(i)[1]=ni;
							list.get(i)[2]=nj;

						
							break;// while문을 break;
						}
					}
					dir = (dir + 1) != 9 ? dir + 1 : 1;	
					cnt++;
				}
			}

		} // 물고기 이동하는 반복문

		
		// 상어 움직일 차례
		int dSharkI=sharkI+di[sharkDir];
		int dSharkJ=sharkJ+dj[sharkDir];// 우선 움직이고
		boolean check=true;
		while(dSharkI>=0&&dSharkI<4&&dSharkJ>=0&&dSharkJ<4) {// 상어가 이동 가능한 보든 경우의 백트래킹			
			
			if(map[dSharkI][dSharkJ]!=0) {//이동하려는 위치에 물고기가 있다면 먹는다.
				check=false;
				sub=map[dSharkI][dSharkJ];
				
				map[dSharkI][dSharkJ]=0;// 맵 상태도 먹고
				list.get(sub)[0]=0;// get(a)에는 [a번호, a의i좌표, a의j좌표, a의 방향] 이 있고, [0]이 0 이면 먹힘.		
//				System.out.println(sub+"물고기 먹혔나 확인"+list.get(sub)[0]);
//				System.out.println(sub+"가 map에서도 먹혔나 확인"+map[dSharkI][dSharkJ]);
				helper(dSharkI,dSharkJ,list.get(sub)[3],sum+sub,map,list);
				list.get(sub)[0]=sub;//리스트 다시 복구	
				map[dSharkI][dSharkJ]=sub;//맵 복구
//				
//				System.out.println(sub+"물고기 복구 되었나 확인 확인"+list.get(sub)[0]);
//				System.out.println(sub+"map에서도 복구 되었나 확인"+map[dSharkI][dSharkJ]);
//				System.out.println("---------왜 두번?--------");
				
			}	
			//상어 이동.
			dSharkI=dSharkI+di[sharkDir];
			dSharkJ=dSharkJ+dj[sharkDir];
		}
		if(check) {
			int real=136;
//			System.out.printf("%d %d 의 비교 및 이 상태의 상어와 물고기 상태 \n",max,sum);
//			 System.out.println("리스트 정보");
//			for(int[] b: originalList) {
//				real-=b[0];
//				System.out.println(Arrays.toString(b));
//			}
//			System.out.println("진짜 합:"+real);
//			System.out.println("-------------------------------------");
			max=Math.max(max, sum);
		} 
			
	}

}