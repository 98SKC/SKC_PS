import java.io.*;
import java.util.*;

public class Main {

    static int[] minWater, next, ironWater;
    static int N,M,K;

    
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		// 카드게임의 규칙
		// N개의 빨간 카드, 순서대로 1~N 번호가 존재. 이 중 M개 선택
		// N개의 파란 카드, 순서대로 1~N 번호가 존재. 빨간 카드와 같은 번호의 파란카드 M개 선택
		// 철수는 빨간카드, 민수는 파란카드
		// 철수와 민수는 카드 1장을 뒤집어서 낸다. 둘 중 카드가 큰 사람이 승리
		// 낸 카드는 폐기
		
		// 철수는 카드 조작 가능(이미 낸 카드를 또 냄, 민수에게 없는 카드를 냄)
		// 민수는 상대 카드 예측 가능(철수가 낼 카드보다 큰 수가 있다면 그 중 가장 작은 카드를 냄)
		
		//k번 철수(중복 가능한 1~N의 카드)낼 카드가 입력으로 주어짐
		// 민수가 어떤 카드를 낼지 출력. 민수가 카드를 내지 못하는 경우는 없다.
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		minWater=new int[M+1];//민수가 가지고 있는 카드
		next=new int[M+1];
		ironWater=new int[K];//철수가 제출할 카드 및 순서
		for(int i=0;i<M;i++) {
			minWater[i]=Integer.parseInt(st.nextToken());
		}
		minWater[M]=4000001;//철수가 가진 카드보다 더 큰 카드를 넣어둔다. 
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<K;i++) {
			ironWater[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(minWater);
		//System.out.println("정렬 결과: "+Arrays.toString(minWater));
		for(int i=0;i<M;i++) {
			next[i]=i;// 다음 위치를 나타낼 포인터 초기화. 처음에는 다음으로 넘기지 않아도 되어 
			//주의해야할 것이, 만약 이후 갱신과정에서 next[M-1]이 M으로 바뀐다면 next[M]=next[0]으로 설정해야함.
			//
		}
		next[M]=0;
		//이분 탐색인데, 어퍼 라운드
		//근데 탐색한걸 제외해야하는
		//기껏 탐색했는데, 보다 큰게 없으면 
		//위치에다가 포인트 주는 문제가 있던 것 같은데, a가서 a다음 좌표로
		int left,right,mid,target;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<K;i++) {
			left=0;
			right=M;
			
			while(left<right){
				mid=left+(right-left)/2;
				if(minWater[mid]<=ironWater[i]){
					left=mid+1;
				}else {
					right=mid;
				}
			}
			target=find(right);
			//System.out.println(ironWater[i]+"보다 큰 수?: "+minWater[target]+" "+target+" "+right);
			sb.append(minWater[target]).append("\n");

            // 다음 위치로 갱신
            next[target] = find(target + 1);
		}
		System.out.println(sb);
	}
	public static int find(int x) {
        if (next[x] == x) return x;
        return next[x] = find(next[x]);
    }

	
	
	
}
