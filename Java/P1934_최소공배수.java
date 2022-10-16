import java.util.Scanner;

public class P1934_최소공배수 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        for( int i =0; i<N; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int result =  A*B / gcd(A,B);
            System.out.println(result);
        }
    }

    //유클리드 호제법
    private static int gcd(int a, int b) {
        if(b == 0)
            return a;
        else
            return gcd(b,a%b);
    }
}
