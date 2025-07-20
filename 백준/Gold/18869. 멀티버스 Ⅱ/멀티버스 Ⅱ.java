
import java.util.*;
import java.io.*;

public class Main {


	//좌표 압축의 학습.
	//이진탐색 메서드의 활용.
	//배열 비교 메서드의 활용.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        
        int[][] planet=new int[M][N];
        
        List<Integer>[] list=new ArrayList[M];
        
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	
        	Set<Integer> set=new HashSet<>();
        	for(int j=0;j<N;j++) {
        		planet[i][j]=Integer.parseInt(st.nextToken());
        		set.add(planet[i][j]);
        	}
        	
        	//1. set의 리스트화.
        	list[i]=new ArrayList<>(set);
        	Collections.sort(list[i]);
        	
        	
        }
        
        //좌표 압축 : 행성 크기를 등수로 치환.
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				//값의 인덱스를 찾는 메서드 활용.
				//list[i] 리스트에서 planet[i][j]의 값의 인덱스를 찾는다. 
				//
				planet[i][j]=Collections.binarySearch(list[i],planet[i][j]);	
			}
		}
				

		int count=0;
		for (int i=0;i<M;i++) {
			for (int j=i+1;j<M;j++) {
				// 배열의 비교. 위의 비교 방식은, 각 배열의 객체가 다르기에, 내용 상태가 같아도 false가 나온다.
				// 아래의 메서드는 배열의 내부 상태를 비교를 구현한 방법이기에 상태가 같다면 true가 나온다.
				//if(planet[i].equals(planet[j])) count++;
				if(Arrays.equals(planet[i],planet[j])) count++;
			}
		}
		
        System.out.println(count);
        //정렬을 했을 때, 값이 같아야 균등한 우주다.
        //이거에 대해서 같은 쌍을 구해야함.


        
    }
    
    

}
