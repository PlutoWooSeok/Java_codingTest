//슈도 코드//
/*
tree(세그먼트 트비 배열 )
N(숫자의 개수), M(수 변경횟수), K( 구간합 구하는 횟수)
treeSize 구하기 -> Math.pow(2, 트리의 높이 + 1)         //Math.pow() : 거듭제곱을 구하는 매서드
leftNodeStartIndex 구하기 --> treeSize/2 -1          //리프 노드 시작 인덱스
tree 배열의 리프 노드 영역에 데이터 입력받기
serTree(트리의 크기)
for( M+K 만큼 반복하기 ){
    a(질의 유형) , b(b번째 숫자), c(c번째 숫자)
    a = 1 ==> b <-> c  ==> changeVal( leftNodeStart + b,c)
    a = 2 ==> b ~ c 의 합구하기  ==> getSum(b,c)
}

//구간 합 구하기 함수
getSum(b,c){
    while( b <= c){
        if( b % 2 == 1 )
            해당 노드의 값을 구간 합에 추가하거나 시작인덱스 증가
        if( b % 2 == 0 )
            해당 노드의 값을 구간 합에 추가하거나 시작 인덱스 감소
        b = b / 2;
        c = c / 2;
    }
    구간 합 결과 리턴하기
}

//값 변경함구 구현하기
changeVal(int b, int c){
    diff( b 노드의 값과 c의 차이)
    while( b > 0){
        b의 트리값에 diff 값을 더함
        b = b/2;
    }
}

//초기 트리 생성 함수 구현하기
setTree(트리의 마지막 인덱스){
    while( 인덱스가 루트가 아닐때 까지 반복하기 ){
        트리의 인덱스 / 2 부분(부모 노드)에 현재 index의 트리값 더하기
        index 1개 감소
    }
}
 */
import java.io.*;
import java.util.*;
public class 트리_P2042_구간합구하기_3 {
    static long [] tree;

    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       //수의 개수
        int M = Integer.parseInt(st.nextToken());       //변경 횟수
        int K = Integer.parseInt(st.nextToken());       //구간 합 구하는 횟수

        int treeHeight = 0;                         //트리의 높이
        int treeLength = N;                         //트리의 길이
        while ( treeLength !=0 ){                   //트리 놆이 구하기
            treeLength /= 2 ;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);       //트리 배열의 크기
        int leftNodeStartIndex = treeSize/2 -1;             //리프 노드 시작 인덱스
        tree = new long[treeSize +1];
        //데이터를 리프 노드에 입력받기
        for( int i = leftNodeStartIndex +1 ; i <= leftNodeStartIndex+N; i++){
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize -1);
        for( int i = 0 ; i< M+K; i++){
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());          // 질의 종류
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if( a == 1 ){
                changeVal( leftNodeStartIndex + b, c);
            } else if ( a == 2 ) {
                b = b + leftNodeStartIndex;
                c = c + leftNodeStartIndex;
                System.out.println(getSum(b, (int) c));
            }else{
                return;
            }
        }
        br.close();
    }
    private static long getSum( int b, int c){
        long partSum = 0;
        while(b <= c){
            if( b %2 ==1 ){
                partSum = partSum + tree[b];
                b++;
            }if( c % 2 == 0){
                partSum = partSum + tree[c];
                c--;
            }
            b = b/2;
            c = c/2;
        }
        return partSum;
    }

    private static void changeVal(int s, long e){
        long diff = e - tree[s];
        while(s > 0){
            tree[s] = tree[s] + diff;
            s = s/2;
        }
    }

    private static void setTree(int i){
        while( i !=1){
            tree[i/2] += tree[i];
            i--;
        }
    }

}
