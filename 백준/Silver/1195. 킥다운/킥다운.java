import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //가능한 경우 -> 맞물렸을 때 22가 없는 것 (1,2 2,1 11 가능, 0은 어디든 가능 -> 합이 4가 나오면 안되는 상황.)
        String fir=br.readLine();
        String sec=br.readLine();


        //더 긴 파트가 fir이 되도록
        if(fir.length()<sec.length()){
            String sub=fir;
            fir=sec;
            sec=sub;
        }
        int firLen=fir.length();
        int secLen=sec.length();
        //fir.length가 최선이 될 수 있는지

        int sub=firLen-secLen;
        boolean best=false;
        for(int i=0;i<=sub;i++){//fir의 비교 시작점
            best=possibleBest(fir,sec,i);

            if(best){
                System.out.println(firLen); //가장 긴 파츠가 최선의 길이
                return;
            }
            
        }

        int answer = Integer.MAX_VALUE;
        //톱니를 왼쪽으로 이동, 작은 파츠의 길이를 하나씩 왼쪽으로. 즉 작은 파츠의 왼쪽이 사라짐
        for(int i=1;i<=secLen;i++){
            if(getLeft(fir,sec,i)){
                answer=i+firLen;
                break;
            }
        }
        //톱니를 오른쪽으로 이동
        for(int i=1;i<=secLen;i++){
            if(getRight(fir,sec,i)){
                answer=Math.min(answer,i+firLen);
                break;
            }
        }


        System.out.println(answer);


    }

    public static boolean possibleBest(String fir, String sec, int start){


        int s,f;
        for(int i=0;i<sec.length();i++){
            s=sec.charAt(i)-'0';
            f=fir.charAt(start+i)-'0';
            if(s+f==4){//sec.charAt(i)와 fir.charAt(start+i)
                return false;
            }
        }

        return true;

    }


    //                                                         이 start는 sec의 시작 지점
    public static boolean getLeft(String fir, String sec, int start){

        int s,f;
        int len=sec.length()-start;
        for(int i=0;i<len;i++){
            s=sec.charAt(start+i)-'0';
            f=fir.charAt(i)-'0';
            if(s+f==4){//sec.charAt(i)와 fir.charAt(start+i)
                return false;
            }
        }


        return true;
    }


    //                                                      이 end는 sec의 끝 지점.
    public static boolean getRight(String fir, String sec, int end){
        
        int firLen = fir.length();
        int secLen = sec.length();

        int overlap = secLen - end;           // 실제로 겹치는 길이
        int firStart = firLen - overlap;      // fir에서 겹침이 시작되는 위치

        for(int i = 0; i < overlap; i++){
            int s = sec.charAt(i) - '0';                 // sec의 앞부분이 겹침
            int f = fir.charAt(firStart + i) - '0';      // fir의 오른쪽 끝과 겹침
            if(s + f == 4) return false;                 // '2'와 '2' 충돌
        }
        
        return true;
    }

}

//import java.io.*;
//import java.util.*;
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