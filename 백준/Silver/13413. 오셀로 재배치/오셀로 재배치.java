import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int W,B;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		String original, target;
		while(t-->0){
			W = B = 0;
			Integer.parseInt(in.readLine());
			original = in.readLine();
			target = in.readLine();
			System.out.println(findDiff(original, target));
		}
		in.close();
	}
	private static int findDiff(String original, String target){
		int i, len = original.length(), count=0;
		char o, t;
		for(i=0;i<len;i++){
			o = original.charAt(i);
			t = target.charAt(i);
			if(o != t){
				if(o == 'W') W++;
				else B++;
			}
		}
		count+=(Math.min(W, B)+Math.abs(W-B));
		return count;
	}
}