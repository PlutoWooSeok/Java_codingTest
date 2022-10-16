import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1744_수묶기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();            //수열 수의 개수
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        //양수는 내림차순정리
        //Collections.reverseOrder()은 내림차순 정렬
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        int one =0;         //1의 개수 카운트
        int zero =0;        //0의 개수 카운트
        for (int i = 0; i < N ; i++ ){
            int num = sc.nextInt(); //  수열 저장
            if (num > 1)
                plusQueue.add(num);
            else if (num == 1)
                one++;
            else if (num == 0)
                zero++;
            else if (num <0)
                minusQueue.add(num);
            }
        int sum = 0;

        //양수
        while( plusQueue.size()>1){
            int first = plusQueue.remove();
            int second = plusQueue.remove();
            sum = sum + first * second;
        }
        if( !plusQueue.isEmpty()){
            sum =  sum + plusQueue.remove();
        }

        //음수
        while( minusQueue.size()>1){
            int first = minusQueue.remove();
            int second = minusQueue.remove();
            sum = sum + first * second;
        }
        if( !minusQueue.isEmpty()){
            if( zero == 0) {
                sum =  sum + minusQueue.remove();
            }
        }

        sum = sum + one;
        System.out.println(sum);

    }

}



