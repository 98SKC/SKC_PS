import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        
        HashMap<String,Integer> map=new HashMap<>();
        
        for(int i=0;i<friends.length;i++){
            map.put(friends[i],i);
        }        
        String[] str;
        int[][] arr=new int[friends.length][friends.length];
        int[] now=new int[friends.length];
        int[] give=new int[friends.length];
        int[] recive=new int[friends.length];
        for(int i=0;i<gifts.length;i++){
            str=gifts[i].split(" ");
            arr[map.get(str[0])][map.get(str[1])]++;// str[0]이 str[1]에게 선물을 줬다.
        }
        //str[0]이 선물을 준 총 횟수.
        for(int i=0;i<friends.length;i++){
            for(int a:arr[i]){
                give[i]+=a;
            }
        }
        
        for(int j=0;j<friends.length;j++){
            for(int i=0;i<friends.length;i++){
                recive[j]+=arr[i][j];//j가 선물 받은 총 개수
            }
        }
        
        for(int i=0;i<friends.length;i++){
            for(int j=i+1;j<friends.length;j++){
                if(arr[i][j]>arr[j][i]){//i와 j의 사이에서, i가 j에게 준 선물보다 j가 i에게 준 선물이 많으면
                    now[i]++;//j가 받을 선물을 늘림
                }else if(arr[i][j]<arr[j][i]){// 그 반대면
                    now[j]++;//i가 받을 선물을 늘림
                }else{// 같으면
                    if(give[i]-recive[i]<give[j]-recive[j]){
                        now[j]++;
                    }else if(give[j]-recive[j]<give[i]-recive[i]){
                        now[i]++;
                    }
                }
            }
        }
        
        for(int a:now){
           // System.out.println(a);
            answer=Math.max(answer,a);
        }

        return answer;
    }
}