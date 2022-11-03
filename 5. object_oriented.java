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
    static int width=100;//static을 사용하면
    static int height=70;
}

class CardTest{
    public static void main(String [] args){
        Card[] cardArr = new Card[5];
        cardArr[0].width = 200; // 클래스 변수이기 때문에 인스터스가 생성되지 않아도 에러없이 동작하며 첫번째 참조변수의 두께만 바꿨는데도 참조변수 전체
        //두께가 모두 200으로 바뀐것을 아래 출력문에서 확인할 수 있음.
        //cardArr[0].number = 33;  이 코드는 초기화를 시키지 않았기 때문에 에러발생. number가 인스턴스 변수기 때문인 듯하다.
        
        //클래스변수를 사용하고자 할때는 참조변수.클래스변수의 형태보다는 클래스명.클래스변수의 형태로 사용하는 것이 좋다. 클래스변수를
        //인스턴스 변수로 오해받을 수 있기 때문.
        for (int i =0; i<cardArr.length;i++){
            cardArr[i]=new Card();
            cardArr[i].number = i+1;
            System.out.println("두께 :"+cardArr[i].width+"번호 : "+cardArr[i].number);
        }

    }
}
class Method{
    public static void main(String [] args){
        int add(int x, int y){
            return x+y;
        }
    }
}