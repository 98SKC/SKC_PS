
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int[] strap=new int[N];
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<N;i++) {
        	strap[i]=Integer.parseInt(st.nextToken());
        	set.add(strap[i]);
        }
        ArrayList<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        
        for(int i=0;i<N;i++) {
        	strap[i]=Collections.binarySearch(list, strap[i]);
        }
        
        int cnt=0;
        int dir;
        int pos;
        //System.out.println(Arrays.toString(strap));
        for(int i=0;i<N-1;i++) {
        	dir=strap[i+1]-strap[i];
        	pos=i;
        	if(Math.abs(dir)==1) {
        		while(pos<N-1) {
        			if(strap[pos+1]-strap[pos]!=dir) break;
        			pos++;
        		}
        		if(pos!=N-1)cnt++;
        		i=pos;
        		//System.out.println("자르는 위치1: "+pos);
        		
        	}else {
        		//System.out.println("자르는 위치2: "+pos);
        		cnt++;        		
        	}
        	//
        }
        
        System.out.println(cnt);
        
        // N개의 숫자가 띠에 적혀있다.
        // 띠를 잘라 여러개의 띠로 분리할 수 있다.
        // 각 띠간의 순서를 자유롭게 바꿀 수 있다.
        // 각 띠에 적힌 수를 역순으로 적을 수 있다.
        //띠에 적힌 수를 왼쪽부터 오름차순으로 정렬시키기 위한 가위질 횟수를 구하시오.
        
        //역순으로 해결하려면 연속적인 숫자들이어야 한다.
        //띠를 옮기는 횟수는 카운트 하지 않으니, 연속적인 숫자를 가진 구간의
        //개수를 구하는 문제

    }
}
