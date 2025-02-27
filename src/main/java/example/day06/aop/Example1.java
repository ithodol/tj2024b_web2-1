package example.day06.aop;

//============================ AOP 없이 구현된 코드 ===========================
class TestService {
    // 메소드1
    public void enter1() {
        System.out.println("[코로나] 온도 체크");
        System.out.println("식당 입장");
    }
    // 메소드2
    public void enter2() {
        System.out.println("[코로나] 온도 체크");
        System.out.println("학원 입장");
    }
}

public class Example1 {
    public static void main(String[] args) {
        TestService ts = new TestService();
        ts.enter1();
        ts.enter2();
    }
    
}
