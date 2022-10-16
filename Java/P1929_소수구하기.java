import java.util.Scanner;

//에라토스테네스 방법 사용
/*
M(시작 수) , N(종료 수)
A(소수 배열)
for(N마큼 반복){
    A배열 초기화     //각각의 인덱스 값으로 초기화 크기를 N+1로 설정
}

for( N의 제곱근까지 반복){
    소수가 아니면 넘어가기
    for( 소수의 배수 값을 N까지 반복하기){
        이 수가 소수가 아니라는 것을 표시하기
    }
}
for( M~N 까지 반복하기){
    A 배열에서 소수인 값 출력하기
}
 */
public class P1929_소수구하기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int []A = new int[N+1];
        for( int i = 2 ; i <= N ; i++ ){
            A[i] = i ;
        }
        for (int i = 2 ; i <= Math.sqrt(N); i++ ){
            if( A[i] ==0){
                continue;
            }
            for( int j = i+i ; j<=N ; j=j+i){
                A[j] =0;
            }
        }
        for (int i = M; i <=N; i++){
            if(A[i] != 0){
                System.out.println(A[(int) i]);
            }

        }
    }

}
