class Solution {
    //              퍼즐의 난이도    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        //diff 현 퍼즐의 난이도
        //time_cur 현 퍼즐의 소요시간
        //time_prev 이전 퍼즐의 소요시간
        //level 나의 숙련도
        
        //diff<=level time_cur만큼의 시간으로 틀리지 않음
        //diff>level  diff-level번 틀림. 각 시도마다 time_cur 소요. time_prev만큼 소요하여 이전 퍼즐 다시 품.
        //int[] diffs, int[] times, long limit
        int left=1;
        int right=0;
        for(int i=0;i<diffs.length;i++){
            right=Math.max(right,diffs[i]);
        }
        
        int mid;
        long time=0;
        
        while(left<right){
            mid=left+(right-left)/2;
            time=calTime(diffs,times,limit,mid);
            //System.out.println("mid: "+mid+" left: "+left+" right: "+right);
            if(time>limit){//너무 오래걸림. 레벨을 올린다.
                left=mid+1;
            }else{//레벨을 줄인다.
                right=mid;
            }
            
        }
        
        return left;
    }
    public long calTime(int[] diffs, int[] times, long limit,int level){
        long answer=0;
        int len=diffs.length;
        int diff; 
        int time_cur; 
        int time_prev=0;

        for(int i=0;i<len;i++){
            diff=diffs[i];
            time_cur=times[i];
            if(diff<=level){
                answer+=time_cur;
            }else{
                answer+=(diff-level)*(time_cur+time_prev)+time_cur;
            }
            time_prev=time_cur;
        }
        return answer;
    }
}