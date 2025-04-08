
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int R=Integer.parseInt(st.nextToken())-1; //r-1
        int C=Integer.parseInt(st.nextToken())-1; //c-1
        int K=Integer.parseInt(st.nextToken());
        
        int[][] arr=new int[3][3];
        for(int i=0;i<3;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<3;j++){
        		arr[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        int turn=0;
        for(int t=0;t<=100;t++) {
        	if(arr.length>R&&arr[0].length>C){// r,c
        		if(arr[R][C]==K) {
        			break;        			
        		}
        	}
        	int max=0;

        	
        	if(arr.length>=arr[0].length){//행의 개수>= 열의 개수. 모든 행에 대해서 정렬 적용
            	PriorityQueue<int[]>[] pq=new PriorityQueue[arr.length];
            	for(int i=0;i<arr.length;i++) {
            		pq[i]=new PriorityQueue<>(new Comparator<int[]>() {
            			@Override
            			public int compare(int[] o1, int[] o2) {
            				if(o1[1]==o2[1]){
            					return o1[0]-o2[0];
            				}
            				return o1[1]-o2[1];
            			}
            		});
            	}
        		for(int i=0;i<arr.length;i++) {
            		Arrays.sort(arr[i]);
            		int count=1;
            		int before=arr[i][0];
            		for(int j=1;j<arr[0].length;j++){
            			if(arr[i][j]!=before) {
            				if(before!=0) pq[i].add(new int[] {before,count});
            				before=arr[i][j];
            				count=1;
            			}else {
            				count++;
            			}
            		}
            		pq[i].add(new int[] {before,count});
            		max=Math.max(pq[i].size()*2, max);
            		//max 바꿔가며 적용
            	}
            	arr=new int[arr.length][max];
            	for(int i=0;i<arr.length;i++) {
            		int idx=0;
            		int[] sub;
            		while(!pq[i].isEmpty()) {
            			sub=pq[i].poll();
            			arr[i][idx]=sub[0];
            			arr[i][idx+1]=sub[1];
            			idx+=2;
            		}
            	}
            }else {//열 단위로 정렬. arr[0].length가 고정
            	
            	//-------------------------------
            	PriorityQueue<int[]>[] pq=new PriorityQueue[arr[0].length];
            	for(int j=0;j<arr[0].length;j++) {
            		pq[j]=new PriorityQueue<>(new Comparator<int[]>() {
            			@Override
            			public int compare(int[] o1, int[] o2) {
            				if(o1[1]==o2[1]){
            					return o1[0]-o2[0];
            				}
            				return o1[1]-o2[1];
            			}
            		});
            	}
            	
        		for(int j=0;j<arr[0].length;j++) {
        			int[] column = new int[arr.length];
        		    for (int i = 0; i <arr.length; i++) {
        		        column[i] = arr[i][j];
        		    }
        			Arrays.sort(column);
            		int count=1;
            		int before=column[0];
            		for(int i=1;i<column.length;i++){
            			if(column[i]!=before) {
            				if(before!=0) pq[j].add(new int[] {before,count});
            				before=column[i];
            				count=1;
            			}else {
            				count++;
            			}
            		}
            		pq[j].add(new int[] {before,count});
            		max=Math.max(pq[j].size()*2, max);
            		//max 바꿔가며 적용
            	}
            	arr=new int[max][arr[0].length];
            	for(int j=0;j<arr[0].length;j++) {
            		int idx=0;
            		int[] sub;
            		while(!pq[j].isEmpty()) {
            			sub=pq[j].poll();
            			arr[idx][j]=sub[0];
            			arr[idx+1][j]=sub[1];
            			idx+=2;
            		}
            	}
            	//-------------------------------

            }

        	turn++;
        }
        if(turn==101) turn=-1;

        System.out.println(turn);
        

        
    }
}
