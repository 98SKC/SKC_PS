import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] str=br.readLine().split(" ");
        double A=Integer.parseInt(str[0]);
        double B=Integer.parseInt(str[1]);
        double V=Integer.parseInt(str[2]);
        int N=0;

        N=(int) Math.ceil((V-A)/(A-B));
        int answer=N+1;

        System.out.println(answer);
    }
}
