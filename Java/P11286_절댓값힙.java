import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//슈도코드
/*
N :질의 요청 개수 => 연산 횟수
우선순위 큐 선언
    - 절댓값 기준으로 정렬되도록 설정
    -단, 절댓값이 같으면 음수 우선 정렬하기
for( N만큼 반복)
{
    요청이 0일때 : 큐가 비어 있을때 0, 비어 있지 않으면 큐의 front 값 출력하기
    요청이 1일때 : 새로운 데이터를 우선순위 큐에 더하기
}
 */
public class P11286_절댓값힙 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1, o2) ->{
            int first_abs = Math.abs((o1));
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs)
                return o1 > 02? 1:-1;            //절댓값의 같은 경우 음수 우선
            else
                return first_abs - second_abs;  //절댓값 작은 데이터 우선
        });
        for (int i =0; i<N;i++){
            int request = Integer.parseInt(bf.readLine());
            if(request == 0){
                if(MyQueue.isEmpty()){
                    System.out.println("0");
                }else {
                    System.out.println(MyQueue.poll());
                }
            }else{
                MyQueue.add(request);
            }
        }
    }
}
