package example.day06._aop과제.service;

import example.day06._aop과제.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    // [1] 등록
    public int save(HashMap<String, Object> map) {

        return studentMapper.save(map);
    }

    // [2] 전체조회
    public List<Map<String, Object>> findAll() {

        return studentMapper.findAll();
    }
}
