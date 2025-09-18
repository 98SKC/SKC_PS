import java.io.*;
import java.util.*;

public class Main {

	public static class Room{
		int number;
		int lev;
		boolean start=false;
		//String start="Waiting!";
		
		ArrayList<String> member;
		public Room(int number, int lev) {
			this.number=number;
			this.lev=lev;
			member=new ArrayList<>();
		}
		
		public void add(String newMember) {
			member.add(newMember);
			if(member.size()==M) {
				//start="Started!";
				start=true;
			}
		}
		
	}
	public static int P,M;
	public static HashMap<String,Integer> map=new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        P=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int level;
        String name;
        int max=1;
        List<Room> list=new ArrayList<>();
        boolean next;
        for(int p=1;p<=P;p++) {
        	st = new StringTokenizer(br.readLine());
        	level=Integer.parseInt(st.nextToken());
        	name=st.nextToken().toString();
        	map.put(name,level);
        	next=false;
        	//먼저 만들어진 순서대로 방을 순회
        	for(Room room:list){
        		if(!room.start&&check(level,room.lev)) {
        			room.add(name);
        			next=true;
        		}
        		if(next) break;
        	}
        	if(!next) {
        		Room r=new Room(max++,level);
        		r.add(name);
        		list.add(r);
        	}
        }
        StringBuilder sb=new StringBuilder();
        
    	for(Room room:list){
    		if(room.start) {
    			sb.append("Started!\n");
    		}else {
    			sb.append("Waiting!\n");
    		}
    		Collections.sort(room.member);
    		for(String u:room.member) {
    			sb.append(map.get(u)+" "+u);
    			sb.append("\n");
    		}
    	}
        
        //한 유저가 들어왔을 때,
        //자신의 레벨 +-10인 방이 있으면 가장 먼저 생성된 곳에 들어가고, 아니면 방을 만들고
        
        // 출력은 방이 생성된 순서에 맞게.
        // 방에 있는 플레이어들의 정보는 닉네임이 사전순으로 앞서는 플레이어부터 출력
        
        
        System.out.println(sb);
    }
    public static boolean check(int user, int room) {
    	if(Math.abs(room-user)<=10) return true;
    	return false;
    }

}
