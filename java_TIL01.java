import java.util.Scanner;

public class java_TIL01 {
    public static void main(String[] args){
        //화면에 글자 출력하기
        // 예제 2-1
//        System.out.println("hello world");
//        System.out.print("hello");
//        System.out.println("world");

//        예제2-2
//        System.out.print("3+5=");
//        System.out.println(3+5);

        //계산값 출력
        //예제2-3
//        System.out.println("5+3");
//        System.out.println("5-3");
//        System.out.println("5*3");
//        System.out.println("5/3");
        //변수의 선언과 저장
        //예제 2-4
//        int x=5;
//        System.out.println(x);
//
//        x=10;
//        System.out.println(x);
//
//        예제 2-5
//        int x1=10;
//        int y=5;
//
//        System.out.println(x+y);
//        System.out.println(x-y);
//        System.out.println(x*y);
//        System.out.println(x/y);
//
//        변수의 타입
//        int x=100;
//        double pi = 3.14;
//        char ch='a';
//        String str ="abc";
//
//        System.out.println(x);
//        System.out.println(pi);
//        System.out.println(ch);
//        System.out.println(str);

        //상수와 리터럴
        //EX)
//        final int Max_speed = 10;
//
//        final int MAX_VALUE;
//        MAX_VALUE =100;
        //MAX_VALUE =200;   //error,final(상수)에 저장된 값은 한번 저장이 되면 바꿀 수 없다.
        //리터럴(literal)은 원래 수학적으로 알고있는 상수, 즉 값을 말한다.

        //문자열 결합
        //예제 2-7
//        String name = "Ja"+"va";
//        String str = name+8.0;
//
//        System.out.println(name);
//        System.out.println(str);
//        System.out.println(7+" ");
//        System.out.println(" "+7);
//        System.out.println(7+"");
//        System.out.println(""+7);
//        System.out.println(" "+" ");
//        System.out.println(7+7+" ");
//        System.out.println(" "+7);

        //두 변수읙밧 바꾸기
        //예제 2-8
//        int x=1, y=5;
//        System.out.println("x="+x);
//        System.out.println("y="+y);
//
//        int temp =x;
//        x=y;
//        y=temp;
//        System.out.println("x="+x);
//        System.out.println("y="+y);

        //printf를 이영한 출력
        //에제 2-9
//        String  url = "www.codechobo.com";
//        float f1 =.10f;
//        float f2 =1e1f;
//        float f3 =3.14e3f;
//        double d =1.23456789;
//        System.out.printf("f1=%f, %e, %g%n", f1,f1,f1);
//        System.out.printf("f1=%f, %e, %g%n", f2,f2,f2);
//        System.out.printf("f1=%f, %e, %g%n", f3,f3,f3);
//        System.out.printf("d=%f%n",d);
//        System.out.printf("d=14.10%f%n",d);
//        System.out.printf("[12345678901234567890]%n");
//        System.out.printf("[%s]%n",url);    //문자열의 길이만큼 출력공간 확보
//        System.out.printf("[%20s]%n",url);  //최소20글자출력공간 확보(우측정렬)
//        System.out.printf("[%-20s]%n",url); //최소20글자출력공간 확보(좌측정렬)
//        System.out.printf("[%.8s]%n",url);  //왼쪽에서 8글자만 출력
        //실수형 값의 출력에 사용되는 지시자
        //%f, %e, %g
        //보통 %f를 사용 지수표현은 e, g는 간략히 표현시 사용
        //%s에 숫자를 추가하면 원하는 만큼의 출력 공간을 확보하거나이부만 출력가능

        //화면으로부터 입력받기
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("두자리의 정수를 하나 입력하시오. >>>");
//        String input = scanner.nextLine();
//        int num = Integer.parseInt(input);
//
//        System.out.println("입력 내용 :"+input);
//        System.out.printf("num=%d%n",num);
//
        //정수형(부호 존재)의 오버플로우
        //overflow 란 연산과정에서 해당 타입이 표현할 수 있는 값의 범위를 넘어서는 것을 말한다.
        //예제2-11
//        short sMin = -32768, sMax=32767;
//        char cMin = 0;
//        char cMax = 65535;
//
//        System.out.println("sMin = "+sMin);
//        System.out.println("sMin-1="+(short)(sMin));
//        System.out.println("sMax = "+sMax);
//        System.out.println("sMax+1="+(short)(sMax));
//        System.out.println("CMin "+cMin);
//        System.out.println("cMin-1="+(int)(cMin));
//        System.out.println("CMax "+cMax);
//        System.out.println("cMax+1="+(int)(cMax));

        //타입 간의 변환(형 변환)
        //1. 숫자를 문자로 변환 - 숫자에 '0'을 더한다.
        //(char)(3 + '0')  //추가적으로 (char)를 붙여애 형변환이 된다.

        //2. 문자를 숫자로 변환 - 문자에서 '0'을 뺀다.
        //'3'-'0'

        //3. 숫자를 문자열로 변환- 숫자에 빈 문자열("")을 더한다.
        //3+""

        //4. 문자열을 숫자로 변환 - Integer.parseInt() 또는 Double.parseDouble()을 사용한다,
        //Integer.parseInt("3")
        //Double.parseDouble("3.14")

        //5. 문자열을 문자로 변환 - charAt(0)
        //"3".charAt(0)

        //6. 문자를 문자열로 변환 - 빈 문자열("")을 더한다.
        //'3' + ""

        //예제2-12
        String str = "3";

        System.out.println(str.charAt(0) - '0');
        System.out.println('3' - '0' +1);
        System.out.println(Integer.parseInt("3")+1);
        System.out.println("3"+1);
        System.out.println((char) (3+ '0'));
    }

}
