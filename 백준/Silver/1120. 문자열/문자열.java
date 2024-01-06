import java.io.*;
import java.util.*;

public class Main {
	 
    public static void main(String [] args) throws IOException{
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        String str1 = st.nextToken();
        String str2 = st.nextToken();

        int result = str1.length();

        for(int i=0;i<str2.length()-str1.length()+1;i++){
            int sub=0;
            for(int j=0;j<str1.length();j++){
                if(str1.charAt(j)!=str2.charAt(j+i)){
                    sub++;
                }
            }
            if(result > sub){
                result = sub;
            }
        }

        System.out.println(result);
    }
}