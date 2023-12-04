import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static char[][] chess;
    public static int min;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        String[] str= br.readLine().split(" ");
        int N=Integer.parseInt(str[0]);
        int M=Integer.parseInt(str[1]);
        arr=new int[M-7][M-7];
        min=64;//싹다 바꾸는 경우 64
        chess=new char[N][M];
        for(int i=0;i<N;i++){
            String[] str2= br.readLine().split("");
            for(int j=0;j<M;j++){
                chess[i][j]=str2[j].charAt(0);
            }
        }

        for(int i=0;i<=N-8;i++){
            for(int j=0;j<=M-8;j++){
                startWhite(i,j);
            }
        }
        System.out.println(min);

    }


    //누적합은 안되겠다. 시작점에 따라 다 달라짐
    public static void startWhite(int i,int j){// 각 줄단위로만 셀까.
        int sum=0;//sum은 희색 시작시
            for(int a=0;a<8;a++){//1 3 5 7
                for(int b=0;b<8;b++){
                    if((a+b)%2==1){//검정 부분
                        if(chess[i+a][j+b]=='B') sum++;//색이 다르면 추가.
                    }else{// 흰색 부분//0 2 4 6
                        if(chess[i+a][j+b]=='W') sum++;
                    }
                }
            }
            sum=Math.min(sum,64-sum);//검정시작은 흰색시작을 64에서 뺸 값., 둘 중 큰것을 비교하면 될듯
            min=Math.min(min,sum);
    }

}
