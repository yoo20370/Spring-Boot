package week13.YOO.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import week13.YOO.dto.CommentDto;
import week13.YOO.service.CommentService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment")
    @ResponseBody
    public ResponseEntity<List<CommentDto>> getCommentList(int boardnum){

        List<CommentDto> commentList = commentService.getCommentList(boardnum);

        return new ResponseEntity<List<CommentDto>>(commentList,HttpStatus.OK);
    }

    @PostMapping("/comment")
    @ResponseBody
    public ResponseEntity<String> insertComment(@RequestBody CommentDto commentDto, HttpSession session){
        String currUser = (String)session.getAttribute("userId");

        if(currUser == null) {
            return new ResponseEntity<String>("실패", HttpStatus.BAD_REQUEST);
        }
        commentDto.setWriter(currUser);
        System.out.println("commentDto = " + commentDto);

        commentService.insertComment(commentDto);

        return new ResponseEntity<String>("성공", HttpStatus.OK);
    }

    @DeleteMapping("/comment")
    @ResponseBody
    public ResponseEntity<String> deleteComment(int commentNum, String writer, HttpSession session){
        String currUser = (String)session.getAttribute("userId");
        if(!currUser.equals(writer)){
            return new ResponseEntity<String>("실패", HttpStatus.BAD_REQUEST);
        }
        commentService.deleteComment(commentNum, writer);

        return new ResponseEntity<String>("성공", HttpStatus.OK);
    }
}
