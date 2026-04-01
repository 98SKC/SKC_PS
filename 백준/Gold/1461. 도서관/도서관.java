

import java.io.*;
import java.util.*;

public class Main{

    public static int N,M;
    public static int mid; //오른쪽으로 이동하는 첫 인덱스
    public static int answer=0;
    public static int[] book;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        book=new int[N];
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            book[i]=Integer.parseInt(st.nextToken());
        }
        
        mid=N;
        
        Arrays.sort(book);
        for(int i=0;i<N;i++){
            if(book[i]>0){
                mid=i;
                break;
            }
        }

        ArrayList<Integer> cost=new ArrayList<>();
        int point=0;

        //System.out.println(Arrays.toString(book)+" "+mid);
        while(point<mid){
            cost.add(Math.abs(book[point]));
            //System.out.println("원소 left: "+book[point]);
            point+=M;
        }
        
        point=N-1;

        while(point>=mid){
            cost.add(Math.abs(book[point]));
            //System.out.println("원소 right: "+book[point]);
            
            point-=M;
        }
        
        Collections.sort(cost);

        int len=cost.size();
        
        //System.out.println("len: "+len);
        
        for(int i=0;i<len-1;i++){
        	//System.out.println("r: "+cost.get(i)*2);
            answer+=cost.get(i)*2;
        }
        
        //System.out.println(Arrays.toString(book));

        answer+=cost.get(len-1);
        
        System.out.println(answer);
        // M=3
        // point  mid
        // 0    1  2 3 4 5 6
        // -2  -1  1 2 3 4 5





        //가장 멀리있는 책을 마지막에 가서 돌아오지 않는 것으로 거리를 줄이기
        //가장 멀리있는 책을 우선적으로 가며, 가까이있는 다른 책들을 처리하기

        // -> 한쪽 방향에서 최대 M개(가장 먼게 너무 멀면, 가까이 처리후 가장 먼걸 가서 끝내는게 빠름)까지 이동.
        // 가장 먼 end 포인트에서 하나씩 내려오며 그 이하의 M개를 모두 가져옴

        //어차피 가장 끝을 가지러갈 때, 그 사이에 있는 멀리있는 M개를 다 가져가는게 최선
        //문제는 이걸 마지막에 둘거냐, 아니냐.만이 문제

        //최종적으로는 cost1, cost2.... costK 가 생김. 이중에 단 하나만 x2를 안함.
        //그럴 때 모두 합한게 제일 적은 경우!

    }



}