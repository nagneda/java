import static java.lang.Integer.*;
import static java.lang.Math.random;
import static java.lang.System.out;

class Parents{//조상클래스, 부모클래스, 슈퍼클래스
    int x;
    void sleep(){
        System.out.println("sleep");
    }
}

class Child extends Parents{//자손클래스, 자식클래스, 서브클래스   Parents클래스를 상속받은 Child클래스는 Parents클래스의 모든 멤버를 공유(생성자,초기화블럭 제외)
    void play(){
        System.out.println("play");
        sleep();//Parents 클래스를 상속받아 인스턴스 메서드인 sleep를 사용가능, 상속받게되면 별도의 인스턴스 생성없어도 됨.
        
    }
}


class Child2 extends Parents{// 상위 클래스에서 여러 하위클래스로 상속해줄 순 있어도 하위클래스가 2개이상의 상위 클래스에게 상속받지는 못한다.
    void fight(){
        System.out.println("fight");
        sleep();
    }
    
}

class GrandChild extends Child{//Child 의 직접 자손이기도 하면서 Parents의 간접 자손이기도 함.
    void eat(){
        System.out.println("eat");
        play();//Child클래스의 play메서드를 상속받음.
        sleep();
    }
}

class ChildTest{
    public static void main( String [] args){
        GrandChild b= new GrandChild();
        b.eat();
        b.x = 5;

    }
}

class Tv11{
    boolean power;
    int channel;

    void power(){power = !power;};
    void channelup(){++channel;};
    void channeldown(){--channel;};
    static void hello(){System.out.println("hello");}
}

class CaptionTv extends Tv11{
    boolean caption;
    void displayCaption(String text){
        if (caption){
            System.out.println(text);
        }
    }
}

class CaptionTvtest{
    public static void main(String [] args){
        CaptionTv ctv = new CaptionTv(); // captiontv 클래스의 참조변수 ctv와 인스턴스 생성
        ctv. channel = 100;// 현재 이 클래스에서는 당연히 참조변수를 통해 인스턴스에 접근하는 게 맞음. 위 메소드들과 변수들이 모두 인스턴스 멤버기 때문.
        ctv. power = true; // 그러나 중요한 것은 CaptionTv의 인스턴스를 생성했는데 Tv11클래스의 멤버들을 사용할 수 있다는 것이다.

        Tv11.hello(); //클래스 멤버(메서드,변수)에는 이렇게 접근하는게 정석이고
        ctv.hello(); //이렇게 해도 관계는 없으나 인스턴스 멤버(메서드,변수)로의 오해가능성이 있다.
        ctv. displayCaption("hi");// caption = true여야 String이 출력되게끔 인스턴스메소드를 설정해놓음.
        ctv. caption = true;
        ctv. displayCaption("hi");
        ctv.channelup();
        System.out.println("curren channel : "+ctv.channel);

    }
}
//쉽게 생각하면 상속한다는 것은 상속하고자하는 클래스(Parents)의 멤버가 새로 생성하는 클래스(Child)안에 똑같이 생성된다고 보면 된다. 그러나 이때문에 클래스,인스턴스
//멤버들의 접근 방법과 생성자 등과도 헷갈리게 되는데 개념을 확실히 정리해야할 필요가 있다.


class Overriding1{// 오버로딩은 같은 클래스내에서 같은 메서드명을 사용할때 매개변수가 달라야하는 조건이 있었으며 
    //오버라이딩은 조상클래스를 상속받은 자손클래스에서 선언부가 완전히 같은 메서드를 작성하는 것. 이때 실행은 자손클래스의 메서드가 실행된다.
    void parents(){System.out.println("오버라이딩1");}
}
class Overriding2 extends Overriding1{
    void parents(){System.out.println("오버라이딩2 메서드");}//오버라이딩 , 조상클래스(Overriding1)의 partents메서드와 같은 메서드명을 사용.
    void parents(int i){}//오버로딩

    void child(){}
    void child(int i){}//오버로딩
}

class Overridingtest{//Overriding2 클래스를 상속받는 것이 아닌 포함시킴. 여기서 포함시킨다는 뜻은 포함시키고자 하는 클래스의 인스턴스를 생성하는 것을 말함.
    public static void main(String [] args){
        Overriding2 over = new Overriding2();//overridign2를 상속하지않고 인스턴스를 생성시키며 '포함'시킴
        over.parents();// 오버라이딩2클래스의 parents메소드가 실행된다.
    }
}

class Overridigntest1 extends Overriding2{//Overriding2 클래스를 상속받음.
    public static void main(String [] args){
        // parents();  이 코드를 실행하기 위해서는 결국엔 static 메서드이기 때문에 참조변수를 선언해야함.
    }
}
//내가 사용하고자 하는 메인클래스가 아닌 클래스끼리는 상속시키고 내 클래스에서는 포함시켜서 사용하는게 나은가?


class SuperTest{//super는 조상클래스로부터 상속받은 멤버를 참조하기 위한 참조변수이며 this는 자기 자신의 클래스의 멤버를 구분하는데에 차이가 있다.
    int x=20;
}
class Super extends SuperTest{
    
     void super1(){
        System.out.println("this x : "+this.x);
        System.out.println("super x : "+super.x);
    }
}
class Super2 extends SuperTest{
    int x = 30;
    void super1(){
    
       System.out.println("this x : "+this.x);//여기서 this.x는 현재클래스의 x=30을 가르킨다.
       System.out.println("super x : "+super.x);// 조상클래스  SuperTest의 x=20을 가르킨다.
       System.out.println("none x? : "+x);// 여기서 x는 인스턴스변수 x=30을 가르킴.
   }
}
class SuperGo{
    public static void main(String [] args){
        Super s = new Super();
        Super2 d = new Super2();
        s.super1();
        d.super1();
    }
}

class PackageTest{
    public static void main(String [] args){
        System.out.println("Hello World");
    }
}

//import static java.lang.Integer.*;
//import static java.lang.Math.random;
//import static java.lang.System.out; 다음과 같은 import구문을 맨위에 선언했으니 참고.
class ImportTest{
    
    public static void main(String [] args){
        out.println(random());
        //System.out.pritnln(Math.random());  import문은 패키지명 생략을 가능케하고  static import문은 호출시 클래스의 이름조차 생략 가능하게함.
    }
}

 
