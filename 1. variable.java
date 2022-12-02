// chapter2 - variable
import java.util.*;
class Bye {
	public static void main (String[] args) {
		System.out.println("Hello, world."); //화면에 글자를 출력한다

	}
}
class VarEx1 {
	public static void main(String[] args) {
		int year=0;//자료형(data type / int) 선언 후 초기화, 초기화(initialization)란 변수를 선언하고 메모리에 남아있는 혹시 모를 쓰레기 값을 지우기 위해 값을 대입하는 것.
		int age=14;

		System.out.println(year);//=print()
		System.out.println(age);
		year+=2000;
		age+=1;
		System.out.println(year+age);
		System.out.println(age);
		int b=3;
		System.out.println(b);
	}
}

class Constant {
	public static void main(String[] args) {
		final int CONS=30; //상수(constant)는 선언과 동시에 초기화해야만 함, 상수의 이름은 모두 대문자를 '권장'.
		System.out.println(CONS);
	}
}

class String1 { //class 선언시 예약어 사용 불가능(String)
	public static void main(String[] args) {
		String str="java";
		System.out.println(str+8.0);//문자열과 숫자의 연산이 가능한 것을 보여줌. 문자형(char)은 작은 따옴표를 쓰며 문자1개만 저장 가능.
	}
}

class specifier {
	public static void main(String[] args) {
		int age = 14;
		System.out.printf("%d살 입니다%n",age);//printf는 줄바꿈x. \n도 가능하지만 os별 줄바꿈 기능이 다르니 %n이 가장 이상적.
		System.out.printf("%d살 입니다%n",14);//파이썬의 문자열 포매팅 개념. 
		int year = 2000;
		System.out.printf("%d년에는 %d살입니다",year,age);
		byte b=1;
		short s=2;
		char c='A';
		int finger=10;
		int octNum=010;//8진수로 10을 저장한 거 10진수로 8임 %o를 사용하면 8진수로 10을 출력함(이미 8진수로 저장돼있어서)
		int hexNum=0x10;//16진수로 10을 저장한거 10진수로 16임 %x사용하면 16진수로 10을 출력함(이미 16진수로 저장돼있어서)
		//그러니까 %o %x가 10진수를 해당 지시자의 진수로 표현한다는 건데 10진수로 10이 저장돼있으면 각각 12,A를 출력했겠지만 이미 접두사
		int binNum=0b10;
		System.out.printf("b:%d%n",b);
		System.out.printf("%5d%n",finger); //파이썬에도 있는 문자열 공백 처리에 관한 기능
		System.out.printf("%-5d%n",finger);
		System.out.printf("%010d%n",finger);
		System.out.printf("%o, %d %n",octNum, octNum);
		System.out.printf("%x, %d %n",hexNum, hexNum);
		System.out.printf("binNum=%s%n", Integer.toBinaryString(binNum));
		System.out.printf("%c %d",c,(int)c);
		

	}
}


class scanner {
	public static void main(String []args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		String input = scanner.nextLine();
		System.out.println("입력내용(정수변환전) :"+input);
		int num = Integer.parseInt(input);

		Scanner scanner1 = new Scanner(System.in);
		int input1 = scanner.nextInt();

		System.out.println("입력내용(정수변환후) :"+input);
		System.out.printf("입력내용(printf+ 지시자를 이용) : %d",num);
		System.out.printf("입력내용(printf+ 지시자를 이용) : %d",input1);
		
	}
}

class CharToCode {
	public static void main(String [] args) {
		char ch = 'A' ;// char ch=65;와 동일, 문자형에는 유니코드값으로도 문자를 저장 가능함.
		char ch2 = 65;// 컴퓨터에 저장되는 값은 'A'든 65든 이진수로 동일한 값이 저장되지만 출력은 다르게 나온다. 그 이유는 println은 저장된 값을
		int num = (int)ch; // 리터럴?변수의 타입에 맞게 출력하기 때문. int면 2진수를 10진수로, char면 2진수를  유니코드로 출력.

		System.out.printf("문자로 저장 : %c , 유니코드로 저장 : %c %n", ch,ch2);
		System.out.printf("정수로 변환 : %d %n", num);
		System.out.printf("%x, %#x %n", num,num);

	}
}

class Overflow {
	public static void main(String [] args) {
		short sMin=-32768;// short의 데이터 저장공간은 2byte로 부호있는 숫자의 경우 -32768~32767이다.
		// short test=-32769; 다음과 같이 -32768보다 작은 숫자로 변수선언후 초기화시 에러발생. 저장공간을 초과한다는 뜻의 에러메시지.
		short sMax=32767;
		char cMin=0;
		char cMax=65535;
		
		System.out.println("sMin : " + sMin+(sMin-1));
		System.out.println("sMin-1 : " + (short)(sMin-1));//위의 test 변수와는 다르게 다음과 같이 다시 변수선언을 하게 되면 원하는 결과값이 나온다.
		//만약 short가 없다면 sMin-1에 해당하는  -32768이 출력. 왜냐하면 그 숫자를 short 정수형에 저장한 것이 아니기 때문.
		System.out.println("cMax+1 : "+(int)(cMax+1));
		System.out.println("cMax+1 : "+(int)(++cMax));//++의 기능을 잘 모르겠다 
		
	}
}

class FloatEx {
	public static void main(String [] args) {
		float f1 = 9.123456789012345678f;
		float f2 = 1.123456789012345678f;
		double d1 = 3.12345678901234567890;//d 생략가능 기본자료형이라(default data type)
		System.out.printf("f1 출력 : %f %n", f1);
		System.out.printf("f1 자리수 지정 후 출력 : %.10f %n",f1);//%전체자리.소수점아래자리f , 정수부분의 빈자리는 공백, 소수부분은 0으로 채운다.
		System.out.printf("f2 출력 : %f %n",f2);
		System.out.printf("f2 자리수 지정 후 출력 : %-25.10f 공백확인%n",f2);
		System.out.printf("d1 출력 : %f %n",d1);//%f는 기본적으로 6자리까지 출력. 실수형의 타입과 관계없음(double or float)   
		System.out.printf("d1 자리수 지정 후 출력 : %25.20f %n",d1);
		int oct= 10;
		int hex= 10;

		System.out.printf("===========oct : %o, %x %n",oct,hex);
		System.out.printf("f : %f %n",f1);
		System.out.printf("f : %24.20f %n",f1);
	}
}

class Practice {
	public static void main(String [] args) {
		int i=126, j=129;
		byte b=(byte)i;//캐스팅에 따른 오버플로우??
		byte c=(byte)j;//byte형은 1byte의 데이터만 저장할 수 있다. 즉 2의8승 범위로 보면 -128~127사이의 숫자만 저장 가능
		System.out.printf(" i : %d j : %d %n", b,c);

		int width = 20;
		int height = 10;
		int triangle = (width*height)/2;
		int square = width*height;// 왜 상수를 써야하는지 잘 모르겠다. 어차피 변수 새로 지정하나 상수쓰나 똑같은데
		System.out.printf("triangle : %d , square : %d %n",triangle, square);
		float pi = 3;
		long num = 2*10000000000l;//접미사를 넣어도 되고 안 넣어도 되는데 문제가 될땐 접미사를 넣지 않았을때 정수형의 리터럴 
		//기본자료형(int)의 값보다 큰 값이 리터럴에 들어왔을때 오버플로우가 발생.
		//int num = 100L; 과 같이 변수의 저장범위보다 리터럴의 저장범위가 커서는 안됨. ex) int > long, float > double.
		System.out.printf("실수 : %f 정수long : %d ",pi,num); 
		boolean t=true;
		System.out.println("bool 타입"+t);
		int test1 = 'A';
		char test2 = 66;
		System.out.printf("%d %c %n",test1,test2);//다만 출력할때 test1을  %c로, test2를 %d로 출력하지는 못한다. 단순히 유니코드를 이진수로 변환해서 저장한다는
		//공통점이 있다는 것 뿐
		
		
	}
}

class CastingEx1 {
	public static void main(String [] args){
		double pi = 3.14;
		float f=9.12345678901234567890f;
		double d=9.12345678901234567890;
		int num =(int)pi;
		System.out.println(num+","+pi);//pi값은 변하지않았고 num에는 정수형 저장범위인 소수점이 없는 정수형태만 저장된 모습
		System.out.printf("%.30f %n",f);
		System.out.printf("%.30f %n",d);

		char ch = (char)1000;
		System.out.println(ch);
		byte b=(byte)1000;//byte b = 1000;이면 에러발생, byte는 4bit만 저장가능 정수범위로보면 -128~127
		System.out.println(b);
		long c = 100l; // int c = 1000l; 안된다 float f = 3.14d;와 같은 격
	}
}
		
