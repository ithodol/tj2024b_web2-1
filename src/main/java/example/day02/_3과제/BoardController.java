package example.day02._3과제;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day02/task1")
public class BoardController {

    /*private final List<Map<String, String>> boardList = new ArrayList<>();

    // 1. 게시글 생성
    @PostMapping("/board")
    public boolean createBoard(@RequestBody Map<String, String> map) {
        String title = map.get("title");
        String content = map.get("content");
        String bno = String.valueOf(boardList.size() + 1);

        Map<String, String> newPost = new HashMap<>();
        newPost.put("bno", bno);
        newPost.put("title", title);
        newPost.put("content", content);

        boardList.add(newPost);
        return true;
    }

    // 2. 전체 글 조회
    @GetMapping("/board")
    public List<Map<String, String>> getAllBoards() {
        System.out.println("BoardController.getAllBoards");
        return boardList;
    }

    // 3. 개별 글 조회
    @GetMapping("/board/view")
    public Map<String, String> getBoardByBno(@RequestParam String bno) {
        System.out.println("BoardController.getBoardByBno");
        return boardList.stream()
                .filter(board -> bno.equals(board.get("bno")))
                .findFirst()
                .orElse(null);
    }

    // 4. 개별 글 수정
    @PutMapping("/board")
    public boolean updateBoard(@RequestBody Map<String, String> map) {
        System.out.println("BoardController.updateBoard");
        System.out.println("map = " + map);

        String bno = map.get("bno");
        String title = map.get("title");
        String content = map.get("content");

        for (Map<String, String> board : boardList) {
            if (bno.equals(board.get("bno"))) {
                board.put("title", title);
                board.put("content", content);
                return true;
            }
        }
        return false;
    }

    // 5. 개별 글 삭제
    @DeleteMapping("/board")
    public boolean deleteBoard(@RequestParam String bno) {
        System.out.println("BoardController.deleteBoard");
        return boardList.removeIf(board -> bno.equals(board.get("bno")));
    }*/

    private final List<BoardDto> boardList = new ArrayList<>();
    private int auto_increment = 1;

    @PostMapping("/board")
    public boolean method1(@RequestBody BoardDto boardDto) {
        boardDto.setBno(auto_increment);
        boardList.add(boardDto);
        auto_increment++;
        return true;
    }

    @GetMapping("/board")
    public List<BoardDto> method2() {
        return boardList;
    }

    @GetMapping("/board/view")
    public BoardDto method3(@RequestParam String bno) {
        for (BoardDto boardDto : boardList) {
            if (boardDto.getBno() == Integer.parseInt(bno)) {
                return boardDto;
            }
        }
        return null;
    }
    @PutMapping("/board")
    public boolean method4(@RequestBody BoardDto boardDto) {
        for (int i = 0; i < boardList.size(); i++) {
            BoardDto boardDto2 = boardList.get(i);
            if (boardDto2.getBno() == boardDto.getBno()) {
                boardList.set(i, boardDto);
                return true;
            }
        }
        return false;
    }
    @DeleteMapping("/board")
    public boolean method5(@RequestParam String bno) {
        for (int i = 0; i < boardList.size(); i++) {
            BoardDto boardDto2 = boardList.get(i);
            if (boardDto2.getBno() == Integer.parseInt(bno)) {
                boardList.remove(i);
                return true;
            }
        }
        return false;
    }
}