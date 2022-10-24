// 슈도 코드 //
/*
N(a의 개수) , M(z의 개수), K(순번)
// 조합 테이블 미리 만들기
for( i -> 0~200 ){                                  //N + M 의 최대가 200dlamfh
    for( j -> 0 ~ i){
        D[i][j] = D[i-1][j] + D[i-1][j-1]
        D[i][j] 값이 K의 범위를 벗어났을 떄 K의 범위의 최댓값으로 D[i][j] 저장하기
    }
}
if( 불가능한 K이면) -1 출력하기
while( 모든 문자를 모두 사용할 때까지){
    if( a 문자를 선택했을 때 남은 문자들로 만들 수 있는 모든 경우의 수 >+ K){
        a 출력하기 , a 문자 개수 감소
    }
    else{
        z 출력하기, z 문자 감소, K의 값을 계산된 모든 경우의 수를 뺀 값으로 저장하기
    }
}
 */
import java.util.*;

public class 조합_P1256_사전찾기 {
    static int N,M,K;
    static int D[][];

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        D = new int[202][202];

        // 초기 테이블 초기화
        for( int i = 0; i <= 200 ; i++){
            for( int j = 0 ; j <= i ; j++){
                if( j == 0 || j== i){                   //각 행의 0번째 열 과 각 행과 열의 번호가 같을 경우 1로 초기화
                    D[i][j] = 1;
                }
                else{
                    D[i][j] = D[i-1][j] + D[i-1][j-1];              //  k의 범위가 넘어가면 범위의 최댓삾 저장하기
                    if( D[i][j] > 1000000000){
                        D[i][j] = 1000000001;
                    }
                }
            }
        }
        if( D[N+M][M] < K){                                         //주어진 자릿수로 만들 수 없는 K 번째 수이면
            System.out.println("-1");
        }else{
            while (!(N==0 && M==0)){
                //a를 선택했을 때 남은 문자로 만들 수 있는 모든 경우의 수가 K보다 크면
                if( D[N-1+M][M] >= K){
                    System.out.print("a");
                    N--;
                }else{                                      //모든 경우의 수가 K보다 작으면
                    System.out.print("z");
                    K = K -D[N-1+M][M];                     // K 값 업데이
                    M--;
                }
            }
        }
    }
}
