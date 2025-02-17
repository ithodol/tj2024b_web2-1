package example.day01._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping( "/day01" )
public class RestController2 {
    // [1] @ResponseBody
    // - 메소드의 반환(return) 값을 HTTP 응답 본문(Body) 으로  application/json 형식으로 한다.
    @GetMapping("/doget3")
    @ResponseBody // 자동으로 함수 return 값을 HTTP Response 값을 application/json 타입으로 응답
    public int doGet3() {
        return 100;
    }

    @GetMapping("/doget4")
    @ResponseBody
    public String doGet4() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/doget5")
    @ResponseBody
    public Map<String, String> dogGt5() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "강호동");
        return map;
    }

    @GetMapping("/doget6")
    @ResponseBody
    public boolean doGet6() {
        return true;
    }
}
