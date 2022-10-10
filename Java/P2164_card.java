import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//슈도코드
/*
카드 개수 : N, 카드 저장 자료구조 : myQeue
for(카드의 개수만큼 반복)
{
    큐에 카드 저장하기
}
while( 카드가 한장 남을 때까지 반복)
{
    맨 위 카드를 한장 버림   => poll -> 추출은 front에서 이루어짐
    맨 위 카드를 바닥으로 보냄 +> 추출 후 추가하면 front에서 나와서 rear로 들어감
}
마지막 카드 추출
 */
public class P2164_card {
    public static void main(String[] args){
        Scanner sc = new Scanner((System.in));
        int N = sc.nextInt(); //카드 개수 입력
        Queue<Integer> myQeue = new LinkedList<>();
        for (int i =0 ; i <N; i++){
            myQeue.add(i); // 카드 쌓기? 카드 넣기?
        }
        while(myQeue.size() > 1){
            myQeue.poll();  //카드 추출하기
            myQeue.add(myQeue.poll());  //추출한 카드를 추가
        }
        System.out.println(myQeue.poll());  //큐에서 마지막 카드를 추출하연 추출한 카드를 출력
    }
}
