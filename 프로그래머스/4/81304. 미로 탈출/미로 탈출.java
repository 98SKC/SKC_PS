import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = -1;
        
        
        //같은 노드 두개에 대해 다른 간선이 있을 수 있으니 최소만 남기도록 초기화
        int[][] edges=new int[n+1][n+1];
        int r=roads.length;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                edges[i][j]=Integer.MAX_VALUE;      
            }
        }
        
        for(int i=0;i<r;i++){
            int s=roads[i][0];
            int e=roads[i][1];
            int l=roads[i][2];
            edges[s][e]=Math.min(edges[s][e],l);
        }
        
        ArrayList<int[]>[] road = new ArrayList[n+1];
        ArrayList<int[]>[] reverse = new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            road[i]=new ArrayList<int[]>();
            reverse[i]=new ArrayList<int[]>();
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(edges[i][j]!=Integer.MAX_VALUE){
                    road[i].add(new int[]{j,edges[i][j]});
                    reverse[j].add(new int[]{i,edges[i][j]});
                }      
            }
        }
        
        // 최단경로를 구하면서 문제점
        // 1. 트랩 발동시 간선 방향이 반대
        // 2. 모든 간선이 반대도 아니고, 트랩과 연결된 간선만 반대
        
        // 트랩 발동 현황을 비트마스킹을 통해 v확인?
        // 노드가 1천개인데, 1천자리짜리 2진수??
        
        // 그리고 큐에서 꺼낸 케이스별로 트랩 동작 현황을 기록 가능한 방법이 무엇이 있을까
        // 방문 처리할 때 트랩 발동현황이 중요한데
        // 같은 방향으로들어와도 트랩 발동 상태에 따라 새로운 루트가 생길 수 있는데 분명
        // 트랩이 10개라 흐음... 매핑하고 비트마스킹?
        // 역방향의 간선은 어떻게 관리하지. 간선 리스트 자체를 두개로? 메모리 제한이 통과되나
        
        HashMap<Integer,Integer> t=new HashMap<>();
        for(int i=0;i<traps.length;i++){
            t.put(traps[i],i);// t.get(노드번호) -> 트랩 번호
        }
        
        int[][] dijk=new int[n+1][1024];// i노드를 j상태로 방문했을 때 최소 값 
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<1024;j++){
                dijk[i][j]=Integer.MAX_VALUE;
            }
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[1],o2[1]);
            }
        });
        
        //위치, 이동거리, 상태
        pq.add(new int[]{start,0,0});
        
        while(!pq.isEmpty()){
            
            
            int[] p=pq.poll();
            
            if(p[0]==end){
                answer=p[1];
                break;
            }
            
            if(dijk[p[0]][p[2]]<p[1]) continue;
            
            //만약 지금 트랩이면 상태변화
            int state=p[2];
            if(t.containsKey(p[0])) state ^= (1 << t.get(p[0]));
            
            ArrayList<int[]> next;
            
            //만약 이 노드가 트랩이면, 그리고 활성이 이번에 되었으면(원래 활성이X) 역방향만 
            if(t.containsKey(p[0])&&(p[2]&(1<<t.get(p[0])))==0){
                next=reverse[p[0]];
            }else{
                next=road[p[0]];
            }
            
            
            
            // nn : next node
//             for(int[] nn: next){
//                 int node=nn[0];// 다음 노드
//                 int s=nn[1];//다음 노드 간선.
                
//                 //만약 다음 간선이 활성화된 트랩이면 간선이 반대라 갈 수 없다. X
//                 //둘 다 활성화 되어있던가, 둘 다 활성화가 안되있던가 O
//                 // -> 조건식을 짧게 못만드나
//                 // 근데 반대로 다음 노드가 아니라,원래는 못가는 노드인데 거기 트랩이 활성되어서 갈 수 잇는건 지금 못처리하지 않나. 코드 전문을 바꿔야 할 판인데 하...
                
//                 //근데 그러러면 자기 노드를 향하는 노드도 따로 저장해야하는거 아닌가. 
//                 //그게 reverse이긴 한데
//                 //next로 고정이 아니라 정방향으로 갈 수 있는것, 역방향 가능한 것. 이렇게?
        
//                 if(t.containsKey(node)&&((state<<t.get(node)))!=0) continue;
                
//                 if(dijk[node][state]>s+p[1]){
//                     dijk[node][state]=s+p[1];
//                     pq.add(new int[]{node,dijk[node][state],state});
//                 }
                
//             }
            // 정방향 
            for(int[] nn : road[p[0]]){

                int node=nn[0];
                int s=nn[1];

                boolean canGo=false;

                //1. 내가 트랩이면
                if(t.containsKey(p[0])){

                    // 1-1 내가 활성화가 되어있으면
                    if((state & (1 << t.get(p[0]))) != 0){

                        //1-1-1 상대가 트랩이면서, 활성화가 되어있어야 함
                        if(t.containsKey(node)
                                && (state & (1 << t.get(node))) != 0){
                            canGo=true;
                        }

                    }else{//1-2 내가 활성화가 되어있지 않다면

                        //1-2-1 상대가 트랩이 아니거나, 트랩이여도 활성화가 안되어있어야함.
                        if(!t.containsKey(node)
                                || (state & (1 << t.get(node))) == 0){
                            canGo=true;
                        }
                    }

                }else{//2. 내가 트랩이 아니면

                    //2-1 상대도 트랩이 아니거나

                    //2-2 트랩이면서 활성이 안되어 있거나.
                    if(!t.containsKey(node)
                            || (state & (1 << t.get(node))) == 0){
                        canGo=true;
                    }
                }

                if(canGo){
                    if(dijk[node][state] > s + p[1]){
                        dijk[node][state] = s + p[1];
                        pq.add(new int[]{node,dijk[node][state],state});
                    }
                }
            }


            //역방향
            for(int[] nn : reverse[p[0]]){

                int node=nn[0];
                int s=nn[1];

                boolean canGo=false;

                //1. 내가 트랩이면
                if(t.containsKey(p[0])){

                    // 1-1 내가 활성화가 되어있으면
                    if((state & (1 << t.get(p[0]))) != 0){

                        //1-1-1 상대가 트랩이면서, 활성화가 되어있지 않아야 함
                        if(!t.containsKey(node)
                                || (state & (1 << t.get(node))) == 0){
                            canGo=true;
                        }

                    }else{//1-2 내가 활성화가 되어있지 않다면

                        //1-2-1 상대가 트랩이면서,활성화가 되어있어야함.
                        if(t.containsKey(node)
                                && (state & (1 << t.get(node))) != 0){
                            canGo=true;
                        }
                    }

                }else{//2. 내가 트랩이 아니면

                    //2-1 상대가 트랩이면서 활성화가 되어 있어야함
                    if(t.containsKey(node)
                            && (state & (1 << t.get(node))) != 0){
                        canGo=true;
                    }
                }

                if(canGo){
                    if(dijk[node][state] > s + p[1]){
                        dijk[node][state] = s + p[1];
                        pq.add(new int[]{node,dijk[node][state],state});
                    }
                }
            }


            
            
        }
        
        return answer;
    }
}