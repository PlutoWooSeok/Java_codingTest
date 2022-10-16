import java.util.Scanner;

public class java_TIL02 {
    public static void main(String[] args){
        //연산자
        //연산자의 종류에는 산술연산자, 비교연산자, 논리연산자, 대입연산자, 기타(형변환 연산자, 삼항 연산자, instanceof 연산자)가 있다.

        //1. 산술 > 비교 > 논리 > 대입 순으로 우선순위가 정해진다.
        //2. 단항 > 이항 > 삼항 순으로 우선순위가 정해진다.
        //3. 단항 연산자와 대입 연산자를 제외한 모든 연산의 진행방향은 왼쪽에서 오른쪽이다.
        //예제 3-1
//        int x,y;
//
//        x=y=3;  //y에 3이 저장된 후, x에 3의 값을 가진 y가 저장된다.
//        System.out.println("x="+x);
//        System.out.println("y="+y);

        //증감 연산자 ++, --
        //예제3-2
//        int i=5, j=0;
//
//        j = i++;
//        System.out.println("j=i++; 실행 후 , i="+ i +", j="+j);
//
//        i=5;
//        j=0;
//
//        j = ++i;
//        System.out.println("j=++i; 실행 후 , i="+ i +", j="+j);

        //부호 연산자
        //3-4

//        int i = -10;
//        i = +i;
//        System.out.println(i);
//
//        i =-10;
//        i = -i;
//        System.out.println(i);

        //형변환(casting) 연산자
        //(타입)피연산자
        //3-5

//        double d = 85.4;
//        int score = (int) d;
//        System.out.println("score = "+score);
//        System.out.println("d = "+d);
        //incompatible type:possible lossy conversion from type to type
        //이는 큰타입에서 작은 타입으로의 형변환시 값 손실이 발생할 수 있어 발생하는 오류이다.
        //만약  자동 형변환을 사용할 경우 형변환이 프로그래머의 실수가 아닌 의도적인 것으로 간주하여  컴파일러는 에러를 발생시키지 않는다.

        //사칙연산자
        //예제3-6
//        int a = 10;
//        int b = 4;
//        System.out.printf("%d + %d = %d%n", a, b, a+b);
//        System.out.printf("%d - %d = %d%n", a, b, a-b);
//        System.out.printf("%d * %d = %d%n", a, b, a*b);
//        System.out.printf("%d / %d = %d%n", a, b, a/b);
//        System.out.printf("%d / %f = %f%n", a, (float)b, a/(float)b);

        //Math.round()로 반올림하기
        //예제 3-11
//        double pi = 3.141592;
//        double shortPi = Math.round(pi * 1000) / 1000.0;
//        System.out.println( shortPi);

        //비교 연산자
        //대소비교 연산자 <, >, <=, >=
        //등가비교 연산 == : 두 값이 같으면 True 다르면 False / != : 두 값이 다르면 True 같으면 False

        //문자열의 비교
        //예제3-14
//        String str1 = "abc";
//        String str2 = new String("abc"); //String 클래스의 객체를 생성
//
//        System.out.printf("\"abc\"==\"abc\" ? %b%n", "abc" =="abc");
//        System.out.printf(" str1==\"abc\" ? %b%n", str1 =="abc");
//        System.out.printf(" str2==\"abc\" ? %b%n", str2 =="abc");
//        System.out.printf("str1.equals(\"abc\") ? %b%n", str1.equals("abc"));
//        System.out.printf("str2.equals(\"abc\") ? %b%n", str2.equals("abc"));
//        System.out.printf("str2.equals(\"ABC\") ? %b%n", str2.equals("ABC"));
//        System.out.printf("str2.equalsIgnoreCase(\"ABC\") ? %b%n", str2.equalsIgnoreCase("ABC"));

        /*
        str2와 abc"의 내용이 같아도 '=='로 비교하면 false를 결과로 얻는다. 내용은 같지만서로 다른 객체이기 때문이다
        그러나 equals()는 객체가 달라도 내용이 같으면 True를 반환한다. 따라서 문자열을 비교할 경우 항상 equals()를 사용해야한다.
        만일 대소문자 구분 없이 비교를 원할 경우 equals()가 아닌 equalsIgnoreCase(0를 사용하면 된다
         */

        //논리 연산자 &&, ||
        //예제3-15
//        Scanner scan = new Scanner(System.in);
//        char ch = ' ';
//
//        System.out.printf("문자를 하나 입력하시오>");
//
//        String input = scan.nextLine();
//        ch = input.charAt(0);
//
//        if('0' <= ch && ch <= '9'){
//            System.out.printf("입력하신 문자는 숫자입니다.%n");
//        }
//
//        if (('a' <= ch && ch <= 'z') || ('A' <= ch&& ch <='Z')){
//            System.out.printf("입력하신 문자는 영문자입니다.%n");
//        }


        //논리 부정 연산자
        //예제 3-16
//        boolean b = true;
//        char ch = 'C';
//
//        System.out.printf("b=%b%n", b);
//        System.out.printf("!b=%b%n", !b);
//        System.out.printf("!!b=%b%n", !!b);
//        System.out.printf("!!!b=%b%n", !!!b);
//        System.out.println();
//
//        System.out.printf("ch = %c%n", ch);
//        System.out.printf("ch < 'a' || ch < 'z'=%b%n", ch < 'a' || ch >'z');
//        System.out.printf("!('a' <= ch && ch <= 'z')=%b%n", !('a' <= ch && ch <= 'z'));
//        System.out.printf("'a' <= ch && ch <= 'z'=%b%n", 'a' <= ch && ch <= 'z');

        //조건 연산자 == 삼항 연산자
        //조건식 ? 식1 : 식2
        //ex) result = (x>y) ? x:y; //괄호 생략 가능

        //예제3-17
//        int x,y,z;
//        int absX, absY, absZ;
//        char signX,signY, signZ;
//
//        x = 10;
//        y = -5;
//        z = 0;
//
//        absX = x >= 0? x : -x;  // x의 값이 음수이면, 양수로 바꾼다.
//        absY = x >= 0? y : -y;
//        absZ = x >= 0? z : -z;
//        signX = x >0 ? '+' : ( x==0? ' ': '-'); //조건 연산자를 중첩 사용
//        signY = y >0 ? '+' : ( y==0? ' ': '-');
//        signZ = z >0 ? '+' : ( z==0? ' ': '-');
//
//        System.out.printf("x=%c%d%n", signX, absX);
//        System.out.printf("y=%c%d%n", signY, absY);
//        System.out.printf("z=%c%d%n", signZ, absZ);
    }
}
