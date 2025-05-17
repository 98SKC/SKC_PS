import java.util.*;
import java.io.*;


class Solution {
    public boolean[] v;
    public int N,len;
    public int count=Integer.MAX_VALUE;
    public HashMap<String,Integer> map=new HashMap<>();
    public String[] w;
    public ArrayList<Integer>[] list;
    public int solution(String begin, String target, String[] words) {
        
        int answer = 0;
        N=words.length;
        
        for(int i=1;i<=N;i++){
            map.put(words[i-1],i);
        }
        
        len=begin.length();
        list=new ArrayList[N+1];
        v=new boolean[N+1];
        w=new String[N+1];
        w[0]=begin;
        map.put(begin,0);
        for(int i=1;i<=N;i++){
            w[i]=words[i-1];
        }
        int sub=0;
        for(int i=0;i<=N;i++){
            list[i]=new ArrayList<>();
        }
        
        for(int i=0;i<N;i++){
            for(int j=i+1;j<=N;j++){
                sub=0;
                for(int k=0;k<len;k++){
                    if(w[i].charAt(k)!=w[j].charAt(k)){
                        sub++;
                    }
                }
                if(sub==1){
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        dfs(begin,target,0);
        
        if(count!=Integer.MAX_VALUE) answer=count;
        
        return answer;
    }
    
    public void dfs(String begin,String target, int cnt){
        if(count<cnt) return;
        
        if(begin.equals(target)){
            count=Math.min(cnt,count);
            return;
        }
        
        for(int next:list[map.get(begin)]){
            if(v[next]) continue;
            v[next]=true;
            dfs(w[next],target,cnt+1);
            v[next]=false;
            
        }
        
    }
}