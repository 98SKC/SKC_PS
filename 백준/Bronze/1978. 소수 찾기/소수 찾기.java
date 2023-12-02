import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String args[])throws IOException{
    	
    	int N=1001;//개수가N이고  100이하였음.  자연수 범위는 1000이였슴
    	int sub;
    	int count=0;
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int number=Integer.parseInt(br.readLine());
    	
    	
        boolean[] prime=new boolean[N];
        prime[0]=true;
        prime[1]=true;// true가 소수가 아님
        
        for(int i=2;i<Math.sqrt(N);i++) {// 모두가 소수라고 초기화 된 상태에서, 소수가 아닌 것들을 바꿔간다,
        	
        	
        	if(prime[i]) continue;
        	
        	for(int j=i*i;j<N;j=j+i) {// i*i부터 시작인 이유-> i*i 이전의 i*1, i*2...은 이전에 걸러짐. i*i부터 i의 배수를 제거
        		prime[j]=true;
        	}
        	
        }
        String[] str=br.readLine().split(" ");
        for(int k=0;k<str.length;k++) {
        	sub=Integer.parseInt(str[k]);
        	
        	if(!prime[sub]) count++;
        	
        }
        System.out.println(count);
    }
}
