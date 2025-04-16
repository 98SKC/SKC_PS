import java.io.*;
import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        //동영상 길이: video_len
        //재생위치: pos
        //오프닝 시작시간 op_start
        //오프닝 끝나는 시각: op_end
        //사용자 입력 commands
        int video=conversionInt(video_len);
        int p=conversionInt(pos);
        int start=conversionInt(op_start);
        int end=conversionInt(op_end);
        
        
        for(int i=0;i<=commands.length;i++){
            if(p>=start&&p<=end){
                p=end;
            }
            if(i==commands.length) break;
            if(commands[i].equals("prev")){
                p-=10;
                p=Math.max(p,0);
            }else{
                p+=10;
                p=Math.min(p,video);
            }
            
        }
        answer=conversionString(p);
        return answer;
    }
    public int conversionInt(String time) {
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]);
        int minute = Integer.parseInt(t[1]);
        return hour * 60 + minute;
    }
    
    
    public String conversionString(int time) {
        int hour = time / 60;
        int minute = time % 60;
    
        return String.format("%02d:%02d", hour, minute);
    }
}