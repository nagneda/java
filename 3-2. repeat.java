import java.util.*;

class ForEx1{
    public static void main(String [] args){
        int i=1;
        for (;i<=5;++i)System.out.println("hi");//if문과 마찬가지로 블럭은 생략가능하나 첫번째 문장만 실행됨. java에서는 그냥 한 줄에 연속적으로
        //코드를 작성하는 것이 허용됨. python으로 치면 print('hi')print('hi')가 된다는것
        //위와 같은 형태로 초기화 시키든 아래와 같이 하든 관계없음.
        for (int j=1, k=10;(j<=5 && k>7);++j,k--){
            System.out.print("hello");
        }
     
    }
}
class ForEx2{
    public static void main(String [] args){
        for (int i=1,sum=0;i<=10;i++){
            sum += i;
            System.out.printf("i : %d  , 합계 : %d %n",i,sum);
        }
        //중첩 for문 별찍기

        for (int j=1;j<=5;j++){
            for (int k=1;k<=10;k++){
                System.out.print("*");
            }System.out.println("");
        }

        for (int j=1;j<=5;j++){
            for (int k=1;k<=j;k++){
                System.out.print("*");
            }System.out.println("");
        }
        //구구단
        for (int i=2;i<=9;i++)
            for (int j=1;j<=9;j++)
                System.out.printf("%d * %d : %d %n",i,j,i*j);
            
    }//main의 끝
}

class EnhancedFor{
    public static void main(String [] args){
        int [] arr = {10,20,30,40,50}; //java에서의 배열 선언방법
        for (int i=0; i<arr.length;i++ ) //python의 len(a)와 비슷한 형태. 배열의 길이를 나타내는 배열명.length
            System.out.println(arr[i]);

        for (int tmp : arr)System.out.println(tmp);//향상된 for문 작성방법. 타입 변수명은 배열 혹은 컬렉션의 타입이어야 하며 콜론 뒤에는 반복가능한
        //요소가 들어와야 한다. python의 for i(반복가능한 요소의 원소) in 반복가능한 요소(iterable)의 형태와 비슷. arr가 반복가능요소이며 tmp는 원소로서 작용.
    }//End of main
}

class While{
    public static void main(String [] args){
         int i=1;
         while (i<=10){
            i++;
            System.out.println(i);
         }
         i=0;
         while (i++!=10){ //조건식에 증감연산자가 들어가는 것은 조건식이 평가 된 후 증감됨. 단 후위형만 가능하고 전위형은 전혀 다른 식이 된다.
            System.out.println(i);
         }
    }
}

class WhileEx1{
    public static void main(String []args){
        int i = 11;

        while (i--!=0){
            System.out.println(i);
            for (int j=0;j<=1_200_000_000;j++);//출력지연 
        }
        System.out.println("GAME OVER");


        int sum=0, j=0;
        while ((sum+=++j)<=100){ //sum=sum+ ++j , sum<=100의 형태가 압축된 형태
            System.out.printf("sum : %d / j : %d %n",sum,j);
        }//위 아래의 코드는 동일. java에는 복합 대입연산자에 증감연산자를 합친 증감식이 많이 나오니 눈에 익혀둬야한다.
        for (sum=0, i=0;sum<=100;sum+=++i){
            System.out.printf("%d %n",sum);
            
        }
    
    }
}

class DoWhileEx1{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int ran = (int)(Math.random()*10)+1, input = -1;
       //while문 안에서 정답이 나올때까지 사용자의 입력을 받으려고 한다. 처음 while문 진입시 조건에 input이 선언
        //돼있어야하기 때문에 while문 밖에서 input을 초기화시켜줘야함. 혹은 ran의 값으로 나올 수 없는 범위의 리터럴로 input 초기화 시켜주면 더 간단해진다.
        while (ran!=input){
            System.out.println("1~10사이의 숫자를 입력하세요");
            input = scanner.nextInt();
            if (input>ran){
                System.out.println("더 작은수로 입력하세요");
            }else if (input<ran){
                System.out.println("더 큰수로 입력하세요");
            }
            
        }
        System.out.println("정답입니다");
        //위 작성 프로그램은 아래의 do-while문으로 대체될 수 있다.

        int input1 = 0;
        do{
            System.out.println("1~10사이의 숫자를 입력하세요");
            input1 = scanner.nextInt();
            if (input1>ran){
                System.out.println("더 작은수로 입력하세요");
            }else if (input1<ran){
                System.out.println("더 큰수로 입력하세요");
            }
        }while (input1!=ran);
        System.out.println("정답이다");

        

        //요약하자면 do-while문은 잘 쓰이지는 않으며 while의 조건값에 설령 해당하지 않더라도 1번은 수행되는데에 그 의의가 있다. 위 프로그램 예제는
        //그러한 do-while문의 특성을 느끼기에는 조금 부족했지 않나 생각된다. 위 예제는 사용자 입력 변수의 초기화를 while문 밖에서 시켜주면 조건식에서
        //에러가 발생할 일도 없고 무조건 1번은 수행시켜야 한다는 특이점도 없다. 굳이 비유하면 python의 try-except처럼 ty문이든 except문이든 에러가 발생
        //되더라도 1개는 실행되는 느낌.
    }//main의 끝
}

class DoWhileEx2{
    public static void main(String []args){
        for (int i = 1;i<=100;i++){
            System.out.printf("i=%d",i);
            int tmp=i;
            do{
                if(tmp%10%3==0 && tmp%10!=0)
                    System.out.print("짝");
            }while((tmp/=10)!=0);//몫을 판별하기 위해 10의 자리 수를 몫으로 가지며 tmp에 저장
            System.out.println();
                
            }
        }
}

class ContinueEx1{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int menu =0, num=0;

        while (true){
            System.out.println("메뉴를 선택하세요 1~3(0은 종료)");
            menu = scanner.nextInt();// String tmp = scanner.nextLine(); menu = Integer.parseInt(tmp); 입력받은 숫자문자열을 정수화 시킴. 
            if (menu==0){
                System.out.println("종료합니다");
                break;
            }else if ( !(1<=menu && menu<=3)){
                System.out.println("제대로 선택하십쇼");
                continue;

            }
            System.out.println("당신이 선택한 메뉴는"+menu+"입니다");
            break;
        }
        
    }
}

class NamingRepeat{//break사용시 가장 근접한 반복문을 빠져나가는데 반복문에 Naming할 경우 더 밖에 있는 반복문을 나갈 수 있음.
    public static void main(String [] args){
        Dan : for (int i=2; i<=5;i++){
                for (int j=1; j<=9;j++){
                    //4단만생략 if (i==4)break;
                    if (i==4)break Dan;//3단까지만 출력
                    System.out.printf("%d x %d = %d %n",i,j,i*j);
                }
        }
    }
}