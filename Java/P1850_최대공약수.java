//슈도코드
/*
a(1번째 수)
b(2번째 수)

결과값 = gcd(a,b)
결과값만큼 1을 반복해 출려하기       //풀력횟수가 많기 때문에 BufferedWriter를 사용한다.

//최대 공약수 gcd()함수구현하기
if( b가 0이면 )
    return a
else
    gcd(b, a%b)
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
public class P1850_최대공약수 {
    public static void main(String[]args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long a = sc.nextInt();
        long b = sc.nextInt();
        long result = gcd(a,b);


        while( result > 0 ){
            bw.write("1");
            result--;
        }
        bw.flush();
        bw.close();
    }

    private static long gcd(long a, long b) {
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }
}
