import java.util.Arrays;
import java.util.Scanner;

public class 탐색_P1920_원하는정수찾기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for( int i = 0; i<N; i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int M = sc.nextInt();
        int B[] = new int[M];
        for( int i = 0; i <M ;i++){
            B[i] = sc.nextInt();
        }

        boolean find = false;
        int start =0;
        int end = A.length-1;

        for( int i = 0; i< M; i++){

            while( start <= end){
                int mid_index = (start + end)/2;
                int mid_value = A[mid_index];
                if( B[i] < mid_value){
                    end = mid_index-1;
                } else if ( B[i] > mid_value) {
                    start = mid_index+1;
                }else if( B[i] == mid_value) {
                    find =true;
                    break;
                }

            }
            if( find ){
                System.out.println(1);
                start =0;
                end = A.length-1;
                find = false;
            }else {
                System.out.println(0);
                start =0;
                end = A.length-1;
                find = false;


            }

        }


        }
}
