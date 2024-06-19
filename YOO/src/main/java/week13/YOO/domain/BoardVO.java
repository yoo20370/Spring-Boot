package week13.YOO.domain;

import lombok.Data;
import lombok.NonNull;
import java.util.Date;

@Data
public class BoardVO {


    // 게시판 번호(PK)
    @NonNull
    private int boardNum;
    // 게시판 제목
    @NonNull
    private String title;
    // 게시판 내용
    @NonNull
    private String content;
    // 게시판 등록 일자
    @NonNull
    private Date regdate;

    @NonNull
    private int viewcnt;
    // 게시판 작성자
    @NonNull
    private String writer;

    public BoardVO(@NonNull int boardNum, @NonNull String title, @NonNull String content, @NonNull Date regdate, @NonNull int viewcnt, @NonNull String writer) {
        this.boardNum = boardNum;
        this.title = title;
        this.content = content;
        this.regdate = regdate;
        this.viewcnt = viewcnt;
        this.writer = writer;
    }
}
