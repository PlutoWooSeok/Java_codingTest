import java.util.Scanner;

//슈도코드
/*
N(배열의 크기), K(구하고자 하는 index)
start( 시작 인덱스 = 1)
end( 종료 인덱스 = K )
while( 시작 인덱스 <= 종료 인덱스 ){  //이진 탐색 수행하기
    mid_index(중간 인덱스)
    cnt( 중앙값 보다 작은 수)
    //중앙값 보다 작은 수는 몇개인지를 계산하기
    for( N의 개수만큼 반복)
    {
        cnt에 중앙 인덱스를 i로 나눈 값과  N중 작은 값을 더함
    }
    if( cnt < K : 현재 중앙값보다 작은 수의 개수가 K보다 작음)
        시작 인덱스 = 중앙 인덱스 + 1
    else (현재 중앙값보다 작은 수의 개수가 K보다 크거나 같음
        종료 인덱스 = 중앙 인덱스 - 1
        정답 변수에 중앙값 저장
}
정답 출
 */



public class P1300_k번째수 {
    public static void main( String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc .nextInt();      //배열 크기
        int K = sc.nextInt();       //구하고자 하는 인덱스
        int start = 1;
        int end = K;
        int result = 0;

        while( start <= end){
            int mid_index = (start + end)/2;
            int count = 0;          // 중앙값보다 작은 수를 세는 변수
            for( int i = 1; i <= N ;i++ ){
                count = count + Math.min(mid_index/i,N);            //중앙값보다 작거나 같은 개수를 계산한다.
            }
            if(count < K){
                start = mid_index + 1;
            }else {
                end = mid_index -1;
                result = mid_index;
            }
        }
        System.out.println(result);
    }

}
