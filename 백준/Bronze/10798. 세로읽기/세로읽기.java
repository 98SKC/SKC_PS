import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {


    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    	String[][] str=new String[5][15];
    	int max=0;
    	
    	for(int i=0;i<5;i++) {
    		String[] sub=br.readLine().split("");
    		max=Math.max(max,sub.length);
    		//str[i]=sub;// 이거 길이 안맞아도 되나? 예를 들어 sub에 들어가는 문자열이 s b c d e 이렇게 5개 뿐이어도 잘 되니?
    		//찾아보니 안된다고 합니다.
    		for(int j=0;j<sub.length;j++) {
    			str[i][j]=sub[j];
    		}
    	}
    	
    	for(int i=0;i<max;i++) {
    		for(int j=0;j<5;j++) {
    			if(str[j][i]==null)continue;// 배열이 비었다. 
    			System.out.print(str[j][i]);
    		}
    	}
    	
    	
    }
}