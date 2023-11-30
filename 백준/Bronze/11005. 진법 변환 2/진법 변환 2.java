import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] str=br.readLine().split(" ");
        int sub;
        int B=Integer.parseInt(str[1]);
        int N=Integer.parseInt(str[0]);
        char sub2;
        Stack<Character> stack = new Stack<>();

        while(N>0){
            sub=N%B;
            if(sub>=10){
                sub2= (char) (sub-10+'A');
 
            }else{
                sub2= (char) (sub + '0');
            }
            stack.push(sub2);
            N=N/B;
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
