import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Stack<Integer> stack = new Stack<>();
        int [] answer=new int[numbers.length];
        Arrays.fill(answer,-1);
         
        for(int i=0 ; i<numbers.length ; i++) {
        	
			if(stack.isEmpty() || numbers[i]<numbers[i-1]) {//스택이 비었거나 다음 숫자가 더 작으면 스택에 인덱스를 쌋는다.
				stack.push(i);
			} else {
				while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]) {// 스택이 비어있지 않고, 스택의 top이 쌓으려는 숫자보다 작으면 해당 인덱스의 answer은 쌓으려는 값이다.
					answer[stack.pop()] = numbers[i];
				}
				stack.push(i);
			}
        }  
         
        return answer;
    }
}