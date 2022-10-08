import java.util.Scanner;

//문제 : N개의 숫자가 공백 없이 써 있다. 이숫자를 모두 합해 출력하는 프로그램을 작성하시오.

//슈도코드 작성하기
/*
N값 입력받기
길이 N의 숫자를 입력받아 String형 변수 sNum에 저장하기
sNum을 다시 char[]형 변수 cNum에 변환하여 저장하기
int형 변수 sum 선언하기
for(cNum 길이만큼 반복하기)
{
    배열의 각 자릿값을 정수형으로 변환하며 sum에 더하여 누적하기
}
sum 출력하기
 */

public class P11720_숫자의합 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //입력값을 String형 변수 sNum애 저장후 char []형 변수로 변환하기
        String sNum = sc.next(); //공백없이 입력받기
        char[] cNum = sNum.toCharArray(); // char []형 변수로 변환
        int sum = 0; //sum을 0으로 초기화
        for (int i = 0; i < cNum.length; i++){
            sum += cNum[i] -'0'; //'0'을 해줌으로 cNum을 정수형으로 변환한다.
        }
        System.out.println(sum);

    }

}
