import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //quickSort(arr, 0, N - 1); // 절댓값 기준 퀵정렬 수행
        mergeSort(arr, 0, N - 1); // 절댓값 기준 머지 정렬 수행
        // System.out.println(Arrays.toString(arr));
        int a=0;
        int b=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<N-1;i++) {
        	if(Math.abs(arr[i]+arr[i+1])<min) {
        		a=i;
        		b=i+1;
        		min=Math.abs(arr[i]+arr[i+1]);
        	}
        }
        if(arr[a]<arr[b]) {
        	System.out.println(arr[a]+" "+arr[b]);
        }else {
        	System.out.println(arr[b]+" "+arr[a]);
        }
        
    }

    // 퀵정렬을 절댓값 기준으로 정렬
//    public static void quickSort(int[] arr, int left, int right) {
//        if (left >= right) return;
//
//        int pivot = partition(arr, left, right); // 분할 작업 수행
//        quickSort(arr, left, pivot - 1); // 왼쪽 부분 배열 정렬 left~pivoit-1범위
//        quickSort(arr, pivot + 1, right); // 오른쪽 부분 배열 정렬 pivot+1~right범위
//    }
//
//    // 분할 과정: 피벗을 기준으로 작은 값들은 왼쪽, 큰 값들은 오른쪽으로 이동
//    public static int partition(int[] arr, int left, int right) {// 좌측 
//        int pivot = arr[right]; // 마지막 원소를 피벗으로 설정
//        int i = left - 1;
//
//        for (int j = left; j < right; j++) {
//            if (Math.abs(arr[j]) <= Math.abs(pivot)) { // 절댓값 기준 비교
//                i++;
//                swap(arr, i, j); // 작은 값을 왼쪽으로 이동
//            }
//        }
//        swap(arr, i + 1, right); // 피벗을 제자리로 이동
//        return i + 1; // 피벗의 최종 위치 반환
//    }
//
//    // 배열 내 두 요소 교환
//    public static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
    // 절댓값 기준 머지 정렬 (Merge Sort)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    // 병합 과정
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (Math.abs(arr[i]) <= Math.abs(arr[j])) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}