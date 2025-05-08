#include <iostream>
#include <vector>
using namespace std;

int main() {
    //cin << 입력넣을변수 입력
    //cout << 출력할문장변수 출력
    int N;
    cin >> N;
    vector<int> arr(N);
    int point = 0;
    // 벚꽃을 4 그룹으로 분할
    int sum = 0; //4 그룹의 합
    int sub = 1; //한 그룹의 곱저장 
    int answer = 0;
    for (int i = 0;i<N;i++) {
        cin >> arr[i];
    }
    for (int a = 0;a<N;a++) {

        for (int b = a+1; b < N; b++) {
            
            for (int c = b+1; c < N; c++) {

                for (int d = c+1; d < N; d++) {
                    sum = 0;
                    sub = 1;
                    for (int i = 0;i<b;i++) {
                        sub*=arr[i];
                    }
                    sum += sub;
                    sub = 1;
                    for (int i = b; i < c; i++) {
                        sub *= arr[i];
                    }
                    sum += sub;
                    sub = 1;
                    for (int i = c; i < d; i++) {
                        sub *= arr[i];
                    }
                    sum += sub;
                    sub = 1;
                    for (int i = d; i < N; i++) {
                        sub *= arr[i];
                    }
                    sum += sub;
                    answer = max(answer,sum);
                }
            }
        }
        
    
    }
    cout << answer;

    
    

    return 0;                   // 정상 종료 시 0 반환
}
