
import java.util.*;
import java.io.*;
import java.math.MathContext;


class Solution{
	public static int[][] sudoku=new int[9][9];
	//public static boolean[] check=new boolean[10];// 배열이 좋을까 set이 좋을까. 
	public static HashSet<Integer> set=new HashSet<Integer>();
	public static void main(String args[]) throws Exception{
		
		boolean check=true;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());


		for(int test_case = 1; test_case <= T; test_case++){
			
			for(int i=0;i<9;i++) {// 스쿠토 맵 만들기
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0;j<9;j++) {
					sudoku[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			check=rowSearch();
			if(check) check=colSearch();
			if(check) check=boxSearch();
			if(check) {
				System.out.println("#"+test_case+" "+1);
			}else {
				System.out.println("#"+test_case+" "+0);
			}			
		}
	}
	public static boolean rowSearch() {
	    int count=0;
	    boolean check2=true;
		while(count<9&&check2) {
			set.clear();
	    	for(int i=0;i<9;i++) {
	    		if(!set.contains(sudoku[count][i])) {
	    			set.add(sudoku[count][i]);
	    		}else {
	    			check2=false;
	    			break;
	    		}
	    	}
	    	count++;
	    }
	    set.clear();
	    return check2;
	}
	public static boolean colSearch(){
		int count=0;
	    boolean check2=true;
		while(count<9&&check2) {
			set.clear();
	    	for(int i=0;i<9;i++) {
	    		if(!set.contains(sudoku[i][count])) {
	    			set.add(sudoku[i][count]);
	    		}else {
	    			check2=false;
	    			break;
	    		}
	    	}
	    	count++;
	    }
		set.clear();
	    return check2;
	}
	public static boolean boxSearch() {
	    for (int boxRow = 0; boxRow < 9; boxRow += 3) {
	        for (int boxCol = 0; boxCol < 9; boxCol += 3) {
	            set.clear();
	            for (int i = boxRow; i < boxRow + 3; i++) {
	                for (int j = boxCol; j < boxCol + 3; j++) {
	                    if (sudoku[i][j] != 0 && !set.add(sudoku[i][j])) {
	                    	set.clear();
	                    	return false;
	                    }
	                }
	            }
	        }
	    }
	    set.clear();
	    return true;
	}

}