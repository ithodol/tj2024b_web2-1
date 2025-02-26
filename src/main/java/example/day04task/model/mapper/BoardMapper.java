package example.day04task.model.mapper;

import example.day04task.model.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("INSERT INTO board (title, content, writer) VALUES (#{title}, #{content}, #{writer})")
    int save(BoardDto boardDto);

    @Select("select * from board")
    public List<BoardDto> findAll();

    @Update("UPDATE board SET title = #{title}, content = #{content} WHERE id = #{id}")
    public int update(BoardDto boardDto);

    @Delete("DELETE FROM board WHERE id = #{bno}")
    public int delete(int bno);
}
