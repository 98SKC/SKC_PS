import java.io.*;
import java.util.*;


class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        //길이가 같은 배열 A,B.
        //각 배열은 자연수로 이루어짐.
        //배열 A,B에서 하나씩 숫자를 뽑아 곱한다.
        //배열 길이만큼 이를 반복하며 누적하여 더한다.
        //이 때 최종적으로 누적된 값이 최소가 되도록 하라.
        //한번 뽑은 수는 다시 뽑을 수 없다.
        
        Arrays.sort(A);
        Arrays.sort(B);
                
        int len=A.length;
        ArrayDeque<Integer> dqA=new ArrayDeque<>();
        ArrayDeque<Integer> dqB=new ArrayDeque<>();

        for(int i=0;i<len;i++){
            dqA.add(A[i]);
            dqB.add(B[i]);
            
        }
        

        int sub1,sub2;
        for(int i=0;i<len;i++){
            sub1=dqA.peekFirst()*dqB.peekLast();
            sub2=dqA.peekLast()*dqB.peekFirst();
            
            if(sub1>sub2){
                answer+=sub2;
                
                dqA.pollLast();
                dqB.pollFirst();

                
            }else{
                answer+=sub1;
                dqA.pollFirst();
                dqB.pollLast();
                
             
            }
        }
        //
        
        return answer;
    }
}