import java.util.Scanner;

// 슈도 코드 //
/*
D[N][H] (길이가 N일 때 높이 H로 끝나는 계단 수의 모든 경우의 수)
for( i -> 1 ~ N){
    D[1][i] = 1
    D[0][1] = 0
}
for( i -> 2 ~ N){
    D[i][0] = D[i-1][1]
    D[i][9] = D[i-1][8]
    for( j -> 1 ~ 8){
        //높이가 1 ~ 8이면  N-1에서 자신보다 한 단계 위 또는 한 단계 아래 높이에서 올 수 있음
        D[i][j] = (D[i-1][j-1] + D[i-1][j+1])
        나온 결과를 1000000000 나머지 연산 수행하기
    }
}
sum(결과값)
for( i -> 0 ~ 9){
    sum에 D[N][i]의 값을 모두 더하기
}

 */
public class DP_P10844_계단수 {
    static long mod = 1000000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        long D[][] =new long[N+1][11];
        for( int i =1; i<=9; i++){
            D[1][i] = 1;
        }
        for( int i =2; i<=N; i++){
            D[i][0] = D[i-1][1];
            D[i][9] = D[i-1][8];
            for (int j = 1; j<=8; j++){
                D[i][j] = (D[i-1][j-1] +D[i-1][j+1]) %mod;
            }
        }
        long sum = 0;
        for (int i =0; i< 10; i++){
            sum = (sum + D[N][i]) % mod;
        }
        System.out.println(sum);
    }
}

