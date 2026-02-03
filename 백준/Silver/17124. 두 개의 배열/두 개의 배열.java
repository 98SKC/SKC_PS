import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int T;
    public static int N,M;
    public static int[] A,B,C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //정수 배열 A,B
        //A는 N개의 서로 다른 양의 정수를 포함.
        //B는 M개의 서로다른 양의 정수를 포함
        //A,B를 이용해서 길이가 N인 새로운 배열 C를 제작

        //C[i]는 QODUF B에 있는 값 중 A[i]에 가장 가까운 값.(절댓값의 차이가 적은 값)
        //이 조건의 값이 여러개면 크기가 작은 값으로 정의

        StringTokenizer st;

        T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int test_case=1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());

            A=new int[N];
            B=new int[M];
            C=new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                A[i]=Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){
                B[i]=Integer.parseInt(st.nextToken());
            }
            int idx;
            long sub1,sub2;
            long answer=0;
            answer=0;
            int bestIdx;
            Arrays.sort(B);
            for(int i=0;i<N;i++){
                //A[i]에 가장 가까운 값을 b에서 찾는다.

                //1안. 이분탐색 lower bound로 찾아서, idx, idx+1을 비교
                idx = binarySearch(A[i]);
                bestIdx = idx;

                // idx-1 후보
                if (idx - 1 >= 0) {
                    int dBest = Math.abs(A[i] - B[bestIdx]);
                    int dCur  = Math.abs(A[i] - B[idx - 1]);

                    if (dCur < dBest || (dCur == dBest && B[idx - 1] < B[bestIdx])) {
                        bestIdx = idx - 1;
                    }
                }

                // idx+1 후보
                if (idx + 1 < M) {
                    int dBest = Math.abs(A[i] - B[bestIdx]);
                    int dCur  = Math.abs(A[i] - B[idx + 1]);

                    if (dCur < dBest || (dCur == dBest && B[idx + 1] < B[bestIdx])) {
                        bestIdx = idx + 1;
                    }
                }

                C[i] = B[bestIdx];
                answer += B[bestIdx];

            }
            //System.out.println(Arrays.toString(C));
            sb.append(answer);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    //target을 넘지 않는 가장 가까운 값의 인덱스를 반환
    public static int binarySearch(int target){


        int left=0;
        int right=M-1;
        int mid;
        while(left<right){
            mid=left+(right-left)/2;

            //지금 값보다 더 커져도 된다.
            if(B[mid]<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }

        return right;
    }

}



//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
//
//    }
//
//}
