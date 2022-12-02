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
        System.out.println(Arrays.toString(arr4)+"%n참조변수 arr4 출력 : "+arr4); //배열의 전체요소를 출력하는 Arrays.toString(배열명) 사용시 import java.util.*; 작성해야함
        //참조변수를 직접 출력하는 것은 마치 python에서 map같은 함수를 썼을때 그 자체를 출력하면 반복가능한 요소의 데이터의 형태로 이상한 값이
        //출력되는 것과 동일한 원리. list화를 시켜줘야 했었음.
        char chararr[] = {'a','b','c','d'};
        System.out.println(chararr+" to String 출력 :"+Arrays.toString(chararr));
        
    }
}


class ArrayEx1{
    public static void main(String args []){
        int[] arr = {1,2,3,4,5};
        for (int tmp : arr)
            System.out.println(tmp);
        System.out.println(Arrays.toString(arr));
    }


}

class ArrayCopy{
    public static void main(String [] args){
        //파이썬과 다르게 java에서는 배열의 크기를 정해놓고 사용해야 하며 부득이하게 배열의 길이를 늘리기 위해서는 더 큰 배열을 생성 후 기존배열을
        //복사하는 과정을 거쳐야만 한다.
        int origin[] = {1,2,3,4,5};
        int copy[] = new int[(origin.length)*2];//기존 배열보다 2배 더 큰 배열 copy 생성
        for (int i=0 ; i<origin.length; i++)
            copy[i]=origin[i];
        System.out.println("copy: " +Arrays.toString(copy));
        System.out.println("origin: "+Arrays.toString(origin));
        origin = copy;//두 참조변수가 같은 배열(copy)를 가르키게 됨.
        origin[1]=30;
        copy[2] = 50;
        System.out.println("copy 배열 출력 : "+Arrays.toString(copy)+"origin 배열 출력 : "+Arrays.toString(origin)); // 변경한 값이 같이 출력됨.
        // origin배열의 길이가 늘어난 것이 아니라 copy배열의 객체 주솔르 참고해서 같은 배열을 가르키고 있는 것 뿐임.
        char [] abc = {'a','b','c','d'};
        char [] num = {'1','2','3','4','5','6'};
        char [] newarr = new char[abc.length+num.length];//abc와 num 요소 모두 저장할 수 있는 배열 생성
        System.arraycopy(abc,0,newarr,0,abc.length);//arraycopy(옮기려는 배열,그 배열의 시작 인덱스,저장되는 배열,그 배열의 시작 인덱스,몇개)
        System.out.println(newarr);
        System.arraycopy(num,0,newarr,0,num.length);
        System.out.println(newarr);
        System.arraycopy(abc,0,newarr,num.length,abc.length);
        System.out.println(newarr);
    }
}

class ScoreCheck{
    public static void main(String []args){
        int[] score = {80,100,67,78,98,69,46,77};
        int max = score[0], min = score[0];
        for (int i=1; i<score.length;i++){//초기화를 score[0]으로 했으니 첫번째 요소부터 검사하기 위해 i=1로 초기화함.
            if (score[i]>max) max=score[i];
            else if  (score[i]<min) min = score[i];
        
        }System.out.printf("최소값 : %5d \t 최대값 : %5d %n",min,max);
    }
}

class Lotto{
    public static void main(String []args){
        int [] arr = new int[45];
        int i = 0;
        for (i=0;i<arr.length;i++)
            arr[i]=i+1; // 1~45번까지 저장
        int temp = 0;
        int lot = 0;
        for(i=0;i<=6;i++){
            lot = (int)(Math.random()*45);//0~44가 저장 (인덱스번호) , math.random()이 0~1사이의 난수를 생성.
            //arr의 값들을 랜덤으로 섞는 과정
            temp = arr[i]; //arr[i]의 값을 임시저장
            arr[i] = arr[lot]; 
            arr [lot] = temp;
        }System.out.println(Arrays.toString(arr));
        
        
        //불연속적인 수 배열에 담기.
        int [] ran = {4,2,-5,100,50,25-90};
        int [] newrr = new int[15];

        for (i=0;i<newrr.length;i++){
            int imsi = (int)(Math.random()*ran.length);//0~6 인덱스 번호 저장. ran의 요소를 빼오기 위한 인덱스
            newrr[i]=ran[imsi];
        }
        System.out.println("불연속적인 수 newrr 출력 : "+Arrays.toString(newrr));
    }
}

class StringArray{
    public static void main(String [] args){
        String [] str = {"1234","5678","9012"};
        System.out.println(str); 
        String tmp = str[1].substring(0,4);// substring은 파이썬의 슬라이싱 개념과 동일.
        System.out.println(tmp);

        char [] chr = {'a','b','c','d'};
        String sentence = "hello";
        System.out.println(Arrays.toString(chr)+sentence);
        System.out.println(Arrays.toString(sentence.toCharArray()));
        System.out.println(new String(chr));
        //char 타입의 배열은 원래 그냥 출력이 가능하기 때문에 문자열과 문자형을 구분할 수 없다(int타입과 다르게 참조변수(배열명) 그 자체로 출력시 요소들이 구분자
        // 없이 붙어서 출력되기 때문) 그래서 Arrays.toString(char 타입 배열)을 이용하여 구분할 수 있다. char array에 문자열을 넣으면 에러발생. 테스트해보기바람.
        System.out.println("args 길이 :"+args.length);
        for (int i=0;i<args.length;i++)System.out.println(args[i]);// cmd를 이용해 java 컴파일러 및 인터프리터로 실행할때에 클래스 이름 다음의 사용자의
        //입력을 받아서 처리해줌. main메서드의 string []args가 이것을 뜻함. String타입의 args 배열이라는 뜻.
    }//컴퓨터 프로그래밍에서 대부분 공통적인 사항은 띄어쓰기를 구분자로 인식한다는 것. 파일명이나 경로등을 입력할때 띄어쓰기(공백)가 포함돼있다면 큰 따옴표로 묶어줘야한다.
}
        // string자료형.toCharArray(), new String(char배열)
class MultiArray{
    public static void main(String[] args){
        //다차원 배열은 DB의 테이블과 비슷한 모양이라고 생각하면 편하다.
        int [][] arr = {
                            {5,3,4},
                            {4,2,1},
                            {7,8,9},
                            {1,2,3}
                        };
      
        for (int i = 0; i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                System.out.println(arr[i][j]);
            }
        }
    }
}

class MultiArray1{
    public static void main(String[] args){
        final int SIZE = 10;
        int x = 0, y = 0;
        char[][] board = new char[SIZE][SIZE];
        byte[][] shipBoard = {
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,1,0,0,0},
            {0,0,1,0,1,0,0,0,0},
            {1,0,0,1,0,1,0,0,1},
            {0,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,1,1,1,0},
            {0,0,1,0,0,1,0,1,0},
            {0,1,0,0,0,0,0,0,0}
        };
        for (int i = 1; i<SIZE;i++){
            board[0][i]=board[i][0]=(char)(i+'0');
        }
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("좌표를 입력하세요(종료 : 00)");
            String xy = scanner.nextLine();

            if (xy.length()==2){
                x=xy.charAt(0)-'0';
                y=xy.charAt(1)-'0';
                if (x==0&&y==0)break;
            }
            else if (xy.length()!=2 || x<=0 || x>=SIZE || y<=0 || y>=SIZE){
                System.out.println("다시입력하세요");
                continue;
                
            }
            board[x][y] = shipBoard[x-1][y-1] == 1? 'O':'X';
            for(int j=0;j<SIZE;j++){
                System.out.println(board[j]);
            }
        }
 
    }
}

class MultiArray2{
    public static void main(String[] args){
    char [] chr = new char[6];
    String []sen = new String[10];
    for (int i=0; i<chr.length;i++){
        System.out.println(chr[i]);
    }//char배열의 기본값은 공백.
    for (int i=0; i<sen.length;i++){
        System.out.println(sen[i]);
    }//String배열의 기본값은 null 
    }
}

class Practice1{
    public static void main(String [] args){
        int[] randomarr = new int[5];
        int tmp = 0, count =0;

        //1~10사이의 난수를 가진 길이5의 randomarr배열 초기화 for문
        for ( int i = 0; i<randomarr.length; i++)
            randomarr[i] = (int)(Math.random()*10+1);
        System.out.println("배열정리전 : "+Arrays.toString(randomarr));
        while (true){
            count =0 ;
            for (int j = 0; j<randomarr.length-1;j++){//오름차순으로 정리하기 위한 for문, 아래 if문의 조건때문에 반복범위가 length-1임.
                if (randomarr[j] > randomarr[j+1]){//현재 인덱스번호의 요소가 다음 요소보다 값이 크면 다음 요소랑 현재요소의 값을 변경.
                    tmp=randomarr[j];
                    randomarr[j]=randomarr[j+1];
                    randomarr[j+1]=tmp;
                    count+=1;
                }
            
            }
            if (count ==0) break; // 인덱스0번부터 끝까지 단 한번의 자리 교체도 일어나지 않았다면 count는 0일 것이고 배열이 정리된 것이므로 break.
        }
        System.out.println("배열정리후 : "+Arrays.toString(randomarr));
        
    }
}
class Shuffle{
    public static void main(String [] args){
        
        int [] arr = new int[10];

        for (int i =0; i<arr.length;i++)
            arr[i]=i+1;// 1~10으로 순서대로 arr배열을 초기화
        System.out.println("arr배열 : "+Arrays.toString(arr));

        for (int j = 0; j<arr.length;j++){
            int tmp = (int)(Math.random()*10);//0~9 사이의 난수 생성 (arr 인덱스 용도)
            int num1 = arr[tmp];
            arr[tmp] = arr[j];
            arr[j] = num1;
            
        }
        System.out.println("셔플 후 arr : " +Arrays.toString(arr)); 
    }
}