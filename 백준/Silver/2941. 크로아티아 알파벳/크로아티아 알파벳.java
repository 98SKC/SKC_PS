import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.InflaterInputStream;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		int count=0;
		
		for(int i=0;i<str.length();i++) {
			if(i==str.length()-1) {//문자열이 뒤에 더 없음.
				count++;
				break;
			}
			//System.out.println(str.charAt(i));
			switch(str.charAt(i)) {// switch 들어왔다는 것은 옆에 문자가 더 있다는 의미
			
				case'c':
					if(str.charAt(i+1)=='='||str.charAt(i+1)=='-') {
						i++;// 오른쪽까지 한 단어.
						count++;//알파벳 개수 증가.
					}else {
						count++;//알파벳 개수 증가.
					} 
					break;
				case 'd':
					if(str.charAt(i+1)=='-') {
						i++;// 오른쪽까지 한 단어.
						count++;//알파벳 개수 증가.
					}else if(i<=str.length()-3&&str.charAt(i+1)=='z'&&str.charAt(i+2)=='='){// 여긴 문자 하나 더 필요.	
						i=i+2;// 오른쪽까지 한 단어.
						count++;//알파벳 개수 증가.
					}else{
						count++;//알파벳 개수 증가.
					}
					break;
				case 'l': case 'n':
					if(str.charAt(i+1)=='j') {
						i++;// 오른쪽까지 한 단어.
						count++;//알파벳 개수 증가.
					}else {
						count++;//알파벳 개수 증가.
					} 
					break;
				case 's': case 'z':
					if(str.charAt(i+1)=='=') {
						i++;// 오른쪽까지 한 단어.
						count++;//알파벳 개수 증가.
					}else {
						count++;//알파벳 개수 증가.
					} 
					break;	
	            default: 
	            	count++;
	            	break;	
			}
			//System.out.println(count);
		}
		System.out.println(count);

	}

}
