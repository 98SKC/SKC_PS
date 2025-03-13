
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] card=new int[N];
        int[] score=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int max=0;
        for(int i=0;i<N;i++) {
        	card[i]=Integer.parseInt(st.nextToken());
        	max=Math.max(max, card[i]);
        }
        
        
        int[] arr=new int[max+1];
        for(int i=0;i<N;i++) {
        	arr[card[i]]=i+1;
        }
        int current;
        //시초가 날거라고 생각했는데 안나...네?
        for (int i = 0; i < N; i++) {
            current = card[i];
            for (int j = current * 2; j <= max; j += current) {
                if (arr[j] != 0) {
                    score[arr[j] - 1]--;
                    score[i]++;
                }
            }
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i:score) {
        	sb.append(i+" ");
        }
        
        System.out.println(sb);
    }
}
