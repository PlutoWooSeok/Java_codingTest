import java.util.Scanner;

//슈도코드
/*
N( 레슨 수) M ( 블루레이 개수)
A[] (레슨 길이 배열)
for( N 만큼 반복)
{
    A배열 저장하기
    //레슨의 길이 는 9 ~ 45
    시작 인덱스 (A 배열 중 최댓값)
    종료 인덱스 (A 배열의 총합)
}

start(시작 인덱스).
end(종료 인덱스)
while( start <= end) {
    mid_index( 중간 인덱스 )
    sum( 레슨의 합 , 즉 인덱스 값의 총합 )
    count ( 현재까지 사용한 블루레이 수)
    for( N만큼 반복하기)
    {
        if( sum + 현재 레슨 시간 > 중간 인덱스)
            count++;
            sum =0;

            //현재 블루레이에 저장할 수 없어 새로운 블루레이로 교체
            sum에 현재 레슨 시간값 더하기
    }
    sum이 0이 아니면 마지막 블루레이가 필요하므로 count 값 올리기
    if( count > M : 중간 인덱스 값으로 모든 레슨 저장 불가능)
        start = mid_index+1;
    else (중간 인덱스 값으로 모든 레슨 저장 가능)
        종료 인덱스 중앙 인덱스 -1
}
시작 인덱스 출력하기
 */


////
/**
 * (A[i] + sum) /2 = K(중앙값)의 값이 블루레이의 개수로 저장이 가능하다면
 * K-1을 하여
 * (A[i] + K-1) /2 을 통해 앞선 과정을 반복한다.
 * 만약 주어진 블루레이의 개수로 레슨을 저장할 수 없다면 K(중앙값)+1 로 수정하여 다시 탐색을 진행한다.
 * 이진탐색을 진행하다가 시작 인덱스 > 종료 인덱스 조건이 만족할 때 이진 탐색을 종료하면
 * 문제의 조건을 만족하는 블루레이의 크기이다
 * **/
////

public class P2343_블루레이 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();       //레슨의 개수
        int M = sc.nextInt();       //블루레이 개수
        int []A = new int[N];       //레슨들의 길이 저장할 배열
        int start=0 , end =0;
        for ( int i = 0; i < N ; i++){
            A[i] = sc.nextInt();        //레슨 길이 각각의 인덱스에 저장
            if(start < A[i])                //레슨 최댓값을 시작 인덱스로 저장
                start =A[i];
            end += A[i];                    //모든 레슨의 총합을 종료 인덱스로 저장하기
        }
        while( start <= end){
            int mid_index = ( start+ end)/2;        //중앙값 인덱스
            int sum =0;                         //레슨의 합
            int count = 0;                      //블루레이 사용 개수
            for (int i=0; i < N; i++){
                if(sum+A[i] > mid_index){
                    count++;
                    sum =0;
                }
                sum += A[i];
            }
            if( sum != 0){          //탐색 후 sum이 0이 아니면 블루레이가 추가로 더 필요하다.
                count++;
            }
            if( count > M){
                start = mid_index+1;
            }else
                end = mid_index -1;
            System.out.println(count);
        }
        System.out.println(start);

    }
}
