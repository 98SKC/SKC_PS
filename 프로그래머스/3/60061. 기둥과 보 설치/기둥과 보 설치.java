import java.util.*;

class Solution {
    public int[] di=new int[]{0,0,1,-1}; // 우좌, 하상
    public int[] dj=new int[]{1,-1,0,0};
    
    // set 두개를 사용
    //i*n+j좌표에서 보는 우측으로, 타워는 위로 있다고 생각한다.
    public HashSet<Integer> bo=new HashSet<>();
    public HashSet<Integer> tower=new HashSet<>();

    public int n;
    
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        
        this.n=n;
        
        for(int[] direct:build_frame){
            int i=direct[0];
            int j=direct[1];

            if(direct[2]==0){//기둥
                if(direct[3]==0){//삭제
                    if(isVaildDeleteTower(i,j)){
                        tower.remove(getKey(i,j));
                    }
                }else{//설치
                    if(isVaildInsertTower(i,j)) tower.add(getKey(i,j));
                }
            }else{//보
                 if(direct[3]==0){//삭제
                    if(isVaildDeleteBo(i,j)) bo.remove(getKey(i,j));
                }else{//설치
                    if(isVaildInsertBo(i,j)) bo.add(getKey(i,j));
                }
            }
            
        }
        
        List<int[]> result=new ArrayList<>();

        // 기둥 결과 추가
        for(int key:tower){
            int i=key/(n+1);
            int j=key%(n+1);

            result.add(new int[]{i,j,0});
        }

        // 보 결과 추가
        for(int key:bo){
            int i=key/(n+1);
            int j=key%(n+1);

            result.add(new int[]{i,j,1});
        }

        // x좌표 -> y좌표 -> 기둥/보 순으로 정렬
        result.sort((a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            if(a[1]!=b[1]) return a[1]-b[1];
            return a[2]-b[2];
        });

        answer=new int[result.size()][3];

        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        
        return answer;
    }

    // i,j 좌표를 하나의 int값으로 저장
    // 좌표 범위가 0~n이므로 n이 아닌 n+1을 사용
    public int getKey(int i,int j){
        return i*(n+1)+j;
    }
    
    // 보적합성 판단 -> 보를 탐색하여 기둥이 있으면
    public boolean isVaildInsertBo(int pi,int pj){
        //보를 넣으려면, 보의 양 끝 중 하나에 기둥이 있거나 보가 있어야 한다.
        //우선 보의 양 끝은 pi,pj와 pi,pj+1
        //pi,pj를 봤을 때 pi,pj-1에 보가 있으면 되고
        
        //pi,pj+1을 봤을 때 pi,pj+1자체에 보가 있으면 된다

        // 보는 (pi,pj)에서 오른쪽으로 설치된다.
        // 따라서 양 끝 아래의 기둥은
        // (pi,pj-1), (pi+1,pj-1)에 해당한다.

        // 왼쪽 끝 아래에 기둥
        if(pj>0 && tower.contains(getKey(pi,pj-1))){
            return true;
        }

        // 오른쪽 끝 아래에 기둥
        if(pj>0 && tower.contains(getKey(pi+1,pj-1))){
            return true;
        }

        // 양쪽 끝이 다른 보와 연결
        if(pi>0
                && bo.contains(getKey(pi-1,pj))
                && bo.contains(getKey(pi+1,pj))){
            return true;
        }
        
        return false;
    }
    
    // 보적합성 판단 -> 보를 탐색하여 기둥이 있으면
    public boolean isVaildDeleteBo(int pi,int pj){

        // 일단 보를 제거
        bo.remove(getKey(pi,pj));

        // 제거 후 남아있는 모든 구조물이 적합한지 확인
        boolean result=isAllVaild();

        // 실제 삭제는 solution에서 하므로 원상복구
        bo.add(getKey(pi,pj));
        
        return result;
    }
    
    
    // 기둥의 적합성 판단-> 지금 기둥을 제거했을 때 바로 위의 기둥 아래 보가 있어야함. 혹은 기둥이 없거나
    public boolean isVaildInsertTower(int pi,int pj){

        // 바닥이면 기둥 설치 가능
        if(pj==0){
            return true;
        }

        // 바로 아래에 기둥이 있으면 설치 가능
        if(tower.contains(getKey(pi,pj-1))){
            return true;
        }

        // 현재 위치의 오른쪽으로 뻗은 보 위
        if(bo.contains(getKey(pi,pj))){
            return true;
        }

        // 왼쪽에서 현재 위치까지 뻗은 보 위
        if(pi>0 && bo.contains(getKey(pi-1,pj))){
            return true;
        }
        
        return false;
    }
    
    public boolean isVaildDeleteTower(int pi,int pj){

        // 일단 기둥을 제거
        tower.remove(getKey(pi,pj));

        // 제거 후 남아있는 모든 구조물이 적합한지 확인
        boolean result=isAllVaild();

        // 실제 삭제는 solution에서 하므로 원상복구
        tower.add(getKey(pi,pj));
        
        return result;
    }

    // 현재 존재하는 모든 기둥과 보가 설치 조건을 만족하는지 확인
    public boolean isAllVaild(){

        // 기둥 확인
        for(int key:tower){
            int i=key/(n+1);
            int j=key%(n+1);

            if(!isVaildInsertTower(i,j)){
                return false;
            }
        }

        // 보 확인
        for(int key:bo){
            int i=key/(n+1);
            int j=key%(n+1);

            if(!isVaildInsertBo(i,j)){
                return false;
            }
        }

        return true;
    }
}