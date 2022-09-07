import java.util.Scanner;

public class java_TIL03 {
    //조건문과 반복문
    //조건문 : 조건을 만족할 때만 {}를 수행(0~1번)
    //반복문 : 조건을 만족하는 동안 {}를 수행(0~n번)

    //예제4-4
//    public static void main(String[] args){
//        int score = 0;
//        char grade =' ';
//
//        System.out.print("점수를 입력하세요>");
//        Scanner scanner = new Scanner((System.in));
//        score = scanner.nextInt();
//
//        if( score >= 90){
//            grade = 'A';
//        } else if (score >=80) {
//            grade = 'B';
//        } else if (score >=70) {
//            grade = 'C';
//        }else {
//            grade = 'D';
//        }
//        System.out.println("당신의 학점은 "+grade + "입니다.");
//
//    }
//
    public static void main(String[] args){
        int score = 0;
        char grade =' ';
        char opt = '0';

        System.out.print("점수를 입력하세요>");

        Scanner scanner = new Scanner((System.in)); // 화면을 통해 입력받은 점수를 score에 저장
        score = scanner.nextInt();

        System.out.printf("당신의 점수는 %d입니다.%n", score);
        if( score >= 90){   // score 가 90점 보다 같거나 크면 A학점(grade)
            grade = 'A';
            if(score >= 98){    // 90점 이상 중에서도 98점 이상은 +
                opt ='+';
            } else if (score < 94) {    //90점 이상 94점 미만은 -
                opt = '-';
            }
        } else if (score >=80) {    // score 가 80점 보다 같거나 크면 A학점(grade)
            grade = 'B';
            if(score >= 88){    // 80점 이상 중에서도 88점 이상은 +
                opt ='+';
            } else if (score < 84) {     //80점 이상 84점 미만은 -
                opt = '-';
            }
        } else if (score >=70) {    // score 가 70점 보다 같거나 크면 A학점(grade)
            grade = 'C';
            if(score >= 78){   // 70점 이상 중에서도 78점 이상은 +
                opt ='+';
            } else if (score < 74) {    //70점 이상 74점 미만은 -
                opt = '-';
            }
        }else {
            grade = 'D';    //나머지는 D학점(grade)
        }
        System.out.printf("당신의 학점은 %c%c 입니다.%n", grade,opt);

    }

}

