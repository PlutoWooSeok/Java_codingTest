import java.util.ArrayList;
import java.util.Scanner;

// 슈도 코드 //
/*
///////////////////////////
N(너드 개수)
A(그래프 데이터 저장 인접 리스트)
visited( 방문 기록 저장 배열 )
ans( 리프 노드 개수 저장 배열 )
del( 삭제 노드 )
///////////////////////////
for( N의 개수만큼 반복 ){
    A 인접 리스트의 각ArrayList 초기화
}
for( N의 개수 만큼 반복 ){
    if( 루프 노드가 아닌 경우)
        A 인접 리스트에 그래프 데이터 저장하기
    else
        루트 노드값 저장하기
}
삭제 노드값 저장하기
if( 삭제 노드 값이 0 인 경우){
    모두 삭제 되므로 0을 출력하고 프로세스 종료
}
else{
    DFS(root)           //루트로 부터 DFS 실행하기
    ans 출력하기
}
/////////////////////////////////
////////DFS 구현하기/////////
DFS(){
    방문 배열에 현재 노드 방문 기록하기
    for( 연결 노드 탐색하기){
        if(현재 노드의 연결 노드 중 방문하지 않은 노드이고 삭제 노드가 아닐 때){
            자식 노드 개수 증가
        }
        DFS 실행하기( 재귀함수 형태 )
    }
    만약 자식 노드 개수가 0이면 ans 변수 증가
}

 */
public class 트리_P1068_리프노드 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int ans =0;                      //리프 노드 개수 저장 변수
    static int del= 0;                      //삭제 노드 번호
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        int root = 0;
        for( int i = 0; i<N;i++){
            A[i]  = new ArrayList<>();              //A 인접 리스트의 각 ArrayList 초기화
        }
        for (int i = 0; i<N;i++){
            int P = sc.nextInt();               //노드의 부모 노드번호 입력
            if( P != -1){               //부모 노드가 아니라면
                A[i].add(P);
                A[P].add(i);
            }else
                root = i;                   //i는 루트노드
        }
        del = sc.nextInt();                 //삭제 할 노드 번호 입력
        if( del == root)
            System.out.println(0);
        else {
            DFS(root);                      //루트 노드부터 DFS 실행하기
            System.out.println(ans);
        }
    }

    static void DFS(int k){
        visited[k] = true;                      //방문 노드 확인
        int cNode = 0;                              //자식 노드
        for ( int i : A[cNode]){                        //연결 노드 탐색하기
            if( visited[i] == false && i != del){           //방문하지 않고, 삭제 노드가 아닐 경우
                cNode ++;                               //자식 노드 ++
                DFS(i);                                 //다시 DFS실행하기 ==> 재귀함수 형태
            }
        }
        if( cNode == 0){                        //자식 노드가 0인 경우 ==> 즉 리프노드이면
            ans ++;                     //정답을 ++
        }
    }
}
