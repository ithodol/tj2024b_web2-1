package example.day06._aop과제.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO student (name, kor , math ) VALUES (#{name}, #{kor}, #{math})")
    @Options(useGeneratedKeys = true, keyProperty = "sno")
    public int save(@RequestBody HashMap<String, Object> map);

    @Select("SELECT * FROM student ")
    public List<Map<String, Object>> findAll();
}
