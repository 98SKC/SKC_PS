import java.io.*;
import java.util.*;

class Solution {
    public long[] solution(long k, long[] room_number) {

        
        int len=room_number.length;
        long[] answer = new long[len];
        //남아있는 방에서 i보다 큰 upper bound를 찾는 문제.
        //그래서 이분탐색을 쓸 까 했는데,
        // 자료구조를 뭘 써야하는거임 대체
        
        HashMap<Long,Long> v=new HashMap<>(); 

        //i번 손님이 원하는 방 자리가 비어있다.
        // 바로 할당 가능
        //그 자리가 비어있지 않다. v[room_number[i]]=true다.
        //room_number[i] 보다 큰 숫자의 방 중에서 room_number[i]에 가장 가깝고 비어있는 방을 줘야한다.
        //연결리스트?
        long target;
        long before;
        long next;
        ArrayList<Long> sub;
        for(int i=0;i<len;i++){
            target=room_number[i];
            sub=new ArrayList<>();
            while(true){
                if(v.containsKey(target)){
                    sub.add(target);
                    target=v.get(target);
                }else{
                    break;
                }
            }
            answer[i]=target;   
            next=target+1;
            
            while(true){
                if(v.containsKey(next)){
                    sub.add(next);
                    next=v.get(next);
                }else{
                    break;
                }
            }
            for(long n:sub){
                v.put(n,next);
            }
            v.put(target,next);
        }      
        return answer;
    }
}