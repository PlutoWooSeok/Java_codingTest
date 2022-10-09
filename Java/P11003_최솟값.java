import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//슈도코드
/*
N(데이터 개수) L(최솟값을 구하는 범위)
Deque<Node> mydeque(데이터를 담을 덱 자료구조)
배열 선언하기

for(N만큼 반복)
{
now(현재 데이터 값)
    덱의 마지막 위치에서부터 now보다 큰 값은 덱에서 제거하기
    덱의 마지막 위치에서 now값 저장하기
    덱의 1번쨰 위치에서부터 L의 범위를 벗어난 값( now index -L <= index)을 덱에서 제거하기
    덱의 1번째 데이터 출력하기
}

덱에 저장할 노드 클래스 별도 생성하기
노드 클래스에는 index(자신의 위치), value(자신의 값)담기
 */
public class P11003_최솟값 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //출력을 버퍼에 넣고 한 번에 출려하기 위해 BufferWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());   //데이터의 개수
        int L = Integer.parseInt(st.nextToken());   //최솟값을 구하는 범위 => 윈도우 크기
        st = new StringTokenizer(bf.readLine());
        Deque<Node> mydeque = new LinkedList<>();
        for (int i = 0; i < N; i++){
            int now = Integer.parseInt(st.nextToken());
            //새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임

            while(!mydeque.isEmpty() && mydeque.getLast().value > now){
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(now, i));
            //범위에서 벗어난 값은 덱에서 제거
            if( mydeque.getFirst().index <= i - L){
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();

    }

    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
