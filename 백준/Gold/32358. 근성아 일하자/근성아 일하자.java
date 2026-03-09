//import java.io.*;
//import java.util.*;
//
//public class Main{
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//    }
//}

import java.io.*;
import java.util.*;

public class Main{

    public static int N;
    public static long p=0; //근성의 위치
    public static int left,right;
    public static long answer=0;

    public static long[] tree=new long[200001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());

        StringTokenizer st;
        // 1 x:  좌표 x에 있는 나무에 쓰레기를 버린다.
        // 2  :  현 위치에서 쓰레기가 있는 나무 중 가장 가까운 곳으로 이동. 쓰레기 수거. 모든 쓰레기를 수거할 때까지 반복.
        //       가장 가까운 위치가 둘이면 좌표가 작은 쪽으로

        int order;
        int x;
        left=0;
        right=0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            order=Integer.parseInt(st.nextToken());
            if(order==1){

                x=Integer.parseInt(st.nextToken());

                throwTrash(x);
            }else{
                //이동거리를 갱신한다.
                pickTrash();//
                right=0;
            }
        }

        System.out.println(answer);

    }

    public static void throwTrash(int x){
        tree[right++]=x;
    }

    public static void pickTrash(){
        //줍기 전 정렬 작업
        Arrays.sort(tree, 0, right);
        // System.out.println("right: "+right);

        //처음 이동할 위치를 선택(이분탐색) 같거나 처음으로 큰 곳. lower
        int mid;
        int saveRight=right;
        int lo=0;
        int hi=right;
        while(lo<hi){
            mid=lo+(hi-lo)/2;

            if(tree[mid]<=p){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        int r=lo;
        int l=-1;
        //left와 right어차피 같은 상태.
        if(lo>0){// 지금 찾은 곳은 원래 위치 p와 같거나 큰 첫 위치. 그러니 작은 곳을 보려면 바로 왼쪽 인덱스를 확인
            l=lo-1;
        }

        // System.out.println("saveRight: "+saveRight);
        //l이 -1이 되고, r이 saveRight가 되기까지
        while(l!=-1||r!=saveRight){

            //System.out.println("몇번하는가");

            if(l<=-1){//왼쪽은 끝남
                // System.out.println("이동거리 계산: "+p+"에서 "+tree[r]+" 까지 ");
                answer += Math.abs(tree[r] - p);
                p=tree[r++];
            }else if(r>=saveRight){ //오른쪽은 끝남
                // System.out.println("이동거리 계산: "+p+"에서 "+tree[l]+" 까지 ");
                answer += Math.abs(p - tree[l]);
                p=tree[l--];
            }else{//양쪽 다 남아있으니 다음을 찾는다.
                //System.out.println("이동거리 계산: "+p+"에서 "+tree[r]+" 까지 ");
                if(p-tree[l]>tree[r]-p){
                    answer += Math.abs(tree[r] - p);
                    p=tree[r++];
                }else{
                    //     System.out.println("이동거리 계산: "+p+"에서 "+tree[l]+" 까지 ");
                    answer += Math.abs(p - tree[l]);
                    p=tree[l--];
                }
            }
        }
    }
}