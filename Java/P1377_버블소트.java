//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
////슈도 코드
///*
//데이터 개수 N, A(데이터 배, 단 클래스를 담는 배열로 사용)
//for (N만큼 반복)
//{
//    A 배열 저장하기
//}
//A배열 정렬하기
//for(N만큼 반복)
//{
//    A[i]의 정렬 전 index - 정렬 후 index 계산의 최댓삾을 찾아 저장하기
//}
//최댓값 +1을 정답으로 출력하기
//
//별도의 클래스 선언하기
//mData(데이터 표현)
//{
//    index, value 를 가지며
//    value 기준 오름차순 정렬 함수 Comparable 구현하기
//}
// */
//public class P1377_버블소트 {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        mData[] A = new mData[N];
//        for( int i =0; i < N; i++){
//            A[i] = new mData(Integer.parseInt(br.readLine()),i);
//        }
//        Arrays.sort(A);
//        int Max = 0;
//        for( int i=0; i< N; i++){
//            if(Max < A[i].index-i){
//                Max = A[i].index -i;
//            }
//        }
//        System.out.println(Max+1);
//    }
//
//}
//
//
//class mData implements Comparable<mData>{
//    int value;
//    int index;
//
//    public mData(int value, int index){
//        super();
//        int value1 = this.value;
//        this.index
//    }
//
//    @Override
//    public  int compareTo(mData o){
//        return this.value -o.value;
//    }
//}
