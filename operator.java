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

    }
}