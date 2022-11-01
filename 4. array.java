import java.util.*;
class Array{
    public static void main(String [] args){
        int [] score = new int[5];//5개의 요소를 가진 배열의 선언(좌변) 및 생성(우변). 요소의 default value = 0
        score[3]=20;
        for (int i = 0; i<=4; i++) System.out.printf("%d %n",score[i]); //인덱스안에는 변수나 상수 혹은 수식도 가능. 결과로써 인덱스 번호 범위 내의
        //정수라면 가능하다. python과 동일하게 뭐 score[len(score-1)]이런식
        int num = score[3];
        System.out.println("num :" + num);
        int arr[] = new int[0]; //빈 배열 선언가능 python arr=[]와 동일?
        System.out.println("score배열의 길이:"+score.length);//배열의 길이를 나타내는 메소드 > 배열이름.length , 배열의 길이는 변경 불가능
        int arr2[] = new int[]{10,20,30,40,50}; //배열의 선언,생성,초기화를 동시에. int[]안의 배열길이는 생략해도 된다.
        int arr3[] ={1,2,3,4,5}; //new int[] 생략가능. 파이썬의 배열생성과 비슷한 모습. 자료형 선언과 변수명 뒤의 []만 추가된 것. 
        int arr4[];
        //arr4 ={1,2,3,4,5,6}; 다음과 같이 선언과 생성을 따로 할 경우에는 new int[] 생략불가
        arr4 = new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString(arr4)+"%n참조변수 arr4 출력 : "+arr4); //배열의 전체요소를 출력하는 Arrays.toString(배열명) 사용시 inport java.util.*; 작성해야함
        //참조변수를 직접 출력하는 것은 마치 python에서 map같은 함수를 썼을때 그 자체를 출력하면 반복가능한 요소의 데이터의 형태로 이상한 값이
        //출력되는 것과 동일한 원리. list화를 시켜줘야 했었음.
        char chararr[] = {'a','b','c','d'};
        System.out.println(chararr+" to String 출력 :"+Arrays.toString(chararr));
        //파이썬과 다르게 java에서는 배열의 크기를 정해놓고 사용해야 하며 부득이하게 배열의 길이를 늘리기 위해서는 더 큰 배열을 생성 후 기존배열을
        //복사하는 과정을 거쳐야만 한다.
        int origin[] = {1,2,3,4,5};
        int copy[] = new int[(origin.length)*2];//기존 배열보다 2배 더 큰 배열 copy 생성
        for (int i=0 ; i<origin.length; i++)
            copy[i]=origin[i];
        origin = copy;//두 참조변수가 같은 배열(copy)를 가르키게 됨.
        origin[1]=30;
        copy[2] = 50;
        System.out.println("copy 배열 출력 : "+Arrays.toString(copy)+"origin 배열 출력 : "+Arrays.toString(origin)); // 변경한 값이 같이 출력됨.
    }
}

class Test{
    public static void main(String[] args){
        float f = (float)1234;
        byte b = 35;
        byte c = 50;
        long l = (byte)10000;
        System.out.println(l);
        System.out.println(b+c);
        char chr = 65;
        for (int i =65;i<=75;i++)
            System.out.println((char)i);
        long num =35l;
        String str = "abc";
        String str2 = "abc";
        String str3 = "abc";
        System.out.printf("str == str2 : %b %n str == \"abc\" : %b %n",str==str2,str3=="abc");
        System.out.println(str.equals("abc"));
        char al = 'a';
        int al2 = 97;
        System.out.println((int)al+"//"+(char)al2);
        System.out.printf("%c ++ %d",(char)al2,(int)al);
        Scanner scanner = new Scanner(System.in);
        int aa=5, bb=0;
        System.out.println(aa == 5 && ++bb==0);
        System.out.printf(aa+""+bb);
        int h = 0XAB;
        System.out.printf(~aa+""+(aa<<2)+"%n");
        System.out.println((35^57)^57);

    }
}
