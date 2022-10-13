import java.util.Scanner;

//슈도토드
/*
N(자릿수)
DFS 실핼하기 (숫자 2,3,5,7로 시작하기)
//DFS 구현하기
DFS{
    if(자릿수 == N){
        if(소수)
            수 출력하기
            탐색 종료
    }

    for( 1~9 반복하기) {
        if( 뒤에 붙는 수가 홀수이면서 소수일때)
            DFS 실행 : 자릿수 +1, 수 *10 + 뒤에 붙는 수
    }
}

//소수 구하기 함수
for( '2 ~ 현재 수 / 2' 반복하기 ){
    if(나머지가 0이면)
        return(소수가 아님)
}
return (소수이다)

 */
public class P2023_신기한소수찾기 {
    public static int N;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        //일의 자리에서 소수는 2,3,5,7이므로 4개의 수에서만 시작
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int s, int m) {
        if( m == N){            //m(자리수) 가 N과 같다면
            if(isPrime(s)){         //숫자 s가 소수라면
                System.out.println(s);
            }
            return;
        }
        for( int i =1; i <10; i++){
            if( i%2 == 0){
                continue;
            }
            if(isPrime( s * 10 +1)){
                DFS(s * 10+i, m+1);
            }
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= num/2; i++)
            if( num % i == 0)
                return false;
        return true;
    }
}
