package week13.YOO.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import week13.YOO.domain.BoardVO;
import week13.YOO.dto.BoardDto;
import week13.YOO.dto.PageHandler;
import week13.YOO.service.BoardService;

import javax.servlet.http.HttpSession;
import java.util.List;

// final 붙은 거는 생성자로 주입해준다.
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    // 게시판 목록 페이지
    @GetMapping("/boardList")
    public String boardList(@ModelAttribute PageHandler pg, Model m){

        if(pg == null || pg.getPage() == 0 || pg.getPageSize() == 0){
            pg.setPage(1);
            pg.setPageSize(10);
        }

        List<BoardVO> boardList = boardService.getBoardList(pg);

        m.addAttribute("boardList", boardList);
        return "/board/boardList";
    }

    // 각 게시판으로 이동
    @GetMapping("/board")
    public String board(int boardnum, Model m ){

        boardService.updateViewCnt(boardnum);
        BoardVO boardOne = boardService.getBoardOne(boardnum);

        // 만약 찾는 게시물이 DB에 존재하지 않는다면
        if(boardOne == null){
            return "redirect:/boardList";
        }


        m.addAttribute("boardOne", boardOne);
        return "/board/board";
    }

    // 게시물 등록 페이지로 이동
    @GetMapping("/boardRegi")
    public String boardRegiPage(HttpSession session){
        String currUser = (String)session.getAttribute("userId");

        // 로그인 되지 않은 경우
        if(currUser == null){
            return "redirect:/login";
        }

        return "/board/boardregi";
    }

    // 게시판 등록
    @PostMapping("/board")
    public String boardRegi(@ModelAttribute BoardDto boardDto, RedirectAttributes m, HttpSession session){

        // 세션에서 로그인 된 정보 가져오기
        String currUser = (String)session.getAttribute("userId");
        // 게시물 등록을 위한 객체에 유저 아이디 저장
        boardDto.setWriter(currUser);

        // 로그인 되지 않은 경우
        if(currUser == null){
            return "redirect:/login";
        }

        // DB에 데이터 삽입
        if(boardService.insertBoard(boardDto) == 0){
            m.addAttribute("boardDto", boardDto);
            return "redirect:/boardRegi";
        }

        //  최근에 등록한 게시물 번호 가져오기 (가능하면 없는게 좋음)
        int boardnum  = boardService.recentRegiContentNum(currUser);

        m.addAttribute("boardnum" , boardnum);
        return "redirect:/board";
    }

    @GetMapping("/boardModify")
    public String boardModify(BoardDto boardDto, Model m){

        m.addAttribute("boardDto", boardDto);
        return "/board/boardModify";
    }

    @PostMapping("/board/update")
    public String boardModify(@ModelAttribute BoardDto boardDto, HttpSession session, RedirectAttributes m){
        String currUser = (String) session.getAttribute("userId");

        System.out.println("boardDto = " + boardDto);
        // 수행 후 게시판 번호 반환
        m.addAttribute("boardnum", boardDto.getBoardNum());

        // 현재 유저와 작성자가 틀리면 다시 게시물로 이동시킴
        if(!currUser.equals(boardDto.getWriter())){

            return "redirect:/board";
        }

        // 업데이트 수행
        boardService.updateBoard(boardDto);
        return "redirect:/board";
    }

    @PostMapping("/board/remove")
    public String boardDelete(int boardnum, String writer, RedirectAttributes m ,HttpSession session){
        String currUser = (String)session.getAttribute("userId");

        // 유저 체크
        if(!currUser.equals(writer)){
            m.addAttribute("boardnum", boardnum);
            return "redirect:/board";
        }

        boardService.deleteBoard(boardnum);

        return "redirect:/boardList";
    }
}



