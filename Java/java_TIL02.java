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
        double pi = 3.141592;
        double shortPi = Math.round(pi * 1000) / 1000.0;
        System.out.println( shortPi);
    }
}
