package example.day02._1RESTparam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/day02")
public class RestController3 {
    // [1] HTTP servlet 내장 객체 : HTTPServletRequest
    @RequestMapping("/doget1")
    public void method1(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        System.out.println("RestController3.method1");

        String name = req.getParameter("name");
        System.out.println("name : " + name);

        resp.setContentType("application/json");
        resp.getWriter().write("true" );
    }
    @GetMapping("/doget2")
    // @RequestParam : HTTP request(요청)의 URL 쿼리스트링 매개변수를 매핑하는 어노테이션
    // 1. @RequestParam( name = "queryString 매개변수명") 타입 매개변수명
    // => queryString 매개변수명 과 함수 매개변수명이 동일하면 @RequestParam 생략 가능
    // 2. (name = "name", defaultValue = "defaultValue") 타입 매개변수명
    // => 만약에 queryString 매핑할 매개변수명 없다면 기본값으로 설정
    // 3. (required = true) 
    // => 기본값이 true하며, 쿼리스트링 매개변수 필수 여부 설정, 만약에 쿼리스트링 매개변수가 없으면 400 응답
    public boolean method2(@RequestParam(name = "name" , defaultValue="홍길동", required = false) String name) {
        System.out.println("RestController3.method2");
        System.out.println("name = " + name);
        return true; // @Responsebody 사용했을때 자동으로 response 를 'application/json' 타입으로 응답
    }
    @GetMapping("/doget3")
    public int method3(@RequestParam(name = "name") String name,
                       @RequestParam(name = "age") int age) {
        System.out.println("RestController3.method3");
        System.out.println("name = " + name + ", age = " + age);
        return 3;
    }
    @GetMapping("/doget4")
    public String method4(@RequestParam Map<String, String> map) {
        System.out.println("RestController3.method4");
        System.out.println("map = " + map);
        return "hello";
    }
    // DTO를 이용한 쿼리스트링 매개변수 매핑
    // ModelAttribute vs        @RequestParam
    // 생략가능(기본값)            명시해야한다
    // 개발자가 만든타입(DTO)       공식적인 타입만 지원 : 기본타입+List, Map, String
    // 쿼리스트링 / form 첨부파일    쿼리스트링 지원

    // + DTO 사용시 쿼리스트링 매개변수와 멤버변수명이 동일 해야한다.
    @GetMapping("/doget5")
    public boolean method5( MemberDto memberDto) { // 여러개의 매개변수를 하나의 DTO으로 받을 수 있다 // @RequestParam 생략시 modelAttribute 자동으로
    System.out.println("RestController3.method5");
    System.out.println("memberDto = " + memberDto);
    return true;
    }
    }
