import java.util.Arrays;
import java.util.Scanner;

//슈도코드
/*
N(사람 수)
P배열 선언(인출소요시간)
S배열선언( 합 배열)
for(N만큼 반복)
{
    P배열에 인출소요시간 입력 저장
}
오름차순 정렬
합배열을 이용하여 값을 저장
합배열 마지막 인덱스 출력
 */
public class P11399_ATM {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //사람수 입력
        int [] P = new int[N]; //인출소요 사간 배열 생성
        int S[] = new int[N]; //합 배열 생성
        for(int i = 0; i< N; i++){
            P[i]=sc.nextInt(); //p배열에 인출 소요시간 입력
        }
        Arrays.sort(P);
        int sum =0;
        for(int i= 0; i<N; i++){
            sum+= P[i];
            S[i] =sum;
        }

        System.out.println(S[N-1]);
    }
}
