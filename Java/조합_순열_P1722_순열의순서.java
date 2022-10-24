import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 슈도 코드 //
/*
F(각 자리별로 만들 수 있는 경우의 수 저장하기 -> 팩토리얼 형태)
S( 순열을 담는 배열 ), visited(숫자 사용 유무 저장 배열) N(순열의 길이)
Q( 문제의 종류 -> 1이면 순열 출력하기, 2이면 순서 출력하기)
if( Q ==1 ){
    K(몇 번째 순열을 출력할지 입력받기) -> 길이가 N인 순열의 K번째 순서의 순열 출력하기
    for( i -> N만큼 반복하기){
        cnt = 1
        for( j -> N만큼 반복하기){
            이미 사용한 숫자는 계산하지 않음
            if( 현재 순서가 < 해당 자리 순열 수 * cnt -1){
                현재 순서 = 현재 순서 - 해당 자리 순열 수 * cnt -1
                현재 자리에 j값 저장하기, 숫자 j를 사용 숫자로 체크하기
                반복문 종료
            }
            cnt++;
        }
    }
    배열 출력하기
}
else{
    K(순열의 순서 저장 변수)
    S(순열 배열 저장)
    for( i -> N만큼 반복하기){
        for( j -> S[i]의 수 만큼 반복하기){
            if( visited[j] == false)
                cnt++;
        }
        K = K + cnt * 현재 자릿수에서 만들 수 있는 경우의 수
        S[i]번째 숫자를 사용 숫자로 변경하기
    }
    K 출력하기
}
 */
public class 조합_순열_P1722_순열의순서 {
    public static void main(String[] args) throws IOException{
        int N,Q;
        long F[] = new long[21];
        int S[] = new int[21];
        boolean visited[]  = new boolean[21];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Q =  Integer.parseInt(st.nextToken());
        F[0] = 1;
        for( int i = 1;  i<=N; i++){
            F[i] = F[i-1]*i;
        }
        if( Q == 1 ){
            long K = Long.parseLong(st.nextToken());
            for ( int i = 1;i<=N; i++){
                for( int j = 1, cnt =1; j<=N;j++ ){
                    if( visited[j]){
                        continue;
                    }
                    if(  K <=cnt *F[N-i]){
                         K -= ((cnt -1) * F[N-i]);
                         S[i] = j;
                         visited[j] = true;
                         break;
                    }
                    cnt++;
                }
            }
            for( int i = 1; i<=N; i++){
                System.out.print(S[i] + " ");
            }
        }
        else {
            long K =1;
            for (int i = 1 ; i<=N; i++){
                S[i] = Integer.parseInt(st.nextToken());
                long  cnt = 0;
                for( int j = 1; j <S[i]; j++){
                    if(visited[j] == false){
                        cnt++;
                    }
                }
                K += cnt * F[N-i];
                visited[S[i]] = true;
            }
            System.out.print(K);
        }
    }
}