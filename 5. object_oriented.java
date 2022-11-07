import java.util.*;
class Instance{
    public static void main( String []args){
        String str; //string클래스의 str이라는 참조변수를 선언.
        str = new String("하이"); //객체를 생성 후 객체 주소를 참조변수에 저장.
    }
}

class Tv{
        //void 함수 작성시 일반적으로 작성하는 void main 메서드 작성하면 안되는 듯. 추후에 배울 내용 같음.
        //TV의 속성(멤버변수)
        int channel;
        String color;
        boolean power;
        //TV의 기능(메서드)
        void power() {power=!power;}
        void channelUp() {++channel;}
        void channelDown() {--channel;}

}//class의 끝

class TvTest{
    public static void main(String []args){
        Tv tele;//참조변수 tele생성
        tele = new Tv();// TV클래스의 인스턴스를 생성, 그 인스턴스의 주소를 참조변수 tele에 저장. 
        tele.channel = 50; // 인스턴스를 불러오지 않으면 각 타입에 맞는 기본값을 가짐. channel은 int니까 0, color는 String이라 null.
        tele.color = "green";
        Scanner scanner = new Scanner(System.in);
        System.out.println("tv를 켜려면 1, 끄려면 0을 입력하세요.");
        int input = scanner.nextInt();
        if (input == 1){
                
            tele.power();
            System.out.printf("채널 : %d, tv색상 : %s 전원상태 : %b %n",tele.channel,tele.color,tele.power);
        }
        while(tele.power){
            
            System.out.println("채널up : 1, 채널down :2, tv종료 :0");
            input = scanner.nextInt();
            switch(input){
                case 0: tele.power();
                    System.out.println("Tv를 종료합니다");
                    break;
                case 1: {
                    tele.channelUp();
                    System.out.printf("현재채널은 %d번입니다 %n",tele.channel);
                    break;
                }
                case 2: {
                    tele.channelDown();
                    System.out.printf("현재채널은 %d번입니다%n",tele.channel);
                    break;
                }
            }
            
        }
    }
}
class TvTest2{//인스턴스2개를 생성했을때의 멤버변수의 값은 독립적이며 참조변수끼리 대입시켰을때 멤버변수 및 인스턴스 변경에 대해 알 수 있는 예제.
    public static void main(String []args){
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        t1.channel = 10;
        t2.channel = 20;
        t1.color = "blue";
        t2.color = "green";
        System.out.printf("t1 : %d,%s t2 : %d%s %n",t1.channel,t1.color,t2.channel,t2.color);
        //각각 다른 인스턴스의 주소를 가지고있는 참조변수 t1과 t2가 t1의 인스턴스 주소를 같이 공유하게 됨.
        //t1이 가지고있던 주소와 값을 t2에 저장. 즉 t2가 t1과 하나가 되며(인스턴스 주소가 t1) 참조변수만 2개로 늘어난 것.
        t2=t1;
        System.out.printf("t1 : %d,%s t2 : %d%s %n",t1.channel,t1.color,t2.channel,t2.color);//결정적으로 이 코드를 보면 어떻게 동작하는지 이해할 수 있다.
        t2.channel = 50;
        System.out.printf("t1 : %d,%s t2 : %d%s %n",t1.channel,t1.color,t2.channel,t2.color);
        t1.channel = 100;
        System.out.printf("t1 : %d,%s t2 : %d%s %n",t1.channel,t1.color,t2.channel,t2.color);
    }
}

class ObjectArr{
    public static void main(String [] args){
        Tv[] arr = new Tv[5]; //참조변수만 생성한 것이며 인스턴스는 생성되지 않아서 멤버변수와 메서드를 사용할 수 없는 상태. 초기화 해줘야함.
        for (int i=0;i<arr.length;i++)
            System.out.println(arr[i]);//참조변수의 기본값인 null 출력
        for (int j=0;j<arr.length;j++){
            arr[j]=new Tv();
        //초기화 방법은 여타 다른 타입의 배열들의 초기화 방법과 동일하다.
        //Tv[] arr = {new Tv(),new Tv(),new Tv()};
        //Tv[] arr = new Tv[]{new Tv(),new Tv(),new Tv()}
            System.out.println(arr[j]);//인스턴스의 주소가 출력
        }
        

    }
}

class Card{
    int number;
    String kind;
    static int width=100;
    static int height=70;
    static void test(){System.out.print("test입니다");}
    void test1(){System.out.print("test2입니다");}
}

class CardTest{
    static void prin(Card [] cardArr){
        for (int i =0; i<cardArr.length;i++){
            cardArr[i]=new Card();
            cardArr[i].number = i+1;
            System.out.println("두께 :"+cardArr[i].width+"번호 : "+cardArr[i].number);
        }
    }
    void what(){
        Card c = new Card();
        Card.test();
        c.test1();
    }
    public static void main(String [] args){
        Card[] cardArr = new Card[5];
        cardArr[0].width = 200; // 클래스 변수이기 때문에 인스터스가 생성되지 않아도 에러없이 동작하며 첫번째 참조변수의 두께만 바꿨는데도 참조변수 전체
        //두께가 모두 200으로 바뀐것을 아래 출력문에서 확인할 수 있음.
        //cardArr[0].number = 33;  이 코드는 초기화를 시키지 않았기 때문에 에러발생. number가 인스턴스 변수기 때문인 듯하다.
        prin(cardArr);
        Card.width = 300;
        //클래스변수를 사용하고자 할때는 참조변수.클래스변수의 형태보다는 클래스명.클래스변수의 형태로 사용하는 것이 좋다. 클래스변수를
        //인스턴스 변수로 오해받을 수 있기 때문.
        prin(cardArr);
        //클래스변수에는 참조변수를 통하거나 클래스명을 통해서 접근할 수 있다.
        Card.test();
        }

}

class Method{
        int add(int x, int y){
            int result= x+y;
            System.out.println(test(3,5));//얘는 static메서드를 호출 가능. 후술하겠지만 static메서드와 인스턴스 메서드의 개념 적용.
            return result;
            
        }
        
        int addsub(int x, int y){//메서드내의 매개변수를 포함한 변수들은 해당 메서드 내의 지역변수기 때문에 각 메서드별로 동일명을 사용해도 무관함.
            int result = add(x,y)-10;//같은 클래스내의 add메소드를 참조변수없이(인스턴스 생성없이) 호출가능.
            return result;
        }
        static int test(int x, int y){ return x*y;}//얘는 add나 addsub메소드를 객체생성없이 호출할 수 없음. static이 붙었기 때문.

        float multiply(float x, float y){ return x/y;}
        public static void main(String [] args){

            Method mm = new Method();//static 메서드는 같은 클래스내라도 다른 메서드를 호출하려면 다음과 같이 인스턴스를 생성해야한다.
            int result = mm.add(5,17);
            int result2 = mm.addsub(100,50);//140이 반환값이 돼야함.
            System.out.println(result+"//"+ result2);
            System.out.println(test(7,5));//test메서드는 static이 붙었기 때문에 객체 생성없이 호출가능.
        }
}
class MethodTest{
    public static void main(String [] args){
        Method mm = new Method();
        System.out.println(mm.add(3,5));
        System.out.println(mm.multiply(10,3));// 파라미터의 타입이 int라도 위쪽 매개변수 타입이 float이기 때문에 자동형변환됨. float x = 10;과 동일
    }
}
//java는 파이썬과 다르게 메서드의 작성순서에 관계없이 메서드가 실행된다. 아마 파이썬은 인터프리터 형식이라 위에서부터 순차동작을 하기때문인 것 같고
//java는 컴파일 후 class파일이 생성되기 때문에 이미 메서드에 관한 정보가 저장돼있기 때문이지 않을까 생각된다. 순서가 관계없다는 건 아래 예제를 통해 확인 가능.


class CallStackFlow{
    public static void main(String [] args){
        System.out.println("main 메서드 실행");
        first();
        System.out.println("main 메서드 종료");
    }
    static void first(){
        System.out.println("first 메서드 실행");
        second();
        System.out.println("first 메서드 종료");
    }
    static void second(){
        System.out.println("second 메서드 실행!!");
    }
    //파이썬은 호출하려는 함수가 무조건 함수선언부보다 위에있어야 한다.
}





class Data{ int x;}
class Data2{int y;}

class DefaultAgrument{//기본형 매개변수로는 참조형 매개변수와 어떻게 다르게 동작하는지 알 수 있음.
    public static void main(String [] args){
        Data d = new Data();
        d.x = 30;
        System.out.println(d.x);
        changevalue(d.x);
        System.out.println(d.x);

    }
    static void changevalue (int x){//static 메서드가 아니라면 쓸데없이 main함수에서 DefaultAgrument의 객체를 생성해줘야 함. 반환타입이 void라 return 생략.
        x=50;
        System.out.println(x);
    }
}


class ReferenceParamEx{//매개변수로 기본형이 아닌 참조형이 주어졌을 때 참조된 클래스의 인스턴스 변수가 변경될 수 있다는 것을 보여줌.
    //즉 메서드내의 지역변수로서 국한되는 것이 아님.
    public static void main(String [] args){
        Data d = new Data();
        Data2 h = new Data2();
        d.x=20;
        System.out.println("변경전:" +d.x);
        change(d);//인자로 기본형 값이 아닌 참조변수를 줌, 즉 참조변수가 갖고 있는 인스턴스주소를 준 것과 마찬가지
        System.out.println("변경후:" +d.x);
        change2(h);
        System.out.println("h.y는?"+h.y);

        
    }
    static void change(Data a){//파라미터(인자)d로부터 받아온 주소는 참조형이기 때문에 Data(클래스명)타입 선언 후 메서드내에서 쓰일 참조변수명은 a로 설정
        //Data d로 해도 관계없고 오히려 가독성이 좋으나 위에서 쓰인 d와 a는 결국 같은 주소를 가르키며 그러한 참조변수를 이용해 인스턴스변수(x)의
        //값을 변경하는 건 결과적으로 같다는 것을 보여주기 위해 a라고 설정. 
        a.x=1000;
        System.out.println("change 실행:" +a.x);
        
    }
    static void change2(Data2 b){//인자로 주어진 참조변수가 가르키는 클래스와 참조형 매개변수가 참조하는 클래스가 같아야 함.
        // 즉 인자로 Data 클래스의 객체주소가 주어지면 참조형 매개변수의 주소도 Data를 가르켜야함.
        b.y=500;
    }

}



class ArrayAgrument{//배열을 메서드의 참조형 매개변수로 접근하는 예제 
    public static void main(String [] args){
        int [] arr = new int[5];
        System.out.println(Arrays.toString(arr));
        arrchange(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void arrchange(int [] agru){
        // 마찬가지로 참조형 매개변수명을 인자의 변수와 동일한 arr로 하는게 맞으나 인자 변수명과 매개변수 변수명과 서로 다르다는 것을 보여주기 위함.
        for (int i = 0; i<agru.length;i++)
            agru[i]=i*10;

    }
}


class Recursive{//재귀호출. 반복문으로 표현가능.
    public static void main(String [] args){
        numbering(100); 
    }
    static int numbering(int i){
        if (i<=0) return 0;
        
        System.out.println(i);
        return numbering(i-1);

    }
}



class Member{// 같은 클래스내의 멤버끼리 참조가 가능하나 클래스멤버는 인스턴스 멤버를 참조할 수 없음을 보여주는 예제
    int iv = 10;
    public static void main(String args[]){}
    static int jv = new Member().iv; // 메서드내에서의 객체 생성과 밖에서랑 좀 다른 형태인듯.

    void instancemethod(){
        System.out.println(iv); //클래스변수 인스턴스 변수 둘다 사용가능
        System.out.println(jv);
    }
    static void classmethod(){
        // System.out.println(iv); 에러발생. iv는 인스턴스 변수기 때문에 클래스 멤버가 참조할 수 없음. 인스턴스(객체)를 생성해야함.
        System.out.println(jv);

    }

    void instancemethod2(){ 
        instancemethod();
        classmethod();// 인스턴스 메서드에서는 클래스 메서드 사용가능
    }
    static void classmethod2(){
        // instancemethod(); 클래스 메소드에서 인스턴스 메소드 사용 불가능.
        classmethod();
    }
    
    static void classmethod3(){
        Member mem = new Member();//다음과 같이 인스턴스 생성 후 사용가능
        mem.instancemethod();
    }
}


class Ttt{
    int x = 30;
    int y = 50;
    void tt(){
        System.out.println(x+y);
    }

    static void tt2(){
        Ttt t1 = new Ttt();
        System.out.println(t1.x);//같은 클래슨 내에서 이렇게 클래스 메소드에서 인스턴스를 생성할바에 tt2 메소드는 그냥 인스턴스 메소드로 선언하는 편이 낫다.

    }
}


class OverLoading{// 메소드의 이름이 같은데도 서로 다른 메소드로서 작동하게끔 중복해서 메소드를 생성하는 것을 오버로딩이라고 한다.
    int add(int x, int y){return x+y;}
    //int add(int a, int b){return a+b;} 매개변수명을 바꾸는 것만으로는 오버로딩할 수 없다.
    long add(long x, long y){return x+y;}// 매개변수의 타입이 다르므로 오버로딩됨.
    int add(int x, int y, int z){return x+y+z;}//매개변수의 갯수가 3개로 첫번째 add메서드와 오버로딩됨.


}
// 같은 클래스내에서 인스턴스변수와 클래스변수를 서로 참조하는 법이 다르고 다른 클래스의 인스턴스 변수와 클래스
// 변수를 참조하는 방법이 다르다. 확실히 짚고 넘어가야 할듯.

class VarArgs{//입력받는 매개변수의 개수를 정확히 알 수 없을때 가독성과 효율을 위해 가변인자를 사용
    public static void main(String [] args){
        String[] strarr1 = {"11","22","33"};
        String[] strarr2 = new String[3];
        System.out.print(Args.concatenate("","100","200","300"));
        System.out.print(Args.concatenate("-",strarr1));
        //System.out.print(Args.concatenate("-",strarr1,strarr2)); 배열을 뒤에 계속 넣게 되면 아래식을 바꾸던지 해야함. 이 코드는 배열을 배열화 시켜 2차원
        //배열이 된 상태나 마찬가지임.

        
    }
    
}


class Args{
    static String concatenate(String first, String... args){//가변인자는 매개변수 중 제일 마지막에 선언해야함.
        String result = "";
        System.out.println(Arrays.toString(args));
        for (String str:args)//가변인자는 메서드 선언 될때 앞의 매개변수 개수를 제외한 나머지 요소들을 배열로 생성하기 때문에 for문을 이용. 위 출력문을 통해서도 알 수 있음.
            result+=str+first;
        return result;
        
    }
}

class D1{
    int x;//생성자가 아무도 없기 때문에 컴파일러가 자동으로 default constructor 생성
}

class D2{
    int value ;
    D2(){} //생성자가 하나라도 있을 시 컴파일러는 추가 생성자 만들지 않음.
}
class Constructor{//생성자는 인스턴스 변수가 생성될때 인스턴스 변수를 초기화 시켜주는 메서드이다.
    static void main(String args[]){
        D1 d1 = new D1();
        D2 d2 = new D2();
        
    }
}

class CarInitialize{
    String color ;
    int year ;
    int wheel ;
    CarInitialize(String a,int b,int c){
        color = a;
        year = b ;
        wheel = c;
    }
    CarInitialize(){}
}

class CarTest{
    public static void main(String args[]){
        CarInitialize c = new CarInitialize("blue",2022,4);
        CarInitialize c1 = new CarInitialize();
        c1.color = "red";
        c1.year = 2018;
        c1.wheel = 5;
        System.out.println("c의 차 (매개변수로 차 정보 전달)"+c.color+c.year+c.wheel);  
        System.out.println("c1의 차 (직접 차 정보 입력)"+c1.color+c1.year+c1.wheel);  
    }
}

class Kim{//생성자내에서 다른 생성자를 호출하기 위해서는 this()를 사용한다.
    String str;
    int num1, num2;
    Kim(){
        this("black",50,100);
    }
    Kim(String str, int num){
        this(str,num,4);
    }
    Kim(String str, int num, int num2){
        this.str= str;//우변의 str은 생성자의 매개변수이자 지역변수, 좌변의 this.str은 인스턴스변수str
        this.num1= num;//여기서 this는 곧 생성된 참조변수의 인스턴스  주소를 뜻함.
        this.num2 = num2;

    }
    public static void main(String [] args){
        Kim j = new Kim();
        Kim k = new Kim("white",55);
        System.out.println("j 의 생성자 "+j.str+j.num1+j.num2);
        System.out.println("k 의 생성자 "+k.str+k.num1+k.num2);

    }
}

class CopyEx{
    String str;
    int num;
    int num1 ;

    CopyEx(String str, int num, int num1){
        this.str = str;
        this. num = num;
        this .num1 = num1;
    }
    CopyEx(CopyEx c){
        str = c.str;
        num = c.num;
        num1 = c.num1;
    }
}

class InstCopy{
    public static void main(String [] args){
        CopyEx example = new CopyEx("hi",50, 100);
        CopyEx example2 = new CopyEx(example);
        System.out.println("example : "+example.str+example.num+example.num1);
        System.out.println("example1 : "+example2.str+example2.num+example2.num1);
        example.num = 300;
        System.out.println("example : "+example.str+example.num+example.num1);
        System.out.println("example1 : "+example2.str+example2.num+example2.num1);//이전의 참조변수끼리 주소를 대입한 형태와는 다름. 인스턴스 변수의
        //값만 서로 공유했을 뿐임. 따라서 example의 인스턴스 변수값을 바꿨어도 example2의 값은 바뀌지 않음.
    }
}

class InitBlock{
    static{
        System.out.println("static Initialize Block");
    }
    {
        System.out.println("Instance Initialize Block");
    }
    public InitBlock(){//public이 붙은 메소드 실행시? default constructor는 public.클래스명(){}이다.
        System.out.println("생성자다");
    }
    public static void main(String [] args){
        InitBlock m = new InitBlock();//인스턴스 생성1
        InitBlock m1 = new InitBlock();//인스턴스 생성2
        //생성자와 인스턴스 초기화블럭 모두 인스턴스 생성시 실행됨. 클래스 초기화 블럭은 처음 1회만 수행된다.
    }
}