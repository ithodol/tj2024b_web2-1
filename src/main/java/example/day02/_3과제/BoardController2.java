package example.day02._3과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/day02/task2")
public class BoardController2 {

    @Autowired BoardDao boardDao; // .getInstance 대신 사용
    private int auto_increment = 1;

    @Autowired
    public BoardController2(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @PostMapping("/board")
    public boolean create(@RequestBody BoardDto boardDto) {
        boardDto.setBno(auto_increment++);
        boardDao.create(boardDto);
        return true;
    }

    @GetMapping("/board")
    public List<BoardDto> readAll() {
        return boardDao.selectAll();
    }

    @GetMapping("/board/view")
    public BoardDto read(@RequestParam int bno) {
        return boardDao.selectByBno(bno);
    }

    @PutMapping("/board")
    public boolean update(@RequestParam int bno, @RequestBody BoardDto boardDto) {
        return boardDao.update(bno, boardDto);
    }

    @DeleteMapping("/board")
    public boolean delete(@RequestParam int bno) {
        return boardDao.delete(bno);
    }
}
