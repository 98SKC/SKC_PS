import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int R=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		
		/*이분탐색이 가능한 이유.
		mid=a행에 대해서 a에서 중복되는 문자열이 없으면
		그 위쪽에 어떤 행을 붙이더라도 중복되는 문자열이 생기지 아니함
		그렇기에 마음 놓고 더 아래쪽 행을 탐색해도 된다.
		*/
		String sub;
		char[][] str=new char[R][C];
		for(int r=0;r<R;r++) {
			sub=br.readLine();
			for(int c=0;c<C;c++) {
				str[r][c]=sub.charAt(c);
			}
		}
		
		int left=0;
		int right=R-1;
		boolean duplication;
		StringBuilder sb;
		HashSet<String> set;
		while(left<=right) {
			set=new HashSet<>();
			duplication=false;
			int mid=left+(right-left)/2;
			for(int c=0;c<C;c++) {
				sb=new StringBuilder();
				for(int r=mid;r<R;r++) {
					sb.append(str[r][c]);
				}
				if(set.contains(sb.toString())) {
					duplication=true;
					break;
				}else {
					set.add(sb.toString());
				}
			}
			
			if(duplication) {// 좀 더 위에서 (mid가 작아져야함. 0부터 시작하니)
				right=mid-1;
			}else {//좀 더 아래를 봐도 됨. mid가 커져도됨
				left=mid+1;
			}
			
		}
		//
		System.out.println(left-1);
	}
	
	

}