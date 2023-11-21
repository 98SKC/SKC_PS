import java.util.*;
class Solution {
    public long solution(int[] weights) {
        
        Map<Double, Integer> hm = new HashMap<>();
		
        long answer = 0;
        Arrays.sort(weights);//작은 것 부터 차례대로 정렬.
		for(int weight : weights) {// 향상된 for문. 
			
            answer += helper(weight, hm);
		}
		return answer;
    }
	
	public long helper(int w, Map<Double, Integer> hm) {
		
        //가벼운 사람 보다 무거운 사람이 더 멀리가지 못하는 것으로 경우의 수를 줄임.
        long ret = 0;
        // a의 시소거리: b의 시소거리= b몸무게:a몸무게 이용.
		double d1 = w*1.0; //몸무게가 같은 경우
		double d2 = (w*2.0)/3.0;//몸무게 비율이 3:2
		double d3 = (w*1.0)/2.0;//몸무게 비율이 4:2 즉 2:1
		double d4 = (w*3.0)/4.0;//몸무게 비율이 4:3
        //d의 값들은 w와 같이 탈 수 있는 무게들.
        
        //같이 탈수 있는 무게를 가진 친구들이 있었는지 학인.
		if(hm.containsKey(d1)) ret += hm.get(d1);
		if(hm.containsKey(d2)) ret += hm.get(d2);
		if(hm.containsKey(d3)) ret += hm.get(d3);
		if(hm.containsKey(d4)) ret += hm.get(d4);
		hm.put(w*1.0, hm.getOrDefault(w*1.0, 0)+1); //자기 자신도 키값에 넣는다. 
                                                    //만약 자기랑 같은 몸무게의 친구가 없었으면 1이 값.
		return ret;
	}
}