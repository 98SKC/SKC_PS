import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static String str;
    public static int len;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열이 주어지면 최대 N개의 종류의 알파벳을 가진 연속된 문자열을 인식.

        // 첫줄에 최대로 인식 가능한 알파벳 종류의 개수가 주어짐
        // 문자열이 주어짐. 번역기가 인식 가능한 최대한의 길이를 출력한다.


        N=Integer.parseInt(br.readLine());
        str=br.readLine();
        len=str.length();
        
        //map과 이분탐색? 근데 메모리측면에서 안되나 시간 측면에서 안되나

        int mid;
        int left=0;
        int right=len;
        int sub;
        while(left<=right){
            mid=left+(right-left)/2;

            //lower초괴하지 않는  upper
            if(search(mid)){ //이 길이로는 가능. 더 늘려봐도 된다. left를 키운다.

                left=mid+1;//가능한 상태를 right 두어야지.
            }else{
                right=mid-1;
            }
        }

        System.out.println(right);

        
    }

    public static boolean search(int mid){
        boolean answer=false;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<mid;i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }

        if(map.keySet().size()<=N){
            return true;
        }
        int left=0;

        for(int i=mid;i<len;i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
            map.put(str.charAt(left),map.get(str.charAt(left))-1);
            if(map.get(str.charAt(left))==0) {
                map.remove(str.charAt(left));
            }
            if(map.keySet().size()<=N){

                return true;

            }
            left++;

        }
       
        return answer;

    }

}