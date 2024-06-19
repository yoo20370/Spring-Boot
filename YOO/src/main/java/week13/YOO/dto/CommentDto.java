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
public class CommentDto {

    private int commentNum;

    private int boardNum;

    private String comment;

    private Date regdate;

    private String writer;
}
