package week13.YOO.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week13.YOO.dto.CommentDto;
import week13.YOO.repository.CommentMapper;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    public List<CommentDto> getCommentList(int boardnum){
        return commentMapper.getCommentListDB(boardnum);
    }

    public int insertComment(CommentDto commentDto){
        return commentMapper.insertCommentDB(commentDto);
    }

    public int deleteComment(int commentNum, String writer){
        HashMap map = new HashMap();
        map.put("commentNum", commentNum);
        map.put("writer", writer);
        return commentMapper.deleteCommentDB(map);
    }
}
