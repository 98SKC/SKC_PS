import java.util.*;
import java.io.*;


public class Main {

    //substring 복습
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        List<String> sArr=new ArrayList<String>();
        StringBuilder s1;
        StringBuilder s2;
        StringBuilder s3;
        StringBuilder answer;
        //substring(i);-> i인덱스부터 끝까지(i인덱스 포함)
        //substring(-1);->음수거나 범위를 넘으면 에러
        //substring(str.length());마지막 인덱스 +1로 지정하면 빈 문자열 리턴
        //substring(i,j);-> i~j직전(i포함, j미포함)
        for(int i=1;i<str.length();i++){
        	for(int j=i+1;j<str.length();j++) {
        		s1=new StringBuilder(str.substring(0,i));
        		s2=new StringBuilder(str.substring(i,j));
        		s3=new StringBuilder(str.substring(j));
        		answer=new StringBuilder();
        		answer.append(s1.reverse()).append(s2.reverse()).append(s3.reverse());
        		sArr.add(answer.toString());
        	}
        }
        Collections.sort(sArr);
        System.out.println(sArr.get(0));
    }

}