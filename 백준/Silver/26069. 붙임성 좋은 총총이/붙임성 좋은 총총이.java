import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int count=1;// 총총이는 춤을 추고 있음.
    	String p1;
    	String p2;
    	//객체로 푸는게 제일 직관성은 좋아 보임.
    	
    	//map은 가능은 한데, key를 어떻게 처음에 집어 넣으면서 만들지가 관건. key가 있는지를 먼저 볼까.
    	
    	HashMap<String,Boolean> map=new HashMap<String, Boolean>();// true면 춤 추는걸로.	
    	map.put("ChongChong", true);
    	
    	
    	int N=Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<N;i++) {
    		StringTokenizer st=new StringTokenizer(br.readLine());
    		p1=st.nextToken();
    		p2=st.nextToken();
    		if(!map.containsKey(p1)) map.put(p1,false);
    		if(!map.containsKey(p2)) map.put(p2,false);
    		if(map.get(p1)&&map.get(p2)) {// 둘다 춤추고 있으면 패스
    			continue;
    		}else if((!map.get(p1))&&(!map.get(p2))){// 둘다 춤 안추고 있어도 패스
    			continue;
    		}else {//이 분기에 왔으면 한명만 춤을 추고 있다는 것.
    			if(map.get(p1)) {
    				map.put(p2,true);
    			}else {
    				map.put(p1,true);
    			}
    			count++;
    		}
		
    	}
    	System.out.println(count);

    }
}


