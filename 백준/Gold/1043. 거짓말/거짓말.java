import java.util.*;
import java.io.*;

public class Main {

	static int[] root;
	//static ArrayList<Integer> truth;
	static HashSet<Integer> truth;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);

		root = new int[N + 1];
		// i의 사람이 속한 파티의 루트노드

		
		//truth = new ArrayList<>(); // 진실을 아는 사람들-> 이 사람들, 혹은 이 사람들과 파티를 하는 사람들과 파티를 한번이라도 이룬다면 거짓을 들을 수 없다.
		truth=new HashSet<Integer>();
		List<Integer>[] party = new List[M];
		
		// 같은 파티에 참여하는 사람들
		int cnt = 0;
		// 과장 해도 되는 파티
		
		for(int i = 0; i < M; i++) {
			party[i]=new ArrayList<>();
		}

		for (int i = 0; i <= N; i++) {
			root[i] = i;
		} // 최초 부모 설정
		
		str = br.readLine().split(" ");
		
		int known = Integer.parseInt(str[0]);
		// 진실을 아는 사람의 수
		
		if(known == 0) { // 진실을 아는 사람이 없음
			System.out.println(M); // 모든 파티에서 가능 하다-> 거짓만 말하고 다녀도 모른다.
			return;
		} else { 
			for (int i = 0; i < known; i++) {
				truth.add(Integer.parseInt(str[i + 1]));
			} // 진실을 아는 자들을 저장
		}
		
		
		for(int i = 0; i < M; i++) {// 파티를 그룹화
			str = br.readLine().split(" ");			
			int p = Integer.parseInt(str[0]); //참가 인원
			int first = Integer.parseInt(str[1]);
			// 파티 참여하는 첫번째 사람

			party[i].add(first);
			//i 파티에 저장

			for(int j = 1; j < p; j++) {
				int next = Integer.parseInt(str[j + 1]);
				union(first, next);// 유니온 파인드
				party[i].add(next);
			}	
		}
		
		for(int i = 0; i < M; i++) {
			boolean check = true;
			//진실을 아는 사람이 없는지 확인
			for(int next : party[i]) {
				if(truth.contains(find(root[next]))) {// 파티에 진실을 아는 사람이 있음
					check = false;
					break; // 거짓말 못함
				}
			}
	
			if(check) { // false가 되지 않았음
				cnt++; // 거짓말 가능
			}
		}
		System.out.println(cnt);
	}

	public static int find(int x) {
		if(root[x] == x) return x;
		else return find(root[x]);
	} // 루트노드 찾기
	
	public static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
    // 두 사람이 참여한 파티의 루트노드
		
		if(truth.contains(py)) {
			int temp = px;
			px = py;
			py = temp;
		} // y쪽 루트 노드가 진실을 아는 사람의 경우 바꿔주기 -> 부모를 타고 갔을 때 진실을 아는 자가 나오도록		
		root[py] = px; 
    // 루트노드 등록
	}
	
}