
//chapter3 operator(연산자)
import java.util.*;
class OperatorEx1 {
    public static void main(String []args){
        int a=5;
        int b=2;
        System.out.println("형변환전 a/b : "+a/b);
        System.out.println("형변환후 a/b : "+a/(float)b);//산술변환(자동형변환)에 의한 결과값 실수 표현, 파이썬의 //과 /가 따로 있는 것과 다른 모습
        float c = a/(float)b;
        System.out.println("float 타입의 변수 c에 저장된 a/b : "+c);//a에는 float타입의 결과값을 변수에 저장할 수 없기 때문에 실수형의 연산결과를 
        //저장하기 위해서는 새로운 실수형 변수 c가 필요
    }       
}

class OperatorEx2 {
    public static void main(String[] args){
        int i = 5;
        int j = 0;
        j=i++;//i가 증감되기 전인 5가 j에 대입된 후 i에 1이 증감됨
        //증감연산자가 전위형이냐 후위형이냐에 따라 결과값이 달라지는 모습. 대입연산자에 대입떄도 그렇고 메소드 호출에도 그렇고.
        System.out.println("j :"+j+" i : "+i);
        i=5;
        j=++i;
        System.out.println("j :"+j+" i : "+i);
        i=5;
        j=5;
        System.out.println(i++);
        System.out.println(++j);
        System.out.println("i++ : "+i+" ++j : "+j);
        i=5;
        i=i++;
        System.out.println(i); 

        System.out.println("5/2:" +5/2.0);

    }
}

class OperatorEx3{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        char ch=' ';

        // System.out.printf("문자를 입력하세요");
        // //String input=scanner.nextLine(); //char 타입의 변수로는 scanner의 입력값을 받아들일 수 없는 듯하다.
        // ch=input.charAt(0);

        // if('0'<=ch && ch<='9') {
        //     System.out.println("입력하신 문자는 숫자입니다");
        // }
        // if(('a'<=ch && ch<='z')||('A'<=ch && ch<='Z')) {
        //     System.out.println("입력하신 문자는 영문자입니다");
        // }
        
        boolean b = true;
        char ch1='A';
        System.out.printf("b : %b %n",b);
        System.out.printf(" ch<'a' || 'z'>ch : %b %n",ch<'a' || 'z'>ch1);
        System.out.printf("!('a'<=ch1 && ch1<='z') = %b%n",!('a'<=ch1 && ch1<='z')); //이 식과 위의 식은 같은 표현식이다. 가독성이 더 뛰어남. 논리부정연산자 ! 사용

        int c=0;
        int a=5;
        System.out.println(a>4 || ++c==1);
        System.out.println(c);
        System.out.println(a==5 && c++==1);
        System.out.println(c);
        //and와 or의 효율적인 연산에 관한 식. 조건에 부합하지 않으면 우변의 식은 실행되지도 않고 종료되는 것을 증감연산자를 통해 알 수 있음. 값을 바꿔가면
        //테스트해보면 좋다.

    }
}

