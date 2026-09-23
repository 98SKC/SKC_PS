class Solution {
    public int solution(int chicken) {
        int answer = 0; // 받을 수 있는 총 서비스 치킨 수
        int coupon = chicken; // 처음 주문한 치킨 수만큼 쿠폰이 발급됨

        // 쿠폰이 10장 이상 있는 동안 계속 반복
        while (coupon >= 10) {
            int newChicken = coupon / 10; // 새로 받을 수 있는 서비스 치킨 수
            int restCoupon = coupon % 10; // 서비스 치킨을 바꾸고 남은 쿠폰 수
            
            answer += newChicken; // 서비스 치킨 누적
            coupon = newChicken + restCoupon; // 새 치킨에서 나온 쿠폰 + 남은 쿠폰
        }

        return answer;
    }
}
