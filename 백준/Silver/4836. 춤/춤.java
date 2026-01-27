import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    public static String[] dance;
    public static List<Integer> dip;
    public static int len;
    public static HashSet<String> save;
    public static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb= new StringBuilder();
        String str;
        List<Integer> list;
        while ((str = br.readLine()) != null) {
            if (str.isEmpty()) continue; // 빈 줄 스킵
            dance=str.split(" ");
            list=new ArrayList<>();
            len=dance.length;
            dip=new ArrayList<>();

            if(!checkrule1()) list.add(1);
            if(!checkrule2()) list.add(2);
            if(!checkrule3()) list.add(3);
            if(!checkrule4()) list.add(4);
            if(!checkrule5()) list.add(5);

            int check=list.size();
            if(check==0){
                sb.append("form ok");
            }else if(check==1){
                sb.append("form error "+list.get(0));
            }else{
                sb.append("form errors ");
                for (int i = 0; i < check; i++) {
                    if (i > 0) {
                        if (i == check - 1) sb.append(" and ");
                        else sb.append(", ");
                    }
                    sb.append(list.get(i));
                }
            }
           if(dip.size()==0) sb.append(": "+str+"\n");
           else answer();

        }
        System.out.println(sb);
        // 춤추는 규칙이 다음과 같다
        // 1. dip은 jiggle을 춘 다음이나 다다음, 또는 twirl을 추기 전에 출 수 있다.
        // 2. 모든 춤은 clap stomp clap으로 끝나야 한다.
        // 3. 만약 twirl을 췄다면 hop도 춰야한다.
        // 4. jiggle로 시작할 수 없다.
        // 5. 반드시 dip을 춰야한다.

        // 문자열이 주어졌을 때 규칙이 지켜졌는지를 알아내라.
        // 규칙을 모두 지켰다면, form ok:
        // 1개만 어겼다면 form error K: + number(어긴 규칙 번호)
        // 여러개 어겼다면 form errors K(1), K(2), ... K(N-1) and K(N): 을 출력하고 입력으로 주어진 문자열을 출력한다.


    }
    public static void answer(){
        sb.append(": ");
        for(Integer d : dip){
            dance[d] = "DIP";
        }
        for(int i = 0; i < len; i++){
            if (i > 0) sb.append(" ");
            sb.append(dance[i]);
        }
        sb.append("\n");
    }

    //  1. dip은 jiggle을 춘 다음이나 다다음, 또는 twirl을 추기 전에 출 수 있다.
    public static boolean checkrule1(){
        boolean check;

        for(int i=0;i<dance.length;i++){
            if(dance[i].equals("dip")){
                check=false;
                //바로 직전이 있고, 있으면 직전이 jiggle인지
                if(i>0&&dance[i-1].equals("jiggle")) check=true;
                if(check) continue;

                //두번 전이 있고, 있으면 jiggle인지
                if(i>1&&dance[i-2].equals("jiggle")) check=true;
                if(check) continue;

                //다음이 있고, 다음이 twirl인지,
                if(i<len-1&&dance[i+1].equals("twirl")) check=true;
                if(check) continue;

                dip.add(i);
            }
        }
        if(dip.size()==0) return true;
        return false;
    }

    //2. 모든 춤은 clap stomp clap으로 끝나야 한다.
    public static boolean checkrule2(){
        if(len<3) return false;

        boolean one=dance[len-3].equals("clap");
        boolean two=dance[len-2].equals("stomp");
        boolean three=dance[len-1].equals("clap");


        return one&&two&&three;

    }

    //만약 twirl을 췄다면 hop도 춰야한다.
    public static boolean checkrule3(){
        save=new HashSet<>();
        for(int i=0;i<dance.length;i++){
            if(dance[i].equals("twirl")||dance[i].equals("hop")||dance[i].equals("dip")){
                save.add(dance[i]);
            }
        }
        if(save.contains("twirl")){
            if(!save.contains("hop")){
                return false;
            }
        }

        return true;
    }
    //4. jiggle로 시작할 수 없다.
    public static boolean checkrule4(){

        if(dance[0].equals("jiggle")) return false;
        return true;

    }


    //5. 반드시 dip을 춰야한다.
    public static boolean checkrule5(){
        return save.contains("dip");
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
