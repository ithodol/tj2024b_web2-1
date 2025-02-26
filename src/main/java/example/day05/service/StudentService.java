package example.day05.service;

import example.day05.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired private StudentMapper studentMapper;

    // [1] 등록
    public int save( HashMap< String , Object> map ){
        System.out.println("StudentService.save");
        System.out.println("map = " + map);
        return studentMapper.save( map );
    }
    // [2] 전체조회
    public List <Map<String , Object >> findAll(){
        System.out.println("StudentService.findAll");
        return studentMapper.findAll();
    }
    // [3] 수정
    public int update( Map<String, Object> map ){
        System.out.println("StudentService.update");
        System.out.println("map = " + map);
        return studentMapper.update((HashMap<String, Object>) map);
    }
    // [4] 삭제
    public boolean delete( int sno ){
        System.out.println("StudentService.delete");
        System.out.println("sno = " + sno);
        return studentMapper.delete( sno );
    }

    // [5] 특정 점수 이상 학생 조회
    public List<Map<String, Object>> findStudentScore(int minKor, int minMath){
        return studentMapper.findStudentScore(minKor, minMath);
    }

    public boolean saveAll(List<Map<String, Object>> list) {
        System.out.println("StudentService.saveAll");
        System.out.println("list = " + list);
        return studentMapper.saveAll(list);
    }
}
