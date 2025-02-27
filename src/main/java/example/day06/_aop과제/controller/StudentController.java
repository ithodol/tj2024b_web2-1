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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component
class StudentControllerAdvice {
    @Before("execution(* example.day06._aop과제.service.StudentService.save(..))&& args(map)")
    public void beforeSave(HashMap<String, Object> map) {
        System.out.println("등록전 :" + map);
    }
    @AfterReturning(value = "execution(* example.day06._aop과제.service.StudentService.save(..))", returning = "result")
    public void afterSave(Object result) {
        System.out.println("등록후: " + result);
    }

    @SneakyThrows
    @Around("execution(* example.day06._aop과제.service.StudentService.save(..)) ")
    public Object aroundSave(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long timeMs = endTime - startTime;
        System.out.println("메소드가 걸린 시간 : " + timeMs + "ms");
        return result;
    }
    @Before("execution(* example.day06._aop과제.service.StudentService.findAll(..))")
    public void beforeFindAll() {
        System.out.println("전체조회 전" );
    }
    @AfterReturning(value = "execution(* example.day06._aop과제.service.StudentService.findAll(..))", returning = "result")
    public void afterFindAll(List<Map<String, Object>> result) {
        System.out.println("전체조회 후: " + result);
    }
    @SneakyThrows
    @Around("execution(* example.day06._aop과제.service.StudentService.findAll(..))")
    public Object aroundFindAll(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long timeMs = endTime - startTime;
        System.out.println("메소드가 걸린 시간 : " + timeMs + "ms");
        return result;
    }
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
