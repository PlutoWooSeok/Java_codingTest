import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

//슈도 코드
/*
수의 개수 N(배열의 크기)
배열에 N개의 숫자 입력
배열 오름차순 정리
for( N만큼 반복)
{
    변수 초기화 하기 (찾고자 하는 값K, 포인터i,j)
    while(i<j)
    {
        if(A[i] + A[j] == 찾고자 하는 값){
            두 포인터 i, j 가 k가 아닐 때  결과값에 반영 및 while 문 종료
            두 포인터 i, j 가 k가 맞을 때 포인터 변경 및 계속 수행하기
         }else if( K > M0 포인터 1증가
         else 포인터 j 증가
 */
public class P1253_좋은수 {
    public static void main(String[] args)throws IOException{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int count = 0;
        long A[] = new long[N];
        StringTokenizer st =new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);
        for (int k =0; k < N; k++){
            long find = A[k];
            int i =0;
            int j = N-1;
            // 투 포인트 알고리즘
            while( i < j){
                if (A[i] + A[j] ==find){
                    //find는 서로 다른 두수의 합이어야 체크함
                    if( i != k && j!=k){
                        count++;
                        break;
                    } else if (i ==k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (A[i] + A[j] < find) {
                    i++;
                }else {
                    j--;
                }

            }
        }
        System.out.println(count);
        bf.close();
    }
}
