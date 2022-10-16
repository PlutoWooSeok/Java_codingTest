import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//슈돝코드
/*
n(소인수 표현) result(결과값)
for( 2 ~ n의 제곱근){
    if( 햔재 값이 소인수라면){
        결과값 = 결과값 - 결과값/현재값
        n에서 현재 소인수 내역을 제거하기(27*11*13 -> 현재 소인수가 2일 때 11*13 으로 변경)
    }
}
if( n > 1) {        //n이 마지막 소인수일 때
    결과값 = 결과값 - 결과값/n
}
결과값 출력
 */
public class P11689_오일러피함수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = n;
        for( long p =2; p<= Math.sqrt(n); p++){     //제곱근까지만 진행하기
            if ( n % p ==0){                        //p가 소수인지 확인
                result = result - result/p;         //결과값 업데이트하기
                while( n % p ==0){                  //2^7 *11이라면 2^7을 없애고 11만 남김
                    n/=p;
                }
            }
        }
        if(n>1)                                     //아직 소인수 구성이 남아 있을 때
            //반복문에서 제곱근까지만 탐색했으므로 1개의 소인수가 누락죄는 케이스
            result = result - result/n;
        System.out.println(result);
    }
}
/*
n= 45, result = 45 인 경우

P(현재 수) = 2 => n(45) % P(2) != 0       //소인수가 아님
P(현재 수) = 3 => n(45) % P(3) == 0       //소인수이므로 ㄱ밧 업데이트
    ==> result = 45 - 45/3 =30
    ==> n = 3^2 / 5 = 5
P(현재 수) = 4 => 현재 n(5)의 제곱근보다 4가 크므로 반복문 종료

반복문 종료 후 현재 n이 1보다 크면 n이 마지막 소인수 이므로
===> result(30) = 30 - (30/5) = 24
 */