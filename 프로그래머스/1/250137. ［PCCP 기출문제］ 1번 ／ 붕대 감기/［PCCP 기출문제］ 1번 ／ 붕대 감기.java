import java.io.*;
import java.util.*;

class Solution {

    //   b=시전시간,초당회복량,추가회복량   최대 hp         공격시간, 피해량 형태의 배열
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = -1;
        
        // t초동안 붕대를 감으며 1초마다 x만큼의 채력 회복
        // t초 연속으로 분대를 감는데 성공하면 y만큼의 채력 추가 회복
        // 최대치보다 높아질 수 없음
        // 기술 중 공격당하면 취소. 당한 순간 회복 불가.
        // 기술 취소 혹은 끝나면 다시 붕대 감기 사용.
        // 연속 시간이 0으로 초기화
        // 공격을 받으면 체력이 줄어듬. 0이하가 되면 죽어서 회복 불가
        int attackLen=attacks.length;
        int beforeTime=0;//이전시간
        int hp=health;//hp의 상태
        int subHp;
        for(int t=0;t<attackLen;t++){//attacks[t][0] 공격받은 시간
            //attacks[t] 에 공격을 받음
          //  System.out.println("회복 전: "+hp);
            subHp=calHp(hp,bandage[1],bandage[2],attacks[t][0]-beforeTime-1,bandage[0]);//이전 시간부터 지금까지 회복한 량
            hp=Math.min(subHp,health);
           // System.out.println("회복 후: "+hp);
            hp-=attacks[t][1];
           // System.out.println("공격 후: "+hp);
            if(hp<=0){
                hp=-1;
                break;
            }
            beforeTime=attacks[t][0];
           // System.out.println(attacks[t][0]+"시간. hp: "+hp);
        }
        return hp;
    }
    public int calHp(int hp,int heal, int addHp, int time, int oneTime){//회복전 hp, 초당 회복량, 추가 회복량, 회복 시간
       
        int answer=hp;
        answer+=heal*time;
        answer+=addHp*(time/oneTime);
       // System.out.println("이번엔 뭐야: "+answer);
        return answer;
    }
}