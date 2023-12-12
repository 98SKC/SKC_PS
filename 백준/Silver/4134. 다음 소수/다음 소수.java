import java.io.*;
import java.math.BigInteger;

public class Main {
	//입력 부분
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 수

        long[] numbers =  new long[T]; //정수들을 압력받아 저장할 배열

        for(int i = 0; i < T; i++){
            numbers[i] = Long.parseLong(br.readLine()); //정수 입력 받고
        }

        br.close(); //입력 버퍼 닫기

        for(int i = 0; i < numbers.length; i++){
      
            BigInteger bigPrime = new BigInteger(String.valueOf(numbers[i]));
            if(!bigPrime.isProbablePrime(10)){ //만약 지금 받은 매개변수가 소수가 아니면 다음 소수를 저장
                /*isProbablePrime(int certainty):BigInteger 값이 소수일 확률을 반환. certainty는
            	 확률적인 결과를 반환하는데 사용.정수가 소수일 확률이 1-(1/2)^certainty의 확률을 넘는다는 의미이다. 
            	 보통 이 값이 10인 경우 확률이 0.9990234375 정도 되므로 웬만한 큰 수의 소수는 판별한다고 한다.
            	 더 높은 정확성을 위해 11이사으이 값을 넣으면 그만큼 수행시간이 길어진다고 함.
            	*/
 	
            	bigPrime=bigPrime.nextProbablePrime();
            	//nextProbablePrime(): 이 메서드는 해당 BigInteger 값보다 큰 가장 가까운 확률적 소수를 반환
            }
        
            System.out.println(bigPrime);
        }
        
  
    }
  
}
