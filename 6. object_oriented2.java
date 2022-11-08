class Parents{//조상클래스, 부모클래스, 슈퍼클래스
    int x;
    void sleep(){
        System.out.println("sleep");
    }
}

class Child extends Parents{//자손클래스, 자식클래스, 서브클래스   Parents클래스를 상속받은 Child클래스는 Parents클래스의 모든 멤버를 공유(생성자,초기화블럭 제외)
    void play(){
        System.out.println("play");
        sleep();
        
    }
}


class Child2 extends Parents{
    void fight(){
        System.out.println("fight");
        sleep();
    }
    
}

class GrandChild extends Child{//Child 의 직접 자손이기도 하면서 Parents의 간접 자손이기도 함.
    void eat(){
        System.out.println("eat");
        play();
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

        Tv11.hello(); //클래스 변수에는 이렇게 접근하는게 정석이고
        ctv.hello(); //이렇게 해도 관계는 없으나 인스턴스 멤버로의 오해가능성이 있다.
        ctv. displayCaption("hi");// caption = true여야 String이 출력되게끔 인스턴스메소드를 설정해놓음.
        ctv. caption = true;
        ctv. displayCaption("hi");
        ctv.channelup();
        System.out.println("curren channel : "+ctv.channel);

    }
}
//쉽게 생각하면 상속한다는 것은 상속받고자하는 클래스의 멤버가 새로 생성하는 클래스안에 똑같이 생성된다고 보면 된다. 그러나 이때문에 클래스,인스턴스
//멤버들의 접근 방법과 생성자 등과도 헷갈리게 되는데 개념을 확시맇 정리해야할 필요가 있다.