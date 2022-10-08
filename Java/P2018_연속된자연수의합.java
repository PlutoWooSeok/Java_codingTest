//슈도코드
/*
    N 변수 저장
    사용 변수 초기화(count = 1, start_index = 1, end_index = 1, sum = 1)
    while( end_index != N){
        if( sum == N) count 증가, end_index 증가, sum값 변경
        else if( sum > N) sum값 변경, start_index값 증가
        else if( sum < N) end_index증가, sum값 변경
    }
    count 출력
 */

import java.util.Scanner;

public class P2018_연속된자연수의합 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count =1;
        int start_i = 1;
        int end_i = 1;
        int sum = 1;

        while(end_i != N){
            if( sum == N ){
                count++;
                end_i++;
                sum = sum + end_i;
            } else if (sum > N) {
                sum = sum - start_i;
                start_i++;
            }else {
                end_i++;
                sum = sum + end_i;
            }
        }
        System.out.println(count);

    }
}
