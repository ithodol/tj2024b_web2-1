package example.day01._3과제;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping( "/day01/task" )
public class BoardController {
    @PostMapping("/board")
    @ResponseBody
    public boolean doPost1() {
        return true;
    }
    @GetMapping("/board")
    @ResponseBody
    public List<Map<String, String>> doGet1() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "제목1");
        list.add( map1 );
        Map<String, String> map2 = new HashMap<>();
        map2.put("bno" , "2" );
        map2.put("btitle" , "제목2");
        list.add( map2 );
        return list;
    }
    @GetMapping("/board/view")
    @ResponseBody
    public Map<String, String> dogGet2() {
        Map<String,String> map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "제목1");
        return map1;
    }
    @PutMapping("/board")
    @ResponseBody
    public boolean dogPut() {
        return true;
    }
    @DeleteMapping("/board")
    @ResponseBody
    public int dogDelete() {
        return 3;
    }

}
