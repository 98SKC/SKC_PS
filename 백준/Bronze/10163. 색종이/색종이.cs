using System;                     // C# 기본 네임스페이스. (Java의 java.lang.*)
using System.Collections.Generic; // 컬렉션(List, Dictionary 등). (Java의 java.util.*)
using System.Text;                // StringBuilder 등 텍스트 유틸. (Java의 java.lang.StringBuilder)

// C#의 엔트리포인트 (Java의 public class Main)
class Program
{
    // 프로그램 진입점. (Java의 public static void main(String[] args))
    static void Main()
    {
        // int.Parse(string) : 문자열을 int로 변환. (Java의 Integer.parseInt)
        // Console.ReadLine() : 한 줄 입력 받기. (Java의 BufferedReader.readLine 또는 Scanner.nextLine)
        int n = int.Parse(Console.ReadLine()!.Trim());
        // "!" : 컴파일러에게 null 아님을 보증. Java에는 없는 요소.

        // var : 자동추론 변수. 컴파일러가 우변을 보고 컴파일 시점에 타입을 정합니다
        // List<(int x, int y, int w, int h)> : C#의 제네릭 리스트 + "값튜플" 문법.
        //  - 값튜플: (int x, int y, ...) 처럼 이름 붙은 튜플 형태. (Java로 치면 Class 선언해서 만든 객체 느낌?)
        var papers = new List<(int x, int y, int w, int h)>(n);

        int maxX = 0, maxY = 0;

        for (int i = 0; i < n; i++)
        {
            // Split : 문자열 분리. (Java의 String.split)
            // StringSplitOptions.RemoveEmptyEntries : 빈 토큰 제거 옵션. (Java split은 정규식 기반, 빈 문자열 제어는 후처리)
            var sp = Console.ReadLine()!.Split(' ', StringSplitOptions.RemoveEmptyEntries);

            // int.Parse : 각 토큰을 정수로 변환. (Java의 Integer.parseInt)
            int x = int.Parse(sp[0]);
            int y = int.Parse(sp[1]);
            int w = int.Parse(sp[2]);
            int h = int.Parse(sp[3]);

            // List<T>.Add : 리스트에 요소 추가. (Java의 List.add)
            papers.Add((x, y, w, h));

            // Math.Max : 최대값 계산. (Java의 Math.max)
            maxX = Math.Max(maxX, x + w);
            maxY = Math.Max(maxY, y + h);
        }

        // 2차원 배열 생성 (행, 열). (Java의 new int[rows][cols]와 유사하나, C#은 진짜 2D 배열 int[,] 지원)
        // 보드 인덱스는 [y, x] 순서로 사용할 것 (문제 좌표계 반영)
        var board = new int[maxY, maxX];

        // 색종이 번호: 1..n (입력 순서)
        for (int idx = 1; idx <= n; idx++)
        {
            // papers[idx-1]의 (x, y, w, h)를 한 번에 풀어 받음.
            var (x, y, w, h) = papers[idx - 1];

            for (int r = y; r < y + h; r++)
            {
                for (int c = x; c < x + w; c++)
                {
                    // 마지막에 덮은 종이 번호가 남도록 갱신
                    board[r, c] = idx;
                }
            }
        }

        // 각 종이 번호별 남은 칸 수 카운팅 (1..n 사용, 0은 미사용)
        var area = new int[n + 1];

        // 2차원 배열 전체 순회
        for (int r = 0; r < maxY; r++)
        {
            for (int c = 0; c < maxX; c++)
            {
                int idx = board[r, c];
                if (idx > 0) area[idx]++;
            }
        }

        // StringBuilder : 문자열 누적 후 한 번에 출력. (Java의 StringBuilder와 동일 개념)
        var sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.AppendLine(area[i].ToString()); // ToString() : 숫자를 문자열로. (Java의 String.valueOf/Integer.toString)

        // Console.Write : 출력. (Java의 System.out.print/println)
        Console.Write(sb.ToString());
    }
}
