import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//슈도코드
/*
dx, dx(상하좌우를 탐색하기 위한 define 값 정의 변수)
A( data 저장 2차원 배열 선언)
N(행), M(열)
visited(방문 기록 저장 배열)
A 배열 초기화
visited 배열 초기화
for( N만큼 반복){
   for( M만큼 반복){
        A 배열에 데이터 저장
    }
}

BFS(0,0) 실행하기

///BFS 구현하기
BFS{
    큐 자료구조에 시작 노드 삽입하기(add)
    visited 배열에 현재 노드 방문 기록하기
    while( 큐가 비어있을 때까지)
    {
        큐에서 노드 데이터 가져오기(poll)
        for(상하좌우 탐색){
            if(유효한 좌표){
                if(이동할 수 있는 칸이면서 방문하지 않은 노드){
                    visited 배열에 방문 기록하기
                    A 배열에 depth를 현재 노드의 depth+1 로 업데이트하기
                    큐에 데이터 삽입하기(add 연산)
                }
            }

    }

}
 */
public class P2178_미로탐색 {
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int N;           //row
    static int M;           //colum
    static int [][] A;
    static boolean [][] visited ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //row
        M = Integer.parseInt(st.nextToken()); //colum
        A = new int[N][M];                      //N X M 배열 초기화
        visited = new boolean[N][M];            //방문 배열 초기화
        for (int i =0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();       //각 행에 들어갈 데이터 받아오기
            for(int j =0; j<M; j++){
                A[i][j] =  Integer.parseInt(line.substring(j,j+1)); //각 행에서 받아온 데이터를 하나씩 끊어 열에 저장
            }
        }

        BFS(0,0); // (0,0)=> 시작점에서 BFS실행
    }
    /////////////////////////////////////////////////////////////////
    /////////////////////////BFS 구현하기//////////////////////////////
    public static void BFS( int i, int j) {
        Queue<int[]>queue = new LinkedList<>(); //큐 자료구조
        queue.offer(new int[]{i,j});    /** offer 과 add 모두 큐에 데이터를 추가하는 매서드이지만 큐가 다 차있는 경우 add는 예외를 발생시키지만 offer는 false를 리턴값으로 받아온다. **/
        while( !queue.isEmpty()){   // 큐가 빌 때까지 반복
            int now[] = queue.poll();   //현재 노드에 있는 데이터를 꺼내기
            visited[i][j] = true;
            for( int k= 0; k<4;k++){
                //상하좌우 탐색
                int x = now[0] +dx[k];
                int y = now[1] +dy[k];

                //좌표 유효성 검사하기
                if( x>=0 && y >=0 && x< N && y < M){
                    if(A[x][y] !=0 && !visited[x][y]){          //갈 수 있는 칸 && 방문 검사하기
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]]+1 ;         //깊이 업데이트 하기
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }
    }
}
