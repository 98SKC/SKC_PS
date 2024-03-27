import java.util.*;
import java.io.*;



public class Main {

	
	static int[][] map=new int[9][9];//
	static boolean check=false;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str;
		//스도쿠 입력 받기 
		for(int i=0;i<9;i++) {
			str=br.readLine();
			for(int j=0;j<9;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		
		sudoku(0);
			
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	static void sudoku(int pos) {
		if(check) return;
		if(pos==81) {
			check=true;
			return;
		}
		
		if(map[pos/9][pos%9]==0) {
		    for(int a=1;a<=9;a++) {
		        map[pos/9][pos%9]=a;
		        if(checkCol(pos%9)&&checkRow(pos/9)&&checkSquare(pos)) {    
		            sudoku(pos+1);
		            if(check) return;
		        }
		        map[pos/9][pos%9]=0; // 숫자 a가 유효하지 않으면 원래 상태로 되돌림
		    }
		}else {
		    sudoku(pos+1);
		}

	}
	
	//세로 쳌,
	static boolean checkCol(int j) {
		boolean[] number=new boolean[10];
		
		for(int i=0;i<9;i++){
			if(map[i][j]!=0&&!number[map[i][j]]) {
				number[map[i][j]]=true;
			}else if(map[i][j]!=0&&number[map[i][j]]) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean checkRow(int i) {
		boolean[] number=new boolean[10];
		
		for(int j=0;j<9;j++){
			if(map[i][j]!=0&&!number[map[i][j]]) {
				number[map[i][j]]=true;
			}else if(map[i][j]!=0&&number[map[i][j]]) {
				return false;
			}
		}
		return true;
	}
	
	static boolean checkSquare(int pos) {
	    boolean[] number=new boolean[10];
	    int i=pos/9;
	    int j=pos%9;
	    int startI=(i/3)*3;
	    int startJ=(j/3)*3;

	    for(int a=startI; a<startI+3; a++) {
	        for(int b=startJ; b<startJ+3; b++) { 
	            if(map[a][b]!=0 && !number[map[a][b]]) { 
	                number[map[a][b]]=true;
	            } else if(map[a][b]!=0 && number[map[a][b]]) {
	                return false;
	            }
	        }
	    }
	    return true;
	}

}