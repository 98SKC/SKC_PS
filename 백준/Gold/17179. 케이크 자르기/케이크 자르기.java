
import java.util.*;
import java.io.*;

public class Main {

   public static int[] cutPoint;

   public static HashMap<Integer,Integer> save=new HashMap<>();
   public static int N,M,L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); //자를 수 있는 횟수
        M=Integer.parseInt(st.nextToken()); //지점의 개수 M
        L=Integer.parseInt(st.nextToken()); //롤케익의 길이
        
        cutPoint=new int[M+2]; //절단지점이 M개면 나오는 조각은 M+1개 

        
        for(int i=1;i<=M;i++) {
           cutPoint[i]=Integer.parseInt(br.readLine());
        }
        cutPoint[M+1]=L;
        
        //오름차순으로 주어진다는 조건이 있음
        //Arrays.sort(cutPoint);
        
        StringBuilder sb=new StringBuilder();
        
        int left, right, mid, goal;
        //자르는 횟수 또한 오름차순, 중복은 없음
        int sub;
        
        for(int i=0;i<N;i++) {
           goal=Integer.parseInt(br.readLine())+1;// goal만큼 잘라야한다. -> goal+1만큼의 조각이 필요하다.
           
           
           left=1; 
           right=L;
           
           
           while(left<=right){
              mid=left+(right-left)/2; //mid가 조각의 최대가 될 때 나올 수 있는 조각 수
              
              sub=calculatePiece(mid);
              //                           sub         <      goal
              if(sub<goal){   // 최소길이가 10으로 했을 때 5조각이 나왔다. 근데 손님이 7명이다. 그럼 최소 길이를 줄여야지. 
                          // 즉 조각을 더 만들어야 한다. 그럼 최소길이를 더 줄여야지.
                 right=mid-1;
              }else {//조각이 많이 나왔다. 범위를 늘린다.
                 left=mid+1;
              }
              
           }
           
           sb.append(right+"\n");
           
           
        }
        
        System.out.println(sb);
        
        
        //롤케이크가 있다.
        //특정 위치에서만 자를 수 있다.
        //몇개의 수를 목록에 적고, 각 수만큼 조각을 만들 때 가장 작은 조각의 길이의 최대값을 구하고자 한다.
        //70cm의 케이크를 자를 수 있는 지점이 5군대라고 할 때,
        
        
    }
    
    // 모든 조각이 n길이 이상일 때 몇조각이 나올 수 있는가
    public static int calculatePiece(int n){
       if(save.containsKey(n)) return save.get(n);
       //int piece=cutPoint[0];
       int piece=0;// 첫 조각을 넣어둔다.
       //int before=0;
       int answer=0;
       int sub;
       
       for(int i=1;i<=M+1;i++){
          sub=cutPoint[i]-cutPoint[i-1];
          if(piece+sub>=n){// 
             piece=0;
             answer++;
          }else {
             piece+=sub;
          }   
       }

       save.put(n,answer);
       return answer;
       
       
    }
    
}
