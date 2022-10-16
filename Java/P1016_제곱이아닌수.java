import java.util.Scanner;

//슈도코드
/*
min(최솟값). Max(최댓값)
Check(min ~ Max 사이에 제곱수 판별 배얄)
for( i = 2 ~ Max 사이 반복, i*i 증가){
    pow(제곱수)
    start_index(최솟값/최댓값)
    for( j = start_index ~ Max 사이 반복){
        j* pow 가 Max보다 작을때 최소, 최대값 사이의 제곱수이므로 Check 배열에 저장하기
    }
}

count(제곱이 아닌 수 카운트)
for(0 ~ Max-min){
    Check 배열에서 제곱이 아닌 수라면 count 증가
}
count 출력하기
 */
public class P1016_제곱이아닌수 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long Max = sc.nextLong();

        //최댓값과 최솟값의 차이만큼 배열 선언하기
        boolean [] Check = new boolean[ (int)( Max-min+1 )];

        //2의 제곱수인 4부터 Max보다 작거나 같은 값까지 반복하기
        for (long i = 2; i<= Max; i++){
            long pow =i*i;          //제곱수
            long start_index = min/pow;
            if( min % pow !=0)
                start_index++;          //  나머지가 있으면 1을 더해야 min보다 큰 제곱수에서 시작한다.
            for (long j= start_index; j*pow <= Max;j++){            //제곱수를 true로 변경하기
                Check[(int) ((j*pow) - min)] = true;
            }
        }
        int count = 0;
        for( int i = 0 ; i <= Max-min; i++){
            if(!Check[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}
