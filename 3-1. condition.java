import java.util.*;
class FlowEx2{
    public static void main(String []args){
        int input;
        System.out.println("숫자하나를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        input = Integer.parseInt(temp);

        if (input == 0){
            System.out.println("입력하신 숫자는 0입니다");//블럭 생략가능 및 조건문 바로옆에 작성가능. 블럭 생략하고 아래줄에 코드 작성시 그 아래의
            //코드는 조건문에 포함되지 않는다.
        }else{
            System.out.println("입력하신 숫자는 0이 아닙니다");
        }
        //else문 활용하기

        if (input == 0)
            System.out.println("입력하신 숫자는 0입니다");//블럭 생략가능 및 조건문 바로옆에 작성가능. 블럭 생략하고 아래줄에 코드 작성시 그 아래의
            //코드는 조건문에 포함되지 않는다.
        else
            System.out.println("입력하신 숫자는 0이 아닙니다");
        
        
       
    }
}

class Score{
    public static void main(String []args){
        
        System.out.println("당신의 점수를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();//String타입의 변수로 입력값을 받지 않고 그 문자열을 닷 Integer.parseInt();로 변환시켜주지 않아도 됨.
        char grade = ' ';
        if (score>90){
            grade = 'A';
        }else if (score>80){
            grade = 'B';
        }else if (score>70){
            grade = 'C';
        }else{
            grade = 'D';
        }
        System.out.printf("당신의 등급은 %c입니다",grade);
        

    }
}

class grade{
    public static void main(String [] args){
        System.out.println("당신의 학점을 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        char grade = ' ', msb=' ';
        System.out.printf("당신의 점수는 %d입니다%n",score);
        if (score > 90){
            grade = 'A';
            if (score >=98){
                msb = '+';
            }else if (score <= 94){
                msb='-';
           }
        }else if (score >80){
            grade = 'B';
            if (score >=88){
                msb = '+';
            }else if (score <= 84){
                msb='-';
           }
        }else grade='C';
        System.out.printf("당신의 등급은 %c%c입니다",grade,msb);
    }
}

class SwitchEx1{

    public static void main(String []args){
        System.out.println("현재 몇월인지 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        switch (month){             // swtich문은 조건의 결과값으로 오직 정수, 문자열만 받을 수 있으며 case값 역시 정수나 상수만 받을 수 있다(변수x)
            case 1:case 2:case 3:
                System.out.println("봄입니다");
                break;
            case 4:case 5:case 6:
                System.out.println("여름입니다");
                break;
            case 10:case 11: case 12:
                System.out.println("겨울입니다");
                break;
            default:
                System.out.println("아무것도 아닙니다");
        }//switch의 끝

        System.out.println("몇월인지 문자로 입력하세요  ex)5월");
        int sentence = scanner.nextInt();
        System.out.println("몇월인지 문자로 입력하세요  ex)5월");
        Scanner scanner1 = new Scanner(System.in);
        String str = scanner1.nextLine();
        scanner1.nextInt();
        // switch (sentence){
        //     case "1월":case "2월": case "3월":
        //         System.out.println("봄입니다");
        //         break;
        // }
    }
}
class SwitchEx2{
    public static void main(String [] args){
        System.out.println("가위(1)바위(2)보(3)중 하나를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int com = (int)(Math.random()*3)+1;//python의 random.randint와 같은 난수 생성 메소드라고 보면됨. 좌측의 식은1~3사이의 난수를 생성하는 식
        System.out.println("당신 : "+num+"  /  "+"컴퓨터 :"+com);
        switch (num-com){
            case -1:case 2:System.out.println("당신이 졌습니다");break;
            case -2:case 1:System.out.println("당신이 이겼습니다");break;
            case 0:System.out.println("비겼씁니다");break;
            default : System.out.println("제대로 입력하세요");//case문은 실행할 문장이 1줄을 초과하더라도 조건식 후에 붙여서 계속 쓸수 있음.
            }
    }
}

class SwtichEx3{//중첩 switch문
    public static void main(String [] args){
        System.out.println("주민등록번호를 입력하세요 ex)123456-1234567");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char num = str.charAt(7);
        switch (num){
            case '1':case '3':
                switch (num){
                    case '1': System.out.println("당신은 어른남자입니다");break;
                    case '3': System.out.println("당신은 젊은남자입니다");break;
                }//break;
            case '2':case '4':System.out.println("ㅎㅇ");
            //위쪽 swtich문의 break를 달아주지 않을 시 case문의 실행문장에 해당하는 ㅎㅇ가 출력된다. case문의 break의 역할은 조건에 해당하는
            //문장을 실행후 곧바로 switch문을 종료하는 것이나 break가 없다면 실행문장 아래부터는 조건과 관계없이 모든 문장이 실행된다.
            //그리고 swich문의 조건식에 부합되면 case문까지 실행됨. 즉 case문에 break를 해주지 않았을때와 중첩switch문에 break를 해주지 않았을때 동일
            //하게 switch문 전체 실행됨.
                switch (num){
                    case '2': System.out.println("당신은 어른여자입니다");break;
                    case '4': System.out.println("당신은 젊은여자입니다");break;
                }break;//어차피 이 뒤의 코드는 없기 때문에 생략해도 되지만 관례적, 이후 swtich문 추가등의 상황에 대비해 넣어주는 것이 좋다.
        }
        //if문 대신 굳이 switch문을 쓰는 이유 ? : if - else if문은 break를 사용한다해도 순수하게 그 조건식을 판별하고 지나간다는 것에 프로그래밍의 지연이
        //생긴다. 그러나 switch문은 맨위의 조건식 한개만 판별후 결과값에 해당하는 case로 가기 때문에 효율적이다(case로 가는 과정에서도 컴퓨터 내부적으로
        //결과값과 case값을 비교하지 않나..? 그 연산과정이 단순 정수,문자열과 비교하기 때문에 더 효율적이고 단순하다는건가.)
    }
}

