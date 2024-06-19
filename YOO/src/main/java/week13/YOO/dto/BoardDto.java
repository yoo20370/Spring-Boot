package week13.YOO.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BoardDto {

    // 게시판 번호
    private int boardNum;

    // 게시판 제목
    private String title;

    // 게시판 내용
    private String content;

    // 게시판 등록 날짜
    private Date regdate;

    // 게시판 조회수
    private int viewcnt;

    // 게시판 작성자
    private String writer;

}
