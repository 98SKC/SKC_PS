import java.io.*;

public class Main {
    static char[] arr = {'U', 'C', 'P', 'C'};	//UCPC 순서 저장된 배열
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int index = 0;
        boolean check = false;	//"UCPC" 완성 여부 확인 변수
        //입력된 문자열 탐색!
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == arr[index])	//"UCPC"에 순서에 맞게 글자를 찾았을 때
                index++;
            if(index == 4){		//"UCPC" 완성시!
                check = true;
                break;
            }
        }
        //"UCPC" 완성!
        if(check)
            bw.write("I love UCPC");
        else	//"UCPC" 미완성!
            bw.write("I hate UCPC");
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}