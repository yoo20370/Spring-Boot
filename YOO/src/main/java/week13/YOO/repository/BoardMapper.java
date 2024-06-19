package week13.YOO.repository;


import org.apache.ibatis.annotations.Mapper;
import week13.YOO.domain.BoardVO;
import week13.YOO.dto.BoardDto;
import week13.YOO.dto.PageHandler;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {

    public List<BoardVO> getBoardListDB(PageHandler ph);

    public BoardVO getBoardOneDB(int boardnum);

    public int insertBoardDB(BoardDto boardDto);

    public int recentRegiContent(String id);

    public int updateBoardDB(BoardDto board);

    public int deleteBoardDB(int boardnum);

    public int updateViewCnt(int boardNum);

}
