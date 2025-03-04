
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        StringBuilder sb = new StringBuilder();
        String sub;
        
        //설마 그리디마냥 발견하면 바로 바꿔도 되나
        for(int i=0;i<str.length();i++) {
            sb.append(str.charAt(i));
            if(sb.length()>=4&&sb.substring(sb.length()-4).equals("PPAP")){//길이가 4이상이고, 지금 끝에서부터 앞으로 4길이가 PPAP이면
                //"PPAP"를 발견하면 "P" 하나로 축소 (마지막 3문자 제거)
//            	sub=sb.substring(0,sb.length()-4)+"P";
//            	sb=new StringBuilder();
//            	sb.append(sub);
            	sb.delete(sb.length()-3,sb.length());
            }
        }


        if(sb.toString().equals("P")) {
        	System.out.println("PPAP");
        }else {
        	System.out.println("NP");
        }
        
    }
    

}
