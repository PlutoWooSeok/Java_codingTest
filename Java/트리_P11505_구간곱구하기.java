//슈도 코드//
/*
tree(세그먼트 트리 배열)
N(수의 개수), M(변경이 일어나는 개수), K(구한 곱을 구하는 개수)
MOD(1000000007)
treeSize 구하기 -> Math.pow(ㅈ, 트리의 높이 +1)
leftNodeStartIndex 구하기 ->treeSize/2 -1
tree 초기화하기
tree 뱌열의 리프노드 영역에 데이터 받기
setTree(트리의 크기)
for( M + K 만큼 반복){
    a(질의 유형),s(시작인덱스),e(변경값 또는 종료인덱스)
    a가 1일 때 -> changeVal(tree의 시작 인덱스, e(변경값))
    a가 2일 때 -> gerMul(tree의 시작 인덱스, tree의 종료인덱스)
}

//구간 곱을 구하는 함수 구현하기
gerMul(int s, int e){
    while( s<=e){
        if( 시작 인덱스 % 2 == 1 )    해당 노드의 값을 구간 곱에 곱하기 % MOD
        if( 종료 인덱스 % 2 == 1 )    해당 노드의 값을 구간 곱에 구하기 % MOD
        시작 인덱스 = 시작인덱스/2
        종료 인덱스 = 종료인덱스/2
    }
    구간 곱 결과 리턴하기
}

//값 변경 함수 구현하기
changeVal( int s, int e){
    현재 인덱스에 변경값 저장하기
    while(시작 인덱스가 1보다 크다){
        시작 인덱스 = 시작 인덱스 / 2
        //현재 노드의 양쪽 자식 노드를 찾아 곱하는 로직
        시작 인덱스 트리값 = 시작 인덱스 * 2 의 트리값 % MOD * 시작 인덱스 * 2 + 1 의 트리값 % MOD
    }
}
//초기 트리 생성 함수 구현하기
setTree( int i ){
    while( 인덱스사 루트가 아닐 때까지 반복){
        트리의 인덱스 / 2 부분(부모 노드) 에  현재 index값의 트리값 곱하기 % MOD
        index --
    }
}
 */
import java.util.*;
import java.io.*;

public class 트리_P11505_구간곱구하기 {
    static long tree[];
    static int MOD = 100000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());                       //수의 개수
        int M = Integer.parseInt(st.nextToken());                       //변경이 일어나는 횟수
        int K = Integer.parseInt(st.nextToken());                       //구간 곱을 구하는 수

        int height = 0;
        int lenght = N;

        while( lenght != 0){
            lenght/=2;
            height++;
        }

        int treeSize = (int) Math.pow(2, height/2 +1);
        int leftNodeStartIndex = treeSize/2 -1;
        for( int i = 0;i< tree.length;i++){                             //곱셈이므로 초기값을 1로 설정
            tree[i] = 1;
        }
        for( int i = leftNodeStartIndex+1; i<= leftNodeStartIndex+N; i++){
            tree[i] = Long.parseLong(br.readLine());                    //데이터를 리프 노드에 입력받기
        }
        setTree(treeSize-1);                                //tree 만들기
        for( int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if( a ==1) {                                                    //변경하기
                changeVal( leftNodeStartIndex + s, e);
            }else if( a ==2){                                                   //구간 곱
                s = s+ leftNodeStartIndex;
                e = e+ leftNodeStartIndex;
                System.out.println(getMul(s, (int) e));
            }else {
                return;
            }
        }
        br.close();
    }

    ///////모든 함수에서 곱셈이 발생할 때마다 MOD 연산 수행하기
    private static long getMul(int s, int e) {
        long partMul= 1;
        while( s <= e){
            if( s % 2 ==1 ){
                partMul  = partMul * tree[s] % MOD;
                s++;
            }
            if (e % 2 == 0){
                partMul  = partMul * tree[e] % MOD;
                e--;
            }
            s = s/2;
            e = e/2;
        }
        return partMul;
    }

    private static void setTree(int i) {
        while ( i != 1){
            tree[i/2] = tree[i/2] * tree[i] % MOD;
            i--;
        }
    }

    private static void changeVal(int index, int val) {
        tree[index] = val;
        while( index > 1){              //현재 노드의 양쪽 자식 노드를 찾아 곱하는 로직
            index = index/2;
            tree[index] = tree[index * 2] % MOD * tree[index * 2 + 1] % MOD;
        }
    }


}
