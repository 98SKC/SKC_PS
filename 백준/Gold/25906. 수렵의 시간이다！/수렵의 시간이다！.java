
import java.io.*;
import java.util.*;

public class Main{

    public static int[][] skill =new int[6][101];
    public static int[][][] armor=new int[4][51][6];
    public static int[][] price=new int[4][51];

    public static int T,K;

    // 각 스킬 i, 레벨 x(0~MAXSUM)일 때 공격력 증가량
    public static long[][] val = new long[6][305];
    public static int[] maxL = new int[6];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        //5개의 스킬
        //스킬에는 1~최대레벨 별로 공격력 증가량이 있다.
        //처음 스킬들은 0레벨
        //방어구를 착용하면 스킬 레벨이 증가. 방어구는 3종류
        //각 종류마다 최대 1개 착용
        //스킬 레벨이 최대를 넘으면 최대치를 따른다.

        //강화를 k골드를 지물하여 한개의 방어구를 강화. 하나의 스킬레벨 1낮추고 다른걸 1업.

        //돈이 주어짐.
        T=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        init();

        for(int i=1;i<=5;i++){
            st=new StringTokenizer(br.readLine());
            int maxLevel=Integer.parseInt(st.nextToken());
            skill[i][0]=maxLevel;//0레벨 위치에는 최대 레벨의 제한을 저장
            maxL[i]=maxLevel;
            for(int j=1;j<=maxLevel;j++){
                skill[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        // "아무 것도 안 입는 경우"를 0번 인덱스로 쓰기 위해 0번을 0으로 세팅
        for(int type=1; type<=3; type++){
            price[type][0] = 0;
            for(int s=1;s<=5;s++) armor[type][0][s]=0;
        }

        int[] M = new int[4];

        for(int i=1;i<=3;i++){

            int m=Integer.parseInt(br.readLine()); //방어구 개수 M
            M[i]=m;

            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                price[i][j]=Integer.parseInt(st.nextToken());
            }

            for(int j=1;j<=m;j++){
                st=new StringTokenizer(br.readLine());
                armor[i][j][1]=Integer.parseInt(st.nextToken());
                armor[i][j][2]=Integer.parseInt(st.nextToken());
                armor[i][j][3]=Integer.parseInt(st.nextToken());
                armor[i][j][4]=Integer.parseInt(st.nextToken());
                armor[i][j][5]=Integer.parseInt(st.nextToken());
            }
        }

        // 최대 합레벨은 슬롯 3개 * 각 스킬 최대 100 = 300 (문제 조건상)
        buildValueTable(300);

        long ans = 0;

        // 완전탐색: 머리/상의/하의에서 각각 0(안낌)~M개 중 하나 선택
        for(int h=0; h<=M[1]; h++){
            for(int b=0; b<=M[2]; b++){
                for(int l=0; l<=M[3]; l++){

                    long cost = 0;
                    cost += price[1][h];
                    cost += price[2][b];
                    cost += price[3][l];

                    if(cost > (long)T) continue;

                    int[] lv = new int[6];
                    for(int s=1;s<=5;s++){
                        lv[s] = 0;
                        lv[s] += armor[1][h][s];
                        lv[s] += armor[2][b][s];
                        lv[s] += armor[3][l][s];
                    }

                    long base = totalValue(lv);
                    if(base > ans) ans = base;

                    // 강화 케이스: K골드 지불, 전체 방어구 중 최대 한 개에 "1 감소 + 1 증가" 한 번
                    if(cost + (long)K > (long)T) continue;

                    long bestDelta = 0; // 강화는 선택사항이므로, 이득이 있을 때만 적용

                    // 강화할 후보 방어구: 착용한 것(0번 제외) 중 하나
                    if(h != 0) bestDelta = Math.max(bestDelta, bestDeltaOnArmor(lv, armor[1][h]));
                    if(b != 0) bestDelta = Math.max(bestDelta, bestDeltaOnArmor(lv, armor[2][b]));
                    if(l != 0) bestDelta = Math.max(bestDelta, bestDeltaOnArmor(lv, armor[3][l]));

                    long upgraded = base + bestDelta;
                    if(upgraded > ans) ans = upgraded;
                }
            }
        }

        System.out.println(ans);
    }

    // 해당 선택 상태(lv)에서, 특정 방어구(oneArmor)에 강화 1번을 적용했을 때 얻을 수 있는 최대 증가량(delta)
    // 조건: oneArmor[p] >= 1 인 p를 1 감소시킬 수 있고, q는 아무 스킬이나 1 증가 가능
    public static long bestDeltaOnArmor(int[] lv, int[] oneArmor){
        long best = Long.MIN_VALUE;

        for(int p=1;p<=5;p++){
            if(oneArmor[p] < 1) continue; // 1 이상 부여된 스킬만 감소 가능

            // 감소로 인해 lv[p]는 최소 0 이상이어야 함 (항상 lv[p] >= oneArmor[p] >= 1 이므로 안전)
            long dec = val[p][lv[p]-1] - val[p][lv[p]];

            for(int q=1;q<=5;q++){
            	if (q == p) continue; // 
                // 증가 후 lv[q]+1 (테이블 범위 내로 buildValueTable에서 충분히 만들어둠)
                long inc = val[q][lv[q]+1] - val[q][lv[q]];
                long delta = dec + inc;
                if(delta > best) best = delta;
            
            }
        }

        // p가 하나도 없으면(감소 가능한 스킬이 없으면) 강화 불가이므로 이득 0으로 처리
        if(best == Long.MIN_VALUE) return 0;
        return Math.max(0, best);
        
    }

    public static long totalValue(int[] lv){
        long sum = 0;
        
        for(int i=1;i<=5;i++){
            int x = lv[i];
            if(x < 0) x = 0;
            if(x >= val[i].length) x = val[i].length - 1;
            sum += val[i][x];
        }
        
        return sum;
    }

    public static void buildValueTable(int maxSum){
        // val[i][x] = 스킬 i가 레벨 x일 때 공격력 증가량 (x>maxL이면 maxL로 캡)
        for(int i=1;i<=5;i++){
            for(int x=0; x<val[i].length; x++){
                if(x==0){
                    val[i][x] = 0;
                }else{
                    int cap = Math.min(x, maxL[i]);
                    val[i][x] = skill[i][cap];
                }
            }
        }
    }

    public static void init(){
        for(int i=1;i<=3;i++){
            for(int j=1;j<=50;j++){
                price[i][j]=-1;
                for(int k=1;k<=5;k++){
                    armor[i][j][k]=-1;
                }
            }
        }
    }
}

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