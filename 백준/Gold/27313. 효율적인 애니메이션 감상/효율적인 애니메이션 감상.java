import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());//봐야하는 애니메이션의 수
		int M=Integer.parseInt(st.nextToken());//애니메이션을 볼 수 있는 시간
		int K=Integer.parseInt(st.nextToken());//동시에 볼 수 있는 애니메이션의 개수
		
		st=new StringTokenizer(br.readLine());
		
		ArrayList<Integer> ani=new ArrayList<>();
		int sub;
		for(int i=0;i<N;i++) {
			sub=Integer.parseInt(st.nextToken());
			if(sub<=M) ani.add(sub);
		}
		// 정렬은 해야할 것 같은 문제인데. 뒤에 뭐가 나오는지 모르는 상태로 가능?
		
		Collections.sort(ani);

		int left=1;
		int right=ani.size();
		int mid;
		int subTime;
		boolean check;
		while(left<=right) {
			mid=left+(right-left)/2;
			//mid개 만큼 볼 수 있는가
			subTime=0;
			check=true;
			for(int i=mid-1;i>=0;i-=K) {
				if(ani.get(i)<=M-subTime){
					subTime+=ani.get(i);
				}else{// 볼 수 없다.
					check=false;
					break;
				}
			}
			if(check){// 애니 개수를 늘려본다
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		System.out.println(right);

	}
	
	
}