public class timeComplexityExample1 {
    public static void main(String[] args) {
        //1~100 사이의 값 랜덤 선택
        int findNumber = (int)(Math.random() * 100);
        for(int i = 0; i<100; i++){
            if(i == findNumber){
                System.out.println(i);
                break;
            }
        }
    }
}
