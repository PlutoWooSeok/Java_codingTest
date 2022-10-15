import java.util.*;

//슈도코드
/*
N(노드 개수) , A( 그래프 데이터 인접 리스트) //ArrayList<Edge>[]형태로 선언하기
visited(방문 기록 저장 배ㅐ열) distance (거리 저장 배열)
for( N만큼 반복하기){
    A 읹접 리스트의 각 ArrayList 초기화하기
}
for( M의 개수만큼 반복하기){
    A의 인접리스트에 그래프 데이터 저장하기
}
visited 배열 초기화 하기
distance 배열 초기화 하기
BFS(임의의 점을 시작점으로) 실행하기
distance 배열에서 가장 큰 값을 지니고 있는 노드를 시작점으로 지정하기
visited 배열 초기화하기
distance 배열 초기화하기
BFS(새로운 시작점으로) 실행하기
distance 배열애서 가장 큰 수를 정답으로 출력하기
BFS{        //BFS구현하기
    큐 자료구조에 시작 노드 삽입하기(add 연산)
    visited 배열에 현재 노드 방문 기록하기
    while( 큐가 비어있을 때까지){
        큐에서 노드 데이터를 가져오기(poll 연산)
        가져온 노드 출력하기
        현쟈 노드의 연결 노드 중 방문하지 않은 노드로
        큐에 데이터 삽입( add 연산 )하고 visited 배열에 방문 기록하기
        그리고 현재 노드의 거리+ 에지의 가중치로 방문하지 않은 노드 거리 배열 업데이트하기
    }
}
Edge{       //에지 클래스 별도 구현하기
    e(목적지 노드), value(에지의 가중치)
}
 */
public class P1167_트리지름 {
    static int N;       //노드의 개수
    static ArrayList< Edge>[] A;
    static boolean []visited;
    static int [] distance;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new ArrayList[N+1];             //인데스의 처음을 1번으로 하기 위해 N+1로 크기를 잡음
        for ( int i = 1 ; i < N+1 ; i++){
            A[i]= new ArrayList< Edge>();
        }
        for( int i = 0; i < N; i++){       //A 인접 리스트에 그래프 데이터 저장하기
            int S = sc.nextInt();           //노드 번호 입력
            while(true){                    //무한반복
                int C = sc.nextInt();       //연결 노드 입력
                if( C == -1)
                    break;
                int D = sc.nextInt();       //연결된 노드와의 거리
                A[S].add(new Edge(C,D));    //인접 리스스 배열에 연결노드 넘버와 거리를 추가
            }
        }
        distance = new int[N+1];            //거리저장 배열 초기화
        visited = new boolean[N+1];         //방문기록 배열 초기화
        BFS(1);                             //1번 노드부터 시작
        int Max =1;                         //거리의 최대값

        for (int i = 2 ; i < N+1 ; i++)    //distance 배열애서 가장 큰 값으로 다시 시작점 설정
        {
            if (distance[Max] < distance[i]){
                Max =i;
            }
        }
        distance = new int[N+1];            //거리저장 배열 초기화
        visited = new boolean[N+1];         //방문기록 배열 초기화
        BFS(Max);                           //Max를 시작점으로 실행
        Arrays.sort(distance);              //거리 배열을 오름차순 정리
        System.out.println(distance[N+1]);      //최대 거리를 출력

    }

    private static void BFS(int index){
        Queue<Integer> queue = new LinkedList<Integer>();       //큐 자료구조 사용
        queue.add(index);                                       // 큐에 인데스 번호 추가
        visited[index] =  true;                                 //방문한 인덱스 true로 체크
        while (!queue.isEmpty()){                               //큐가 비어있을 때 까지 반복
            int now = queue.poll();                             //현재 노드 큐에서 뺌
            for( Edge i : A[now]){
                int e = i.e;
                int v = i.value;
                if( !visited[e]){
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now] + v;        //거리 배열 업데이트하기
                }
            }
        }
    }
}

class Edge{
    int e;
    int value;
    public Edge( int e, int value){
        this.e = e;
        this.value = value;
    }
}
