package example.day05.model.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO student (name, kor , math ) VALUES (#{name}, #{kor}, #{math})")
    @Options(useGeneratedKeys = true, keyProperty = "sno")
    public int save(@RequestBody HashMap<String, Object> map);


    @Select("""
            <script>
            SELECT * FROM student 
            where 1=1 
            <if test="minKor!= null">
            and kor >= #{minKor}
            </if>
            <if test="minMath!= null">
            and math >= #{minMath}
            </if>
            </script>
            """)
    List<Map<String, Object>> findStudentScore(int minKor, int minMath);


    @Select("SELECT * FROM student ")
    public List<Map<String, Object>> findAll();

    @Update("UPDATE student SET name = #{name}, kor = #{kor}, math = #{math} WHERE sno = #{sno}")
    public int update(@RequestBody HashMap<String, Object> map);

    @Delete("DELETE FROM student WHERE sno = #{sno}")
    public boolean delete(@RequestParam int sno);

    // 여러명 학생 등록하기 , 추상메소드는 {} 없다, 동적 쿼리 = sql 아닌 mybatis 자체 문법
    // 동적 쿼리 : <foreach collection="반복할 리스트 매개변수명" item="반복변수명" seperator="반복사이문자">
    @Insert("""
            <script>
            INSERT INTO student (name, kor, math) VALUES
            <foreach collection="list" item="student" separator=",">
            (#{student.name}, #{student.kor}, #{student.math})
            </foreach>
            </script>
            """)
    public boolean saveAll(List<Map<String, Object>> list);
}
