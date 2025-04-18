class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        
        //진자 운동으로 겹치는 시간은 절대적으로 고정되어있다.
        
        //"시간+분+초"초 통일하여 합산.
        int start = toSecond(h1,m1,s1);
        int end = toSecond(h2,m2,s2);
        
        //수식: 끝나는 시간까지는 몇번 울리는지 - 시작 시간까지는 몇번울리는지 + 현재 시간에 울리는지
        answer = cal(end) - cal(start) + (alram(start)? 1:0); 
        
        return answer;
    }
    
    static int cal(int time){
        //초침이 분침과 겹치는 횟수
        int sm = time*59/3600; // 분침이 한 바퀴 도는데 초침이랑 59번 겹친다. (59번 알람)
        					   // 그럼 1번 울리는데 3600초에 59번 울리니 3600/59초에 1번.
                               // 3600/59 : 1= time: x (3600/59초에 1번 울리면 time초에 x번 울린다.)
                               // time=3600/59*x
                               // time*59/3600=x
                               //
                               
        //초침이 시침과 겹치는 횟수
        int sh = time*719/43200; // 시침이 한 바퀴 도는데는 43200초
        						 // 60초에 1번 겹치고 60초가 60*12 번.
                                 // 시침이 한바퀴 도는데 720-1 번 겹친다.
                                 // 위와 같은 비례식 사용
        
        
        //시침과 분침과 초침이 모두 겹치는 횟수. 12시기준
        int a = 43200 <= time ? 2 : 1; 
        							  
                                      
        return sm+sh - a;
    }

    //이시간에 알람 울리는가
    static boolean alram(int time){
        return time*59%3600==0 || time*719%43200==0; 
    }
    
        
    static int toSecond(int h,int m,int s){
        int k = h*3600+m*60+s;
        return k;
    }
    
}