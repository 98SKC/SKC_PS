class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        // 일렬의 N개의 풍선. 풍선마다 번호가 있음. 서로 다름. 음수 있음
        // 임의의 인접한 두 풍선 선택. 하나를 터트림  -> 번호가 더 작은 풍선을 터트릴 수 잇는건 최대 1번 (일단 DP) 
        // 풍선 사이에 빈 공간이 생기면 풍선들을 중앙으로 밀착?
        
        // 어떤 방식으로도 최후의 하나가 될 수 있는 풍선의 개수를 리턴하라
        
        // 일단 정렬 안돼.
        // N은 1백만. N^2안됨
        
        // n이거나 logN이거나 nlogN은 애매
        
        
        // 일단 큰 풍선들이 계속 터져감. 
        // 가장 작은 풍선이 있다고 하자.
        // 가장 작은 풍선에게 터트리는 기회를 사용하면 무조건 2번째로 작은 풍선이 남을건데
        // 좌 우를 봐야하나
        
        int len= a.length;
        int[] leftMin=new int[len];// i의 왼쪽 중 가장 작은 수
        int[] rightMin=new int[len];// i의 오른쪽 중 가장 작은 수
        
        int min=1000000001;
        for(int i=0;i<len;i++){
            if(min>a[i]){
                min=a[i];
            }
            leftMin[i]=min;
        }
        min=1000000001;
        for(int i=len-1;i>=0;i--){
            if(min>a[i]){
                min=a[i];
            }
            rightMin[i]=min;
        }
        answer=2; //양끝은 모두 가능
        for(int i=1;i<len-1;i++){
            if(a[i]<leftMin[i-1]||a[i]<rightMin[i+1]) answer++;//양쪽중 하나라도 나보다 크면 가능
        }
        
        return answer;
    }
}