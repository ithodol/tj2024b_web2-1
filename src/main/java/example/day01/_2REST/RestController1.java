package example.day01._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // 해당 클래스는 Controller 임을 알림 (어노테이션 기능을 주입)
// 1. 해당 클래스는 spring 컨테이너(메모리)에 bean(객체) 등록한다.
// 2. Spring Controller 는 기본적으로 HTTP 서블릿 지원한다. 별도로 상속 받지 않는다
public class RestController1 {

    @RequestMapping(value = "/day01/doget", method =  RequestMethod.GET)
    public void doGet() {
        System.out.println("day01 doGet executed");
    }
    @RequestMapping(value = "/day01/dopost", method = RequestMethod.POST)
    public void doPost() {
        System.out.println("day01 doPost executed");
    }
    @RequestMapping(value = "/day01/doput", method = RequestMethod.PUT)
    public void doPut() {
        System.out.println("day01 doPut executed");
    }
    @RequestMapping(value = "/day01/dodelete", method = RequestMethod.DELETE)
    public void doDelete() {
        System.out.println("day01 doDelete executed");
    }
    @GetMapping("/day01/doget2")
    public void doGET2() {
        System.out.println("day01 doGet2 executed");
    }

    @PostMapping("/day01/dopost2")
    public void doPost2() {
        System.out.println("day01 doPost2 executed");
    }
    @PutMapping("/day01/doput2")
    public void doPut2() {
        System.out.println("day01 doPut2 executed");
    }
    @DeleteMapping("/day01/dodelete2")
    public void doDelete2() {
        System.out.println("day01 doDelete2 executed");
    }
}

