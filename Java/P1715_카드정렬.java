import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715_카드정렬 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int card1 =0;
        int card2 =0;
        int sum =0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for( int i = 0; i< N; i++){
            int card = sc.nextInt();
            priorityQueue.add(card);
        }
        while( priorityQueue.size() != 1){
            card1 = priorityQueue.remove();
            card2 = priorityQueue.remove();
            sum += card1 + card2;
            priorityQueue.add(card1 + card2);
        }
        System.out.println(sum);
    }
}
