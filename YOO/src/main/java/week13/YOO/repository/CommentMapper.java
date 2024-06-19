package week13.YOO.repository;

import org.apache.ibatis.annotations.Mapper;
import week13.YOO.dto.CommentDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface CommentMapper {

    public List<CommentDto> getCommentListDB(int boardnum);

    public int insertCommentDB(CommentDto commentDto);

    public int deleteCommentDB(HashMap map);
}
