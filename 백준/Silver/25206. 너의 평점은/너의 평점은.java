import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	
    	double sumSubject=0;
    	double sumGrade=0;
    	double answer=0;
        String gradeList[] = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
        double gradeScore[] = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};
    	
        for(int i=0;i<20;i++) {
        	String[] str=br.readLine().split(" ");// 0-과목, 1-학점, 2- 등급
        	if(str[2].charAt(0)=='P') {// 학점이 p면 합하지 않음.
        		continue;
        	}else {

        		//System.out.println(sumSubject);
        		for(int j=0;j<10;j++) {
        			if(str[2].equals(gradeList[j])) {
                		sumSubject+=gradeScore[j]*Double.parseDouble(str[1]);// 이수 학점 추가
        				sumGrade+=Double.parseDouble(str[1]);
        				break;
        			}
        		}
        	}
        	
        }
        answer=sumSubject/sumGrade;
        System.out.println(answer);
        
    }
}