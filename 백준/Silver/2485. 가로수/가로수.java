import com.sun.jdi.IntegerType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        //HashSet<Integer> set=new HashSet<>();
        int N=Integer.parseInt(br.readLine());
        int count=0;
        int answer=0;
        int[] arr=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
           // set.add(arr[i]);
        }
        Arrays.sort(arr);

        int sub;
        int before=0;
        for(int j=1;j<=N-1;j++){
            if(j==1){
                before=arr[j]-arr[j-1];
            }else{
                sub=arr[j]-arr[j-1];
                if(sub>before){
                    before=gcd(sub,before);
                }else{
                    before=gcd(before,sub);
                }
            }
        }

        for(int k=arr[0];k<=arr[N-1];k=k+before){
            //if(!set.contains(k)) count++;
            count++;
        }
        //set을 사용하니 메모리 초과가 일어남.
        //배열을 어떻게 위치를 옮겨가며 비교할까 고민하다가, 그냥 전체 나무를 심었을때, 미리 심어둔 나무의 개수를 뺴면 된다는 것을 꺠달음.
        answer=count-N;
        System.out.println(answer);
    }

    public static int gcd(int a,int b){

        if(b==0) return a;

        return gcd(b,a%b);
    }


}

