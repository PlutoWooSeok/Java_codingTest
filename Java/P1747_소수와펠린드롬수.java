//슈도코드
/*
N( 조건을 만족하는 수)
A 배열
소수구하기
무한반복
구해진 소수를 펠린드롬인지 확인
있으면 빠져나오기

 */

import java.util.Scanner;

public class P1747_소수와펠린드롬수 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int []A = new int[10000001];
        for( int i =2; i < A.length; i++){
            A[i] = i;
        }
        for( int i = 2; i <= Math.sqrt(A.length); i++){
            if( A[i] == 0)
                continue;
            for( int j = i+i ; j < A.length ; j = j+i){
                A[j] = 0;
            }
        }
        int i =  N;
        while(true){
            if(A[i] != 0){
                int result = A[i];
                if( isPalidrome(result)){
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }


    }

    private static boolean isPalidrome(int target) {            //펠리드롬 수 판별 함수
        char [] temp = String.valueOf(target).toCharArray();            //다른 자료형을 String으로 변환 후 charArray 로 변화하여 저장
        int s = 0;                              //시작점
        int e =temp.length-1;               //종료점
        while(s < e){                   //시작점이 종료점보다 작을때까지만 반복
            if( temp[s] != temp[e])
                return false;
            s++;
            e--;
        }
        return true;
    }
}
