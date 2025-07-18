
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        
        st=new StringTokenizer(br.readLine());
        int[] kids=new int[N];
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<N;i++) {
        	kids[i]=Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(kids);
      
        for(int i=0;i<N-1;i++) {
        	list.add(kids[i+1]-kids[i]);
        }
        
        Collections.sort(list);
        
        int answer=0;
        
        //K개의 조를 만들 수 있다
        //-> 조를 키차이로 세웠을 때 K-1개의 기준선으로 나눌 수 있다.
        //-> 인접한 애들끼리 가장 큰 차이가 나는 두 친구를 가른다.
        //-> 가장 큰 키차이를 K-1개 분리하고 나머지들 더함
        /*
         * [아이 A]——3——[아이 B]——7——[아이 C]——2——[아이 D]——4——[아이 E]——10——[아이 F]——15——[아이 G]——1——[아이 H]——4——[아이 I]——9——[아이 J]
			에서 조 2개로 나눈다고 하면, 15가 잘린다.
			그럼 F와 A의 키차이, +G와 J의 키차이가  티셔츠 비용이 된다,
			이때 F와 A의 차이는, 키순으로 정렬되어 있기에 그 사이의 차이들을 합친 값이된다.
			반대도 마찬가지
			*/
        
	    for(int i=0;i<N-K;i++){
	        answer+=list.get(i);
	    }
	    
	    System.out.println(answer);
       
    }
}
