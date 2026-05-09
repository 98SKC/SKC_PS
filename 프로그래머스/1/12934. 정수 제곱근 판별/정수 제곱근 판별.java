class Solution {
  public long solution(long n) {
      
      
      if(n==1){
          return 4;
      }
      
      for(long i=2;i<n;i++){
          if(n/i == i && n%i ==0){
              return (i+1)*(i+1);
          }
      }
      
      return -1;
  }
}