package example.day06.aop;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Aspect
@Component
class Security{
    // 지정한 메소드가 실행되기 전에 아래 메소드가 실행 된다
    // 지정한 메소드는 'TestService2' 클래스의 *(모든메소드) 이면서 (..) 모든 매개변수 타입 * (모든 리턴타입)
        // 즉] 'TestService2' 모든 메소드들은 실행되기전에 'securityCheck()'가 자동 실행된다
    @Before("execution( * TestService2.*(..) )")
    public void securityCheck(){
        System.out.println("메소드 실행 전 (보안) [코로나] 열  체크  + 자기진단 ");
    }
    @After("execution( * TestService2.enter1(..) )")
    public void securityCheckAfter(){
        System.out.println("메소드 실행 종료");
    }
    @Before("execution( * TestService2.enter3(..)) && args(name)")
    public void securityCheck3(String name){
        System.out.println("메소드 실행 전 :  [" + name + "] [코로나 검사 완료!] ");
    }
    @AfterReturning(value = "execution( * TestService2.enter3(..))", returning = "result")
    public void securityCheck4(Object result) {
        System.out.println("메소드 실행 후 :" + result);
    }
    @SneakyThrows
    @Around("execution( * TestService2.enter3(..))")
    public Object timeCheck5(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // proceed() : joinPoint.proceed() 호출시 aspectj runtime이 joinPoint.proceed()를 호출한다.

        long endTime = System.currentTimeMillis();
        long timeMs = endTime - startTime;
        System.out.println("enter3 메소드가 걸린 시간 : " + timeMs + "ms");
        return result;
    }
}

@Service
class TestService2{
    //메소드1
    public void enter1(){
        // 부가기능 제외한 상태  //new Security().securityCheck();// [1]. 일반적인 코드 재사용 방법
        System.out.println("식당 입장"); // 비지니스
    }
    //메소드2
    public void enter2(){
        // 부가기능 제외한 상태 //new Security().securityCheck();// [1]. 일반적인 코드 재사용 방법
        System.out.println("학원 입장"); // 비지니스
    }
    // 메소드3
    public boolean enter3(String name){
        System.out.println("헬스장 입장");
        return true; //
    }
}

@RestController
class TestController2{
    @Autowired private TestService2 testService2;
    @GetMapping("/day06/aop")
    public void aop( ){
        testService2.enter1();
        testService2.enter2();
        testService2.enter3("강호동"); // [2]. securityCheck()가 실행된다
    }
}

@SpringBootApplication
public class Example2 {
    public static void main(String[] args) {
        SpringApplication.run( Example2.class );
    }
}