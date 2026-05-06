class Solution {
  public int solution(int n) {
      int answer = 0;
      
      		for(int i=1; i<=n; i++) {
			if(n%i == 0) {
				answer += i;
			}
		}
      //깃 잔디 반영이 안되어 다시 push
	  int git=1;
      return answer;
  }
}