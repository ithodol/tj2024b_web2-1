package example.day06._aop과제.controller;

import example.day06._aop과제.service.StudentService;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component
class StudentControllerAdvice {
    @Around("execution(* example.day06._aop과제.service.StudentService.*(..))")
    public Object aroundFindAll(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[실행메소드]" + joinPoint.getSignature());
        System.out.println("[매개변수] : " + Arrays.toString(joinPoint.getArgs())); // Arrays.toString(배열변수) : 배열 출력을 주소값이 아닌 값으로 반환
        Object result = joinPoint.proceed();
        System.out.println("[반환값] : " + result);
        return result;
    }
    /*
    @Before("execution(* example.day06._aop과제.service.StudentService.save(..))&& args(map)")
    public void beforeSave(HashMap<String, Object> map) {
        System.out.println("매개변수 :" + map);
    }
    @AfterReturning(value = "execution(* example.day06._aop과제.service.StudentService.*(..))", returning = "result")
    public void afterSave(Object result) {
        System.out.println("반환값 : " + result);
    }

    @SneakyThrows
    @Around("execution(* example.day06._aop과제.service.StudentService.*(..)) ")
    public Object aroundSave(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint.getArgs());        // 지정한 메소드의 매개변수 반환(배열타입)
        System.out.println(joinPoint.getSignature());   // 지정한 메소드 시그니처 반환(메서드 이름, 반환 타입, 클래스 정보 등)
        System.out.println(joinPoint.getTarget());      // 지정한 메소드를 실행한 객체 (StudentService 객체) 
        System.out.println(joinPoint.getThis());

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long timeMs = endTime - startTime;
        System.out.println("메소드가 걸린 시간 : " + timeMs + "ms");
        return result;
    }

    @Before("execution(* example.day06._aop과제.service.StudentService.findAll(..))")
    public void beforeFindAll() {
        System.out.println("매개변수" );
    }*/
    
}
@RestController
@RequestMapping("/day06/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("")
    public int save(@RequestBody HashMap<String, Object> map) {

        return studentService.save(map);
    }

    // [2] 전체조회
    @GetMapping("")
    public List<Map<String, Object>> findAll() {

        return studentService.findAll();
    }
}
