package week13.YOO.service;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import week13.YOO.domain.BoardVO;
import week13.YOO.domain.UserVO;
import week13.YOO.dto.BoardDto;
import week13.YOO.dto.PageHandler;
import week13.YOO.dto.UserDto;
import week13.YOO.repository.BoardMapper;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardMapper boardMapper;

    // 게시판 리스트를 출력하기 위해 리스트를 가져온다.
    public List<BoardVO> getBoardList(PageHandler ph){
        return boardMapper.getBoardListDB(ph);
    }

    // 특정 게시판을 가져온다.
    public BoardVO getBoardOne(int boardnum){
        return boardMapper.getBoardOneDB(boardnum);
    }

    public int insertBoard(BoardDto boardDto){
        return boardMapper.insertBoardDB(boardDto);
    }

    public int recentRegiContentNum(String id){
        return boardMapper.recentRegiContent(id);
    }

    public int updateBoard(BoardDto boardDto){
        return boardMapper.updateBoardDB(boardDto);
    }

    public int deleteBoard(int boardnum){
        return boardMapper.deleteBoardDB(boardnum);
    }

    public int updateViewCnt(int boardNum){
        return boardMapper.updateViewCnt(boardNum);
    }
}
