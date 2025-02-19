package example.day02._3과제;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoardDao {
    private final ArrayList<BoardDto> boards = new ArrayList<>();

    public void create(BoardDto board) {
        boards.add(board);
    }

    public List<BoardDto> selectAll() {
        return boards;
    }

    public BoardDto selectById(int bno) {
        for (BoardDto board : boards) {
            if (board.getBno() == bno) {
                return board;
            }
        }
        return null;
    }

    public boolean update(int bno, BoardDto newBoard) {
        for (int i = 0; i < boards.size(); i++) {
            if (boards.get(i).getBno() == bno) {
                BoardDto oldBoard = boards.get(i);

                if (newBoard.getTitle() != null) {
                    oldBoard.setTitle(newBoard.getTitle());
                }
                if (newBoard.getContent() != null) {
                    oldBoard.setContent(newBoard.getContent());
                }
                boards.set(i, oldBoard);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int bno) {
        for (int i = 0; i < boards.size(); i++) {
            if (boards.get(i).getBno() == bno) {
                boards.remove(i);
                return true;
            }
        }
        return false;
    }

    public BoardDto selectByBno(int bno) {
        for (BoardDto board : boards) {
            if (board.getBno() == bno) {
                return board;
            }
        }
        return null;
    }
}
