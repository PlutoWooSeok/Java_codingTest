//슈도코드
/*
answer(정답변수)
들어온 데이터를 "-" 기준으로 split()tngodgkrl
for( 나눠진 데이터 개수 만큼 반복하기){
    결과값 =  mySum() 함수 실핼하기
    if(가장 앞 데이터일 때 ) answer에 결과값 더하기
    else answer에 결과값 빼기
}
answer 출력

///////mySum() 구현하기//////
mySum(){
    현재 들어온 String 값을 "+"기호 기준으로 Split() 하기
    for( 현재 나눠진 데이터 개수만큼 반복하기){
        String 값을 Integer형으로 변환하여 리턴값에 더하기
    }
    전체합 리턴하기
}

 */
import java.util.*;
public class P1541_잃어버린괄호 {
    static int answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String ex = sc.nextLine();              //식을 받아오기 때문에 문자열형으로 식을 저장한다.
        String[] st = ex.split("-");        //받아온 식을 "-" 기호를 기준으로 배열에 저장한다.
        for( int i =0; i< st.length; i++){
            int temp = mySum(st[i]);
            if( i ==0)
                answer =answer + temp;          //가장 앞에 있는 값만 더함
            else
                answer = answer - temp;         //뒷 부분은 더한 값을 뺌
        }
        System.out.println(answer);
    }

    static int mySum(String s) {                //나뉜 그룹의 더하기 연산 수행 함수
        int sum =0;
        String temp[] = s.split("[+]");     //"+" 기호를 기준으로 나눠 배열에 저장
        for (int i =0; i< temp.length;i++){
            sum += Integer.parseInt(temp[i]);       //나눈 수들을 정수형으로 변환해 sum에 저장
        }
        return sum;
    }
}
