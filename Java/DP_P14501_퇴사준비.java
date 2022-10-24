import java.util.Scanner;

// 슈도 코드 //
/*
D( 점화식 배열 -> i ~ 퇴사일까지 벌 수 있는 최대 수입을 저장하기)
T(상담에 필요한 일 수 저장 배열)
P(상담을 완료했을 때 받는 수입 저장 배열)
for( N만큼 반복하기){
    T와 P배열 입력빋기
}
for( i -> N ~ 1까지 반복하기){
    if( i + T[i] > N+1){
        D[i] = i + 1일 ~ 퇴사일에 벌 수 있는 최대 수입
    }else{
        D[i] = MAX( i + 1일 ~ 퇴사일에 벌 수 있는 최대 수입과 i번째 상담 비용 + i번째 상담이 끝난 날부터 퇴사일까지의 최대 수입)
    }
}
D[1];               //1일부터 퇴사일까지 벌 수 있는 최대 수입 출력하기
 */
public class DP_P14501_퇴사준비  {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int []D = new int[N+2];
        int []T = new int[N+1];
        int []P = new int[N+1];
        for( int i = 1; i<=N ; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        for( int i = N; i>0; i--){
            if(i + T[i] > N+1){
                D[i] = D[i+1];
            }
            else {
                D[i] = Math.max(D[i+1], P[i] + D[i + T[i]]);
            }
        }
        System.out.println(D[1]);
    }
}
