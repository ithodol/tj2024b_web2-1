package example.day05.controller;

import example.day05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day05/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // [1] 등록
    @PostMapping("")
    public int save(@RequestBody HashMap<String, Object> map) {
        System.out.println("StudentController.save");
        System.out.println("map = " + map);
        return studentService.save(map);
    }

    // [2] 전체조회
    @GetMapping("")
    public List<Map<String, Object>> findAll() {
        System.out.println("StudentController.findAll");
        return studentService.findAll();
    }

    // [3] 수정
    @PutMapping("")
    public int update(@RequestBody Map<String, Object> map) {
        System.out.println("StudentController.update");
        System.out.println("map = " + map);
        return studentService.update(map);
    }

    // [4] 삭제
    @DeleteMapping("")
    public boolean delete(@RequestParam int sno) {
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return studentService.delete(sno);
    }
    @GetMapping("/findscore")
    public List<Map<String, Object>> findStudentScore(
        @RequestParam int minKor,
        @RequestParam int minMath){
        return studentService.findStudentScore(minKor, minMath);
    }
    @PostMapping("/save/all")
    public boolean saveAll(@RequestBody List<Map<String, Object>> list) {
        System.out.println("StudentController.saveAll");
        System.out.println("list = " + list);
        return studentService.saveAll(list)  ;
    }

    }

