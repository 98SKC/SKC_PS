#include <iostream>
#include <vector>
using namespace std;

int main() {
    //cin << 입력넣을변수 입력
    //cout << 출력할문장변수 출력
    
    int N;
    int M;
    cin >> N;
    cin >> M;
    string answer;
    if (N > M) {
        answer = ">";
    }
    else if(N<M){
        answer = "<";
    }
    else {
        answer = "==";
    }
    
    cout << answer;

    return 0;                   // 정상 종료 시 0 반환
}
