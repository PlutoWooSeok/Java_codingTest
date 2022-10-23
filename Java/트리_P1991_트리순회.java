//슈도 코드//
/*
////////////////////////////////////////////////////////
N(노드 개수), tree( tree 데이터 저장 2차원 배열 )
for( N의 개수만큼 반복하기 ){
    if( 왼쪽 자식 노드가 없을 때)
        tree 배열에 -1 저장
    else
        tree 배열에 왼쪽 자식 노드 인덱스 저장하기
    if( 오른쪽 자식 노드가 없을 때 )
        tree 배열에 -1 저장
    else
        tree 배열에 오른쪽 자식 노드 인덱스 저장하기
    preOrder 실행하기 -> inOrder 실행하기 -> postOrder 실행하기
}
/////////////////////////////////////////////////////////

preOrder{                                           // 중간 - 왼쪽 - 오른쪽
    현재값이 -1이면 리턴(자식 노드가 없으면)
    1. 현재 노드 출력하기
    2. 왼쪽 자식 노드 탐색하기
    3. 오른쪽 자식 노드 탐색하기
}

inOrder{                                            // 왼쪽 - 즁간 - 오른쪽
    현재값이 -1이면 리턴하기(자식 노드가 없으면)
    1. 왼쪽 자식 노드 탐색하기
    2. 현재 노드 출력하기
    3. 오른쪽 자식 노드 탐색하기
}

postOrder{                                          // 왼쪽 - 오른쪽 - 중간
    현재값이 -1이면 리턴하기(자식 노드가 없으면)
    1. 왼쪽 자식 노드 탐색하기
    2. 오른쪽 자식 노드 탐색하기
    3. 현재 노드 출력하기
}
 */
import java.util.*;

public class 트리_P1991_트리순회 {
    static int [][]tree;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());                //노드의 개수
        tree = new int[26][2];                          //트리 데이터 저장 배열

        for ( int i = 0 ; i<N; i++){
            String[] temp = sc.nextLine().split(" ");           //받은 문자열을 공백으로 나누어 문자형으로 변환하여 저장
            int node = temp[0].charAt(0)-'A';
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

            //자식 노드가 없을 때 -1을 저장하기
            if( left == '.'){                           //왼쪽 자식 노드가 없을 경우
                tree[node][0] = -1;
            }else {                                     // 숫자로 변환
                tree[node][0] = left -'A';
            }
            if( right == '.'){                          //오른쪽 자식 노드가 없을 경우
                tree[node][1] = -1;
            }else {                                     //있을 경우 숫자로 변환
                tree[node][1] = right -'A';
            }
        }
        preOrder(0);                                    //전위 순환
        System.out.println();
        inOrder(0);                                     //중위 순환
        System.out.println();
        postOrder(0);                                   //후위 순환
        System.out.println();
    }

    ///////////////////////////////////////////////
    public static void preOrder(int a){
        if( a == -1){
            return;
        }
        System.out.print((char) ( a +'A'));                 //현재 노드
        preOrder(tree[a][0]);                               //왼쪽 자식 노드
        preOrder(tree[a][1]);                               //오른쪽 자식 노드
    }
    /////////////////////////////////////////////////
    public static void inOrder(int a){
        if( a == -1){
            return;
        }
        inOrder(tree[a][0]);                                //왼쪽 자식 노드
        System.out.print((char) ( a +'A'));                 //현재 노드
        inOrder(tree[a][1]);                                //오른쪽 자식 노드
    }
    /////////////////////////////////////////////////
    public static void postOrder(int a){
        if( a == -1){
            return;
        }
        preOrder(tree[a][0]);                               //왼쪽 자식 노드
        preOrder(tree[a][1]);                               //오른쪽 자식 노드
        System.out.print((char) ( a +'A'));                 //현재 노드
    }
    /////////////////////////////////////////////////

}
