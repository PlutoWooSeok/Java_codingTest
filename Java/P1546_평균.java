import java.util.Arrays;
import java.util.Scanner;

public class P1546_평균 {
    //슈도코드
    /*
    변수 N에 과목 수 저장
    크기가 N인 정수형 배열 A[] 선언
    for ( 배열의 크기N만큼 반복)
        {
                각각의 인데스에 과목의 점수를 각각 입력
        }
    배열을 오름차순 정렬
    정수형 변수 M에 최댓갓 저장
    int sum = 0 으로 초기화
    for ( 배열의 크기만큼 반복){
            sum += A[i]
        }

     sum * 100 / N/M
     */

    public  static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++){
            /*
            int score = sc.nextInt();
            A[i] = score;
             */
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = A[N-1];
        int sum =0;
        for (int i = 0; i < N; i++){
            sum += A[i];
        }
        //한 과목과 관련된 수식을 총합한 후 관련된 수식으로 변환해 로직이 간단해짐
        System.out.println( sum * 100 / N / M);
    }
}
