package example.day02._2의존성;

// [1] 서비스 클래스
class SampleService1{
    void method(){
        System.out.println("SampleService1.method");
    }
}
// [2] 컨트롤러 클래스
class SampleController1{
    // 다른 클래스의 메소드를 호출하는 방법, 고전적인 방법1 : 인스턴스 생성
    SampleService1 sampleService1 = new SampleService1();
    public void method(){
        sampleService1.method();
    }
}


public class Example1 {

}
