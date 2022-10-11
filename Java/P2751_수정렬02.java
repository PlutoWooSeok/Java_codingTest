import java.io.*;

//슈도정렬
/*
    N(정렬할 수 개수)
    A(정렬할 배열 선언하기)
    temp(정렬시 잠시 사용할 임시 배열 선언하기)
    for(N의 개수 만큼)
    {
        A 배열 선언하기
    }
    병헙 정렬 함수 실핼하기
    결과값 출력하기
    //병합 정렬 수행하기
    병합 정렬(s, e){
    s(시작점), e(종료점), m(중간점)
        //재귀함수 형태로 구현하기
        병합 정렬(s,m)
        병합 정렬(m+1,e)
        for(s~e)
        {
            temp 배열 저장하기
        }
        //두 그룹을 병합하는 로직
        index1 : 앞쪽 그룹 시작점
        index1 : 뒤쪽 그룹 시작점
        while( index1 <= 중간점 && index2 <= 종료점 )
            양쪽 그룹의 인덱스가 가리키는 값을 비교한 후 더 작은 수를 선택해 배열에 저장하고,
            선택된 데이터의 인덱스 값을 오른쪽으로 한 칸 이동하기
            반복문의 끝난 후 남아 있는 데이터 정리하기
 */
public class P2751_수정렬02 {
    public static int[]A, tmp;
    public static long result;
    public static void main(String[] args) throws IOException{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        A = new int[N+1];
        tmp =new int[N+1];
        for (int i =0 ; i < N; i++){
            A[i] = Integer.parseInt(bf.readLine());
        }
        merget_sort(1, N);
        for(int i = 0; i<N; i++){
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void merget_sort(int s, int e) {
        if ( e - s < 1)
            return;
        int m = s+ (e-s)/2;
        //재귀함수 형태로 표현
        merget_sort(s,m);
        merget_sort(m+1,3);;
        for(int  i =s; i<=e; i++){
            tmp[i] = A[i];
        }
        int k =s;
        int index1 =s;
        int index2 = m+1;
        while ( index1 <=m && index2 <=e){
            if ( tmp[index1] > tmp[index2]){
                A[k] = tmp[index2];
                k++;
                index2++;
            }else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while (index1 <= m){
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e){
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
