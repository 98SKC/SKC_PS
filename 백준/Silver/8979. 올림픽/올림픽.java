import java.util.*;
import java.io.*;

public class Main {

    public static class Medal implements Comparable<Medal>{
        int number;
        int gold;
        int silver;
        int brz;

        public Medal(int number, int gold, int silver, int brz){
            this.number=number;
            this.gold=gold;
            this.silver=silver;
            this.brz=brz;
        }

        @Override
        public int compareTo(Medal m){
            if(gold==m.gold){
                if(silver==m.silver){
                    return m.brz-this.brz;
                }else{
                    return m.silver-this.silver;
                }
            }else{
                    return m.gold-this.gold;
            }
        }

    }

    public static void main(String[] args) throws Exception{


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int num,gold,silver,brz;
        Medal[] medal=new Medal[N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            num=Integer.parseInt(st.nextToken());
            gold=Integer.parseInt(st.nextToken());
            silver=Integer.parseInt(st.nextToken());
            brz=Integer.parseInt(st.nextToken());
            medal[i]=new Medal(num,gold,silver,brz);

        }
        int answer=0;
        Arrays.sort(medal);
        int grade=1;
        int stack=0;
        if(medal[0].number==K){
            System.out.println(1);
            return;
        }
        for(int i=1;i<N;i++){
            if(medal[i].gold<medal[i-1].gold){
               // System.out.println("???");
                grade++;
                grade+=stack;
                stack=0;
            }else if(medal[i].silver<medal[i-1].silver){
               // System.out.println("??");
                grade++;
                grade+=stack;
                stack=0;
            }else if(medal[i].brz<medal[i-1].brz){
               // System.out.println("?");
                grade++;
                grade+=stack;
                stack=0;
            }else{
                stack++;
            }
           // System.out.println(i+"등수: "+grade);
            if(medal[i].number==K){
                answer=grade;
                break;
            }
        }

        System.out.println(answer);


    }

}