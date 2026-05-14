import java.io.*;
import java.util.*;

class Solution {

    public static HashMap<String,List<String>> map;
    public static HashMap<String,Integer> number;
    public static String[] answer;
    public static boolean[][] v;
    public static int len;
    public static boolean find=false;
    public String[] solution(String[][] tickets) {


        len = tickets.length;
        answer=new String[len+1];
        //출발은 항상 ICN

        map=new HashMap<>();
        number=new HashMap<>();
        v=new boolean[len+1][len+1];

        int cnt=0;
        for(int i=0; i<len; i++) {

            String start = tickets[i][0];
            String end = tickets[i][1];

            if(!number.containsKey(start)){
                number.put(start,cnt++);
            }

            if(!number.containsKey(end)){
                number.put(end,cnt++);
            }

            if(!map.containsKey(start)){
                map.put(start,new ArrayList<>());
            }
            if(!map.containsKey(end)){
                map.put(end,new ArrayList<>());
            }
            map.get(start).add(end);

        }

        //answer=new String[map.size()];
        for(String s:map.keySet()){
            Collections.sort(map.get(s));
        }

        answer[0]="ICN";
        dfs(0,"ICN");

        return answer;
    }

    //모든 국가를 방문하는게 아니라 모든 항공권을 사용해야한다ㅣ.
    //그럼 티켓 사용 여부를 기억해야
    //                      티켓 사용횟수, 현 국가
    public static void dfs(int n,String s) {
        if(n==len){
            find=true;
            return;
        }

        int len=map.get(s).size();
        int p=number.get(s);
        for(int i=0;i<len;i++){
            if(v[p][i]) continue;
            v[p][i]=true;
            answer[n+1]=map.get(s).get(i);
            dfs(n+1,map.get(s).get(i));
            if(find) break;
            v[p][i]=false;
        }

    }
}