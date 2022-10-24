import java.util.Scanner;

//슈도 코드//
/*
D[N] (길이가 2 X N인 직사각형이 2 X 1,  1 X 2 타일을 붙일 수 있는 경우의 수 )
D[1] = 1;
D[2] = 2
for( i -> 3 ~ N ){
    D[i] = D[i-1] + D[i-2]
    나온 결과를 10007 나머지 연산 수행하기
}
D[N]값 출력하기
 */
public class DP_P11726_2N타일 {
    static long mod = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long D[] = new long[1001];
        D[1] =1;
        D[2] = 2;
        for( int i = 3; i <= N; i++){
            D[i]=D[i-1]+D[i-2];
        }
        System.out.println(D[N]);
    }
}
