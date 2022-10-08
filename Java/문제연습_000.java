import java.util.Arrays;

public class 문제연습_000 {
    public static void main(String[] args){
        int cnt = (int)(Math.random()*1000000);
        int arr[] = new int[cnt];
        int N;

        System.out.println(cnt);
        for(int i = 0; i < cnt ; i++){
            N = (int)(Math.random()*1000000);
            arr[i] = N;
        }
        Arrays.sort(arr);
        for(int i= 0; i <cnt; i++){
            System.out.println(arr[i]);
        }
        }
    }
