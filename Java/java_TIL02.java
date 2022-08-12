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
        int i=5, j=0;

        j = i++;
        System.out.println("j=i++; 실행 후 , i="+ i +", j="+j);

        i=5;
        j=0;

        j = ++i;
        System.out.println("j=++i; 실행 후 , i="+ i +", j="+j);
    }
}
