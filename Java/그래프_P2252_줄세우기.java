////////////////////////슈도 코드//////////////////////
/*
N(학생 수) M( 에지 수 )
A[]( 그래프 저장 인접 리스트)
indegree ( 진입 차수 배열 )
for( N만큼 반복) {
    A 인접 리스트에 각 ArrayList 초기화
}
진입 차수 배열 초기화
for( N만큼 반복)
{
    인접 리스트 데이터 저장
    진입 차수 배열 초기 데이터 저장
}
//위상 정렬 수행하기
큐 생성하기
for( N만큼 반복)
{
    if(진입차수 배열의 값이 0인 학생이 있으면){
        큐에 저장
    }
}

while( 큐가 빌 때까지 ){
    현재 노드 = 큐에서 데이터 poll
    현재 노드값 출력하기
    for( 현재 노드에서 갈 수 있는 노드의 개수 ){
        타깃 노드 진입 차수 배열--
        if( 타깃 노드의 진입 차수가 0이면 ){
            큐에 타깃 노드 추가
        }
    }
}
 */
////////////////////////////////////////////////////////////
import java.util.*;

public class 그래프_P2252_줄세우기 {
    public static int N,M;
    public static ArrayList<ArrayList<Integer>>  A;
    public static  int[] inDegree;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();            //사람 수
        M = sc.nextInt();           //에지 수
        A = new ArrayList<>();         //그래프 데이터 인접 리스트
        for(int i = 0; i <=N ; i++ ){
            A.add(new ArrayList<>());
        }
        inDegree = new int[N+1];       //집입 차수 배열 선언
        for( int i =0; i<M; i++){
            int tall = sc.nextInt();        //비교 시 키가 큰 친구
            int small = sc.nextInt();       //비교 시 키가 작은 친구
            A.get(tall).add(small);
            inDegree[small]++;
        }

        //::: 위상 정렬 수행하기:://
        Queue<Integer> queue = new LinkedList<>();
        for( int i = 1;i<=N; i++){
            if( inDegree[i] == 0){
                queue.offer(i);         //add와 offer는 같은 기능을 하지만 add는 큐가 다 찰 경우 예외를, offer는 false를 리턴한다.
            }
        }
        while( !queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + " ");
            for( int next : A.get(now)){
                inDegree[next]--;
                if( inDegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
    }

}


