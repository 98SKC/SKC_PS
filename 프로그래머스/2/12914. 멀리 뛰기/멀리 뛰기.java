

class Solution {
    long[] arr;
    public long solution(int n) {
        long answer = 0;
       
        if(n==1||n==0) return 1;
        
        arr=new long[n+1];
        arr[2]=2;
        arr[1]=1;
        arr[0]=0;
        answer=helper(n);

        return answer%1234567;
    }
    public long helper(int n){
        if(arr[n]!=0){
            return arr[n];
        }else{
            long count=helper(n-2)+helper(n-1);
            arr[n]=count%1234567;
            return arr[n];
        }

    }
}